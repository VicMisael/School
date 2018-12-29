/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Informática 3
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/prova";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getCon() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            erro();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            erro();
        }
        return null;
    }

    private static void erro() {
        JOptionPane.showMessageDialog(null, "Erro na conexão", "Sistema de provas", JOptionPane.ERROR_MESSAGE);

    }

    public static void FecharConexao(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /* public static Connection getCon() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conectado com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão", "Sistema Prova", JOptionPane.ERROR_MESSAGE);
            ex.getMessage();
        }
        return con;
    }*/
}
