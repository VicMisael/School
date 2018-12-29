/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Dificuldade;
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
 * @author Info3
 */
public class DificuldadeDAO {

    public List<Dificuldade> ListarDificuldades() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Dificuldade> dificuldades = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dificuldade";
            statement = con.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Dificuldade dif = new Dificuldade();
                dif.setId(rs.getInt(1));
                dif.setDificuldade(rs.getString(2));
                dificuldades.add(dif);

            }
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao Listar Dificuldades \n" + ex);
        }finally{
        Conexao.FecharConexao(con);
        }
        return dificuldades;
    }
}
