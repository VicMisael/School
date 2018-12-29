/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Disciplina;
import Model.ProfessorDisciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class ProfessorDisciplinaDAO {

    public void AdicionarDisciplina(ArrayList<Integer> disciplinas, int id) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;

        try {
            for (int disc : disciplinas) {
                statement = con.prepareStatement("Insert into ProfessorDisciplina(idDisciplina,Idusuario)values(?,?)");
                statement.setInt(1, disc);
                statement.setInt(2, id);

                statement.executeUpdate();
            }

        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar \n" + ex);
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public void AdicionarDisciplina(int disciplina, int idProf) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement("Insert into ProfessorDisciplina(idDisciplina,Idusuario)values(?,?)");
            statement.setInt(1, disciplina);
            statement.setInt(2, idProf);

            statement.executeUpdate();

        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar \n" + ex);
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public List<ProfessorDisciplina> listarProfessor() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<ProfessorDisciplina> consultProf = new ArrayList<>(); //vetor onde vai ser passado os dados para a tabela
        try {
            statement = con.prepareStatement("SELECT pf.idProfDisc , u.nome ,d.nomeMateria FROM disciplina as d inner join professordisciplina as pf on d.idDisciplina = pf.idDisciplina inner join usuario as u on pf.Idusuario = u.idusuario");
            rs = statement.executeQuery();

            while (rs.next()) {
                ProfessorDisciplina consultarProfessor = new ProfessorDisciplina();
                consultarProfessor.setDisciplina(rs.getString("nomeMateria"));
                consultarProfessor.setNome(rs.getString("nome"));
                consultarProfessor.setIdProfDic(rs.getInt("idProfDisc"));
                consultProf.add(consultarProfessor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return consultProf;
    }

    public List<ProfessorDisciplina> listarProfessor(String nome) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<ProfessorDisciplina> consultProf = new ArrayList<>(); //vetor onde vai ser passado os dados para a tabela

        try {
            String sql = "SELECT pf.idProfDisc , u.nome ,d.nomeMateria FROM disciplina as d inner join professordisciplina as pf on d.idDisciplina = pf.idDisciplina inner join usuario as u on pf.Idusuario = u.idusuario where nome like '" + nome + "%'";
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                ProfessorDisciplina consultarProfessor = new ProfessorDisciplina();
                consultarProfessor.setDisciplina(rs.getString("nomeMateria"));
                consultarProfessor.setNome(rs.getString("nome"));
                consultarProfessor.setIdProfDic(rs.getInt("idProfDisc"));
                consultProf.add(consultarProfessor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return consultProf;
    }

    public List<ProfessorDisciplina> listarMateria(String nome) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<ProfessorDisciplina> consultMat = new ArrayList<>(); //vetor onde vai ser passado os dados para a tabela

        try {
            String sql = "SELECT pf.idProfDisc , u.nome ,d.nomeMateria FROM disciplina as d inner join professordisciplina as pf on d.idDisciplina = pf.idDisciplina inner join usuario as u on pf.Idusuario = u.idusuario where nomeMateria  like '" + nome + "%'";
            //System.out.println(sql);
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                ProfessorDisciplina consultarProfessor = new ProfessorDisciplina();
                consultarProfessor.setDisciplina(rs.getString("nomeMateria"));
                consultarProfessor.setNome(rs.getString("nome"));
                consultarProfessor.setIdProfDic(rs.getInt("idProfDisc"));
                consultMat.add(consultarProfessor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Materias" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return consultMat;
    }

    public void DeleteDisciplinaProfessor(ProfessorDisciplina profDisc) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("delete from professordisciplina where idProfDisc = ?");
            statement.setInt(1, profDisc.getIdProfDic());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao deletar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public void DeleteDisciplinaProfessor(int idDisciplina, int iduser) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("delete from professordisciplina where idDisciplina=? and idUsuario=?");
            statement.setInt(1, idDisciplina);
            statement.setInt(2, iduser);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao deletar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public List<Disciplina> ListarDisciplinaDeProfessor(int Usuario) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Disciplina> Disciplinas = new ArrayList<>();

        try {
            String sql = "SELECT d.idDisciplina , d.nomeMateria from professordisciplina as pd inner join disciplina as d on pd.idDisciplina = d.idDisciplina where pd.Idusuario = " + Usuario;
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Disciplina disc = new Disciplina();
                disc.setId(rs.getInt("idDisciplina"));
                disc.setDisciplina(rs.getString("nomeMateria"));

                Disciplinas.add(disc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exibir disciplina" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

        return Disciplinas;
    }

    public int getIdprofessorfromProfessorDisciplina(int idDisc) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int id = -1;
        try {
            statement = con.prepareStatement("SELECT idusuario from professordisciplina where idProfDisc=?");
            statement.setInt(1, idDisc);
            rs = statement.executeQuery();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão \n" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

        return id;
    }

    public List<Disciplina> getDisciplinasByIdusuario(int idUsuario) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Disciplina> resultado = new ArrayList<>(); //vetor onde vai ser passado os dados para a tabela

        try {
            String sql = "select pd.idDisciplina,d.nomemateria from professordisciplina as pd, disciplina as d where pd.idDisciplina=d.idDisciplina and pd.IdUsuario=?";
            //System.out.println(sql);

            statement = con.prepareStatement(sql);
            statement.setInt(1, idUsuario);
            rs = statement.executeQuery();
            while (rs.next()) {
                Disciplina a = new Disciplina();
                a.setId(rs.getInt(1));
                a.setDisciplina(rs.getString(2));
                resultado.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Materias\n" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return resultado;

    }

    public List<Integer> getProfessorIdListByDisciplinaEnsinada(int idDisciplina) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs;
        List<Integer> ids = new ArrayList<>();

        try {
            String sql = "select idUsuario from professordisciplina where idDisciplina=" + idDisciplina;
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                ids.add(id);
            }
        } catch (SQLException ex) {

        } finally {
            Conexao.FecharConexao(con);
        }
        return ids;
    }

}
