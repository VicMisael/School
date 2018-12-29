/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.UsuarioDAO.IDPROF;
import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Informática 3
 */
public class DisciplinaDAO {

    public void criarDisciplina(Disciplina dis) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("Insert into disciplina(nomeMateria) values (?)");
            statement.setString(1, dis.getDisciplina());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public List<Disciplina> listarDisciplina() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Disciplina> disciplinas = new ArrayList<>(); //vetor onde vai ser passado os dados para a tabela

        try {
            statement = con.prepareStatement("SELECT * FROM disciplina order by IdDisciplina");
            rs = statement.executeQuery();

            while (rs.next()) {
                Disciplina disc = new Disciplina();
                disc.setId(rs.getInt("idDisciplina"));
                disc.setDisciplina(rs.getString("nomeMateria"));
                disciplinas.add(disc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return disciplinas;
    }

    public List<Disciplina> ListarDisciplinaPorNome(String nome) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Disciplina> disciplinas = new ArrayList<>();//Array list

        try {
            String pesquisa = "SELECT * FROM disciplina where nomeMateria like '" + nome + "%' order by IdDisciplina";
            statement = con.prepareStatement(pesquisa);
            rs = statement.executeQuery();
            while (rs.next()) {
                Disciplina disc = new Disciplina();
                disc.setId(rs.getInt("idDisciplina"));
                disc.setDisciplina(rs.getString("nomeMateria"));
                disciplinas.add(disc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

        return disciplinas;
    }

    public void DeleteDisciplina(Disciplina dis) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("delete from disciplina where idDisciplina = ?");
            statement.setInt(1, dis.getId());

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deletado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao deletar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public String getDisciplinaNome(int id) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        String nomedisc = null;//nome da disciplina

        try {
            statement = con.prepareStatement("SELECT nomeMateria FROM disciplina where idDisciplina='" + id + "'");
            rs = statement.executeQuery();
            rs.next();
            nomedisc = rs.getString("nomeMateria");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return nomedisc;

    }

    public void AtualizarDisciplina(int id, String nomeatual) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("update Disciplina set nomeMateria=? where idDisciplina=?");
            System.out.println(nomeatual);
            statement.setString(1, nomeatual);
            statement.setInt(2, id);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public int getDisciplinaIdByAssuntoId(int assuntoId) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        int iddisc = -1;//id da disciplina
        

        try {
            statement = con.prepareStatement("select idDisciplina from assunto where idAssunto=" + assuntoId);
            rs = statement.executeQuery();
            rs.next();
            iddisc = rs.getInt("idDisciplina");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Disciplinas" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return iddisc;

    }

}
