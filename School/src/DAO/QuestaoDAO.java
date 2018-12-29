/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Questao;
import Model.QuestaoDescritiva;
import Model.QuestaoMultiplaEscolha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Informática 3
 */
public class QuestaoDAO {

    public void cadastrarQuestaoDescritiva(QuestaoDescritiva questao) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("insert into questao(Enunciado,resposta,idAssunto,idDificuldade) values(?,?,?,?)");
            statement.setString(1, questao.getEnunciado());
            statement.setString(2, questao.getResposta());
            statement.setInt(3, questao.getIdAssunto());
            statement.setInt(4, questao.getDificuldade());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar\n" + ex);
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    private void alterarItens(String[] itens, Connection con, char gabarito, int idquestao) throws SQLException, ArrayIndexOutOfBoundsException {
        PreparedStatement statement = null;
        String sql = "update itens set a=?,b=?,c=?,d=?,e=?,correto=? where questao_idQuestao=" + idquestao;
        statement = con.prepareStatement(sql);
        statement.setString(1, itens[0]);
        statement.setString(2, itens[1]);
        statement.setString(3, itens[2]);
        statement.setString(4, itens[3]);
        statement.setString(5, itens[4]);
        statement.setString(6, Character.toString(gabarito));
        statement.executeUpdate();
        //return;
    }

