/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import criptotest.encriptar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael
 */
public class DAOtest {

    private static final int IDADM = 1;

    private DAOtest() {
    }

    public static boolean testarCadastroAdmin() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            statement = con.prepareStatement("Select * From usuario where tipoUsuarioid=?");
            statement.setInt(1, IDADM);
            rs = statement.executeQuery();
            resultado = !rs.next();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha no teste de cadastro \n " + ex);
        }
        return resultado;//retorna false se  houver admins cadastrados
    }

    public static boolean testarCadastroTipoUsuario() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            statement = con.prepareStatement("Select * From Tipousuario");
            rs = statement.executeQuery();
            resultado = !rs.next();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha no teste de cadastro \n " + ex);
        }
        return resultado;//retorna false se houver tipos de usuario cadastrados
    }

    public static boolean testarCadastroDeDificuldade() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            statement = con.prepareStatement("Select * From dificuldade");
            rs = statement.executeQuery();
            resultado = !rs.next();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "falha no teste de cadastro \n " + ex);
        }
        return resultado;

    }

    public static void cadastrarTiposdeUsuarios() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        final String[] inserts = {"Administrador", "Professor"};
        try {
            int i = 1;
            for (String insert : inserts) {

                statement = con.prepareStatement("Insert into tipousuario(idTipoUsuario,nome) values (?,?)");

                statement.setInt(1, i);
                System.out.println(insert);
                statement.setString(2, insert);
                statement.executeUpdate();
                i++;
            }
            System.out.println("cadastrado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public static void cadastrarDificuldades() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        final String[] inserts = {"Não especificada", "Fácil", "Médio", "Difícil"};
        int i = 1;
        try {

            for (String insert : inserts) {

                statement = con.prepareStatement("Insert into dificuldade(idDificuldade,dificuldade) values (?,?)");

                statement.setInt(1, i);
                System.out.println(insert);
                statement.setString(2, insert);
                statement.executeUpdate();
                i++;
            }
            System.out.println("cadastrado com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

    public static void cadastrarADMPadrao() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Insert into usuario(nome,login,senha,tipoUsuarioId)values(?,?,?,?)");
            statement.setString(1, "Administrador");
            statement.setString(2, "adm");
            statement.setString(3, encriptar.encriptarTexto("123"));
            statement.setInt(4, IDADM);
            statement.executeUpdate();

            System.out.println("cadastrado com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }

}
