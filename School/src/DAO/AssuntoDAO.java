/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Assunto;
import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Informática 3
 */
public class AssuntoDAO {

    public void criarAssunto(Assunto as) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("insert into assunto(nome,idDisciplina) values(?,?)");
            statement.setString(1, as.getNome());
            statement.setInt(2, as.getIdDisciplina());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");

        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }
    }

    public List<Assunto> listarAssunto(int idUsuario) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Assunto> assuntos = new ArrayList<>();
        try {
            statement = con.prepareStatement("select s.idAssunto , d.idDisciplina,  d.nomeMateria , s.nome\n"
                    + "from professordisciplina as pd \n"
                    + "inner JOIN disciplina as d \n"
                    + "on pd.idDisciplina = d.idDisciplina \n"
                    + "inner join assunto as s \n"
                    + "on s.idDisciplina = d.idDisciplina \n"
                    + "where pd.IdUsuario =" + idUsuario);
            rs = statement.executeQuery();

            while (rs.next()) {
                Assunto as = new Assunto();
                as.setIdAssunto(rs.getInt("idAssunto"));
                as.setNome(rs.getString("nome"));
                as.setIdDisciplina(rs.getInt("idDisciplina"));
                as.setNomeDisciplina(rs.getString("nomeMateria"));
                assuntos.add(as);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar assuntos" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return assuntos;
    }

    public List<Assunto> listarAssunto(int idUsuario, String assunto, String disciplina) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Assunto> assuntos = new ArrayList<>();
        try {
            statement = con.prepareStatement("select s.idAssunto , d.idDisciplina,  d.nomeMateria , s.nome\n"
                    + "from professordisciplina as pd \n"
                    + "inner JOIN disciplina as d \n"
                    + "on pd.idDisciplina = d.idDisciplina \n"
                    + "inner join assunto as s \n"
                    + "on s.idDisciplina = d.idDisciplina \n"
                    + "where pd.IdUsuario =" + idUsuario + " and nomeMateria like '" + disciplina + "%' \n"
                    + "and nome like '" + assunto + "%'");
            rs = statement.executeQuery();

            while (rs.next()) {
                Assunto as = new Assunto();
                as.setIdAssunto(rs.getInt("idAssunto"));
                as.setNome(rs.getString("nome"));
                as.setIdDisciplina(rs.getInt("idDisciplina"));
                as.setNomeDisciplina(rs.getString("nomeMateria"));
                assuntos.add(as);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar assuntos \n" + ex + "\n contate o desenvolvedor");
        } finally {
            Conexao.FecharConexao(con);
        }
        return assuntos;
    }

    public List<Assunto> listarAssuntoByIdDisciplina(int id) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Assunto> assuntos = new ArrayList<>();
        try {
            String sql = "select s.idAssunto , d.idDisciplina,  d.nomeMateria , s.nome  from disciplina as d,assunto as s where  s.IdDisciplina=d.IdDisciplina\n"
                    + "and d.idDIsciplina=" + id;
            statement = con.prepareStatement(sql);
    //            System.out.println("\n" + sql);

            rs = statement.executeQuery();

            while (rs.next()) {
                Assunto as = new Assunto();
                as.setIdAssunto(rs.getInt("idAssunto"));
                as.setNome(rs.getString("nome"));
                as.setIdDisciplina(rs.getInt("idDisciplina"));
                as.setNomeDisciplina(rs.getString("nomeMateria"));
                assuntos.add(as);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar assuntos \n" + ex + "\n contate o desenvolvedor");
        } finally {
            Conexao.FecharConexao(con);
        }
        return assuntos;

    }

    public void deleteAssunto(int id) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("delete from assunto where idAssunto=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao deletar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public Assunto getAssuntoByAssuntoId(int idAssunto) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Assunto as = new Assunto();
        try {
            statement = con.prepareStatement("select s.idAssunto , d.idDisciplina,  d.nomeMateria , s.nome\n"
                    + "from professordisciplina as pd \n"
                    + "inner JOIN disciplina as d \n"
                    + "on pd.idDisciplina = d.idDisciplina \n"
                    + "inner join assunto as s \n"
                    + "on s.idDisciplina = d.idDisciplina \n"
                    + "where s.IdAssunto =" + idAssunto);
            rs = statement.executeQuery();

            if (rs.next()) {

                as.setIdAssunto(rs.getInt("idAssunto"));
                as.setNome(rs.getString("nome"));
                as.setIdDisciplina(rs.getInt("idDisciplina"));
                as.setNomeDisciplina(rs.getString("nomeMateria"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar assuntos" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return as;
    }

    public void atualizarAssunto(Assunto as) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            String sql = "update assunto set nome=?,idDisciplina=? where idAssunto=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, as.getNome());
            statement.setInt(2, as.getIdDisciplina());
            statement.setInt(3, as.getIdAssunto());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar assunto \n" + ex + "\n Contate o desenvolvedor");
        } finally {
            Conexao.FecharConexao(con);
        }
    }
}