    public void alterarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            String sql = "update questao set enunciado=?,idAssunto=?,iddificuldade=? where"
                    + " idQuestao=" + questao.getIdQuestao();
            statement = con.prepareStatement(sql);
            statement.setString(1, questao.getEnunciado());
            statement.setInt(2, questao.getIdAssunto());
            statement.setInt(3, questao.getDificuldade());
            statement.executeUpdate();
            System.out.println(statement.getUpdateCount());
            alterarItens(questao.getItens(), con, questao.getGabarito(), questao.getIdQuestao());

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException | ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public void cadastrarQuestaoMultiplaEscolha(QuestaoMultiplaEscolha questao) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("insert into questao(Enunciado,idAssunto,idDificuldade) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, questao.getEnunciado());
            statement.setInt(2, questao.getIdAssunto());
            statement.setInt(3, questao.getDificuldade());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cadastrarItens(questao.getItens(), id, questao.getGabarito(), con);
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar\n" + ex);
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    private String[] getItens(int questaoid) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String[] itens = new String[6];
        //a=0,b=1,c=2,d=3,e=4,gabarito=5
        try {
            String sql = "Select * from itens where questao_idquestao=" + questaoid;
            // System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                itens[0] = rs.getString("a");
                itens[1] = rs.getString("b");
                itens[2] = rs.getString("c");
                itens[3] = rs.getString("d");
                itens[4] = rs.getString("e");
                itens[5] = rs.getString("correto");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return itens;
    }

    public QuestaoMultiplaEscolha getQuestaoMultiplaEscolha(int questaoId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        QuestaoMultiplaEscolha a = new QuestaoMultiplaEscolha();
        try {
            String sql = "Select * from questao where idquestao=" + questaoId;
            //System.out.println("multipla escolha script:" + sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                a.setEnunciado(rs.getString("Enunciado"));
                a.setIdQuestao(rs.getInt("IdQuestao"));
                a.setIdAssunto(rs.getInt("IdAssunto"));
                a.setDificuldade(rs.getInt("iddificuldade"));
                int i = 0;
                String[] itensSemGabarito = new String[5];
                for (String item : this.getItens(questaoId)) {
                    if (i == 5) {
                        break;
                    }
                    itensSemGabarito[i] = item;
                    i++;

                }
                a.setItens(itensSemGabarito);
                a.setGabarito((getItens(questaoId)[5]).charAt(0));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public QuestaoDescritiva getQuestaoById(int questaoID) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        QuestaoDescritiva a = new QuestaoDescritiva();
        try {
            String sql = "Select * from questao where idquestao=" + questaoID;
            //        System.out.println("Script questao descritiva:" + sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                a.setEnunciado(rs.getString("Enunciado"));
                a.setResposta(rs.getString("resposta"));
                a.setIdQuestao(rs.getInt("IdQuestao"));
                a.setIdAssunto(rs.getInt("IdAssunto"));
                a.setDificuldade(rs.getInt("iddificuldade"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return a;
    }

    public int[] getQuestaoIdList(int dificuldadeid, int assuntoId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Integer> questoes = new ArrayList<>();
        try {
            String sql = "Select idQuestao from questao ";
            if (dificuldadeid != -1 || assuntoId != -1) {
                sql += "where ";
            }
            boolean and = false;
            if (dificuldadeid != -1) {
                sql += " iddificuldade=" + dificuldadeid + " ";
                and = true;
            }
            if (assuntoId != -1) {
                if (and) {
                    sql += "and ";
                }
                sql += "idAssunto=" + assuntoId;

            }

            // System.out.println(sql);
            statement = con.prepareStatement(sql);

            rs = statement.executeQuery();
            while (rs.next()) {
                questoes.add(rs.getInt("idQuestao"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro \n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);

        }
        int[] numerosQuest = new int[questoes.size()];
        int i = 0;
        for (Integer num : questoes) {
            numerosQuest[i] = num;
            i++;
        }
        return numerosQuest;
    }

    private void cadastrarItens(String[] itens, int idquestao, char gabarito, Connection con) throws SQLException {

        PreparedStatement statement = null;

        statement = con.prepareStatement("insert into itens set questao_idQuestao=?, a=?, b=?, c=?, d=?,"
                + " e=?,correto=?");
        int index = 1;
        statement.setInt(index, idquestao);
        index++;
        for (int i = 0; i < itens.length; i++) {
            statement.setString(index, itens[i]);
            index++;
        }

        statement.setString(7, String.valueOf(gabarito));
        statement.executeUpdate();

    }

    public List<Questao> listarQuestao(int idAssunto) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Questao> questoes = new ArrayList<>();
        try {
            String sql = "SELECT q.idQuestao,q.Enunciado,d.dificuldade "
                    + "FROM questao as q,dificuldade as d where d.iddificuldade=q.iddificuldade and q.idAssunto=?";
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            statement.setInt(1, idAssunto);
            rs = statement.executeQuery();
            while (rs.next()) {
                Questao a = new Questao();
                a.setIdQuestao(rs.getInt("idQuestao"));
                a.setEnunciado(rs.getString("Enunciado"));
                a.setDificuldadeString(rs.getString("dificuldade"));
                questoes.add(a);
            }

        } catch (SQLException ex) {
            System.out.println("Erro \n" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);

        }
        return questoes;

    }

    public void deleteQuestaoById(int idQuestao) {

        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            if (checkIfHasItens(idQuestao, con)) {
                deleteItens(idQuestao, con);
            }
            String sql = "delete from questao where idquestao=" + idQuestao;
            statement = con.prepareStatement(sql);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao deletar \n" + ex.toString());

        } finally {
            Conexao.FecharConexao(con);
        }
    }

    private void deleteItens(int idQuestao, Connection con) throws SQLException {
        PreparedStatement statement = null;
        String sql = "Delete from itens where questao_idQuestao=" + idQuestao;
        statement = con.prepareStatement(sql);
        statement.executeUpdate();

    }

    public boolean checkIfHasItens(int idQuestao) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        boolean teste = false;
        try {
            String sql = "select * from itens where questao_idQuestao=" + idQuestao;
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            teste = rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }
        return teste;
        //Retorna true se tiver item, false se não tiver
    }

    private boolean checkIfHasItens(int idQuestao, Connection con) throws SQLException {

        PreparedStatement statement = null;

        String sql = "select * from itens where questao_idQuestao=" + idQuestao;
        statement = con.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        return rs.next();

    }

    public void atualizarQuestaoDescritiva(QuestaoDescritiva q) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            String sql = "update questao set enunciado=?,resposta=?,idAssunto=?,iddificuldade=? where"
                    + " idQuestao=" + q.getIdQuestao();
            statement = con.prepareStatement(sql);
            statement.setString(1, q.getEnunciado());
            statement.setString(2, q.getResposta());
            statement.setInt(3, q.getIdAssunto());
            statement.setInt(4, q.getDificuldade());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
    }

    public List<Questao> getQuestoesByProvaId(int provaId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Questao> questoes = new ArrayList<>();
        try {
            String sql = "Select questao_idQuestao from prova_questao where prova_idprova=" + provaId;
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int idQuest = rs.getInt("questao_idQuestao");
                Questao a = (Questao) this.getQuestaoById(idQuest);
                questoes.add(a);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return questoes;
    }

    public List<Integer> getQuestoesIdByProvaId(int provaId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Integer> questoes = new ArrayList<>();
        try {
            String sql = "Select questao_idQuestao from prova_questao where prova_idprova=" + provaId;
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int idQuest = rs.getInt("questao_idQuestao");
                questoes.add(idQuest);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return questoes;
    }

    public List<Questao> getQuestoesIdAndNumByProvaId(int provaId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Questao> questoes = new ArrayList<>();
        try {
            String sql = "Select questao_idQuestao,numQuestao from prova_questao where prova_idprova=" 
                    + provaId+" order by numQuestao";
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Questao a=new Questao();
                int idquestao = rs.getInt("questao_idQuestao");
                int numero=rs.getInt("numQuestao");
                a.setIdQuestao(idquestao);
                a.setNumero(numero);
                questoes.add(a);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return questoes;
    }

    //    public List<QuestaoMultiplaEscolha> getQuestoesMultiplaEscolha(int assuntoId, int dificuldadeid) {
//        Connection con = Conexao.getCon();
//        PreparedStatement statement = null;
//        ResultSet rs = null;
//        List<QuestaoMultiplaEscolha> questoes = new ArrayList<>();
//        try {
//            String sql = "Select * from questao ";
//            if (!(dificuldadeid == -1 && assuntoId == -1)) {
//                sql += "where ";
//                boolean and = false;
//                if (dificuldadeid != -1) {
//                    sql += " iddificuldade=" + dificuldadeid + " ";
//                    and = true;
//                }
//                if (assuntoId != -1) {
//                    if (and) {
//                        sql += "and ";
//                    }
//                    sql += "idAssunto=" + assuntoId;
//
//                }
//            }
//            System.out.println(sql);
//            statement = con.prepareStatement(sql);
//            rs = statement.executeQuery();
//            while (rs.next()) {
//                QuestaoMultiplaEscolha a = new QuestaoMultiplaEscolha();
//                a.setEnunciado(rs.getString("Enunciado"));
//                a.setIdQuestao(rs.getInt("IdQuestao"));
//                a.setIdAssunto(rs.getInt("IdAssunto"));
//                a.setDificuldade(rs.getInt("iddificuldade"));
//                int i = 0;
//                String[] itensSemGabarito = new String[5];
//                for (String item : this.getItens(a.getIdQuestao())) {
//                    if (i == 5) {
//                        break;
//                    }
//                    itensSemGabarito[i] = item;
//                    i++;
//
//                }
//                a.setItens(itensSemGabarito);
//                a.setGabarito((getItens(a.getIdQuestao())[5]).charAt(0));
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return questoes;
//    }
}
