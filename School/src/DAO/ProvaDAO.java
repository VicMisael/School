/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Prova;
import Model.Questao;
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
public class ProvaDAO {
    
    public void inserirProva(Prova p) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        
        try {
            String sql = "INSERT INTO PROVA(data,nome,idProfessor)values(?,?,?)";
            statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getData());
            statement.setString(2, p.getNome());
            statement.setInt(3, p.getUsuarioCriadorId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int idprova = rs.getInt(1);
                cadastrarQuestoes(p.getQuestoes(), idprova);
            }
            
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        
    }
    
    private void cadastrarQuestoes(List<Questao> quest, int idProva) throws SQLException {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        System.out.println("numero de questões:" + quest.size());
        for (Questao q : quest) {
            String sql = "insert into prova_questao(questao_idQuestao,Prova_idProva,numquestao)"
                    + " values (?,?,?)";
            
            statement = con.prepareStatement(sql);
            statement.setInt(1, q.getIdQuestao());
            statement.setInt(2, idProva);
            statement.setInt(3, q.getNumero());
            statement.executeUpdate();
            // System.out.println("Estado :" + statement.executeUpdate());
        }
    }
    
    public List<Prova> selectProvasByIdProfessor(int idProf) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Prova> provas = new ArrayList<>();
        try {
            String sql = "select * from prova where idProfessor=" + idProf;
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Prova p = new Prova();
                p.setIdProva(rs.getInt("idProva"));
                p.setData(rs.getString("Data"));
                p.setNome(rs.getString("nome"));
                p.setUsuarioCriadorId(rs.getInt("idProfessor"));
                p.setQuestoes(new QuestaoDAO().getQuestoesByProvaId(rs.getInt("idProva")));
                provas.add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar\n" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
        return provas;
    }
    
    public Prova getProva(int idProva) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Prova p = new Prova();
        try {
            String sql = "select * from prova where idProva=" + idProva;
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                p.setData(rs.getString("Data"));
                p.setNome(rs.getString("Nome"));
                p.setUsuarioCriadorId(rs.getInt("idProfessor"));
                p.setIdProva(rs.getInt("idprova"));
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexao.FecharConexao(con);
        }
        return p;
        
    }
    
}
