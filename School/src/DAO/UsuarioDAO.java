/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Disciplina;
import Model.ProfessorDisciplina;
import Model.Session;
import Model.Usuario;
import criptotest.encriptar;
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
public class UsuarioDAO {

    static final int IDPROF = 2;

    public void criarUsuario(Usuario user, ArrayList disciplinas) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement("Insert into usuario(nome,login,senha,tipoUsuarioId)values(?,?,?,?)", statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getLogin());
            statement.setString(3, String.valueOf(user.getSenha()));
            statement.setInt(4, IDPROF);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ProfessorDisciplinaDAO profDisc = new ProfessorDisciplinaDAO();
            profDisc.AdicionarDisciplina(disciplinas, id);

            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }
    }

    /*
    public List<Usuario> ListarUsuario() {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();
        Usuario a=new Usuario();
        try {
            statement = con.prepareStatement("SELECT u.nome ,d.nomeMateria FROM disciplina as d inner join professordisciplina as pf on d.idDisciplina = pf.idDisciplina inner join usuario as u on pf.Idusuario = u.idusuario");
            rs = statement.executeQuery();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Professores" + ex);
        }
        return usuarios;
    }
     */
    public Usuario getUsuarioByIdprof(int idProf) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;

        Usuario usuario = new Usuario();

        try {
            statement = con.prepareStatement("SELECT * from usuario where idusuario=" + idProf);
            rs = statement.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Professores" + ex);
        }
        return usuario;

    }

    public Usuario Logar(String login, String senha) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        ResultSet rs = null;
        Usuario user = new Usuario();
        boolean logar = false;

        try {
            statement = con.prepareStatement("Select * From usuario where login = ? and senha = ?");
            statement.setString(1, login);
            statement.setString(2, encriptar.encriptarTexto(senha));

            rs = statement.executeQuery();

            if (rs.next()) {
                user.setIdUsuario(rs.getInt("idusuario"));
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));
                user.setTipo(rs.getInt("tipoUsuarioId"));
                user.setSenha(rs.getString("senha"));
                logar = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Logar \n" + ex);
        }
        if (logar) {
            return user;
        } else {
            return null;
        }
    }

    public void AtualizarUsuario(Usuario antigo, Usuario novo) {
        Connection con = Conexao.getCon();
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement("update usuario set nome=?,login=?,senha=?  where login=?");
            statement.setString(1, novo.getNome());
            statement.setString(2, novo.getLogin());
            statement.setString(3, novo.getSenha());
            statement.setString(4, antigo.getLogin());
            statement.executeUpdate();
            Session.getInstance().setUsuario(Logar(novo.getLogin(), novo.getSenha()));//Coloca o usuario novo na sessão
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            /*ex.printStackTrace(); nao achei necessario*/
            JOptionPane.showMessageDialog(null, "Erro ao salvar \n" + ex);
        } finally {
            Conexao.FecharConexao(con);
        }

    }
}
