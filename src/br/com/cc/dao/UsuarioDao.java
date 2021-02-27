/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.dao;

import br.com.cc.connection.ConnectionFactory;
import br.com.cc.model.Usuario;
import br.com.cc.view.TelaLogin;
import br.com.cc.view.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author alafaria
 */
public class UsuarioDao {
    
    private Connection con;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    
    public UsuarioDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void logarUsuario(String usuario, String senha){
        try {
            String sql = "select * from usuarios where usuario = ? and senha = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Seja bem vindo " + usuario + ".");
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto!");
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        String sql = "insert into usuarios (nome, usuario, senha) values (?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNomeCompleto() + " incluído com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco de dados!");
            throw new RuntimeException(sqle);
        }
    }

    public ArrayList<Usuario> listaUsuarioTabela() {
        String sql = "select * from usuarios";
        ArrayList<Usuario>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeCompleto(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<Usuario> listarUsuarioPorNome(String nome) {
        String sql = "select * from usuarios where nome like '%" + nome + "%'";
        ArrayList<Usuario>lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNomeCompleto(rs.getString("nome"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setSenha(rs.getString("senha"));
                lista.add(usuario);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public void excluirUsuario(String id) {
        String sql = "delete from usuarios where id_usuario = " + "'" + id + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Usuário " + id + " excluído com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário.");
            throw new RuntimeException(sqle);
        }
    }

    public void alterarUsuario(Usuario usuario) {
        String sql = "update usuarios set nome = ?, usuario = ?, senha = ? where id_usuario = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário " + usuario.getNomeCompleto() + " alterado com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário!");
            throw new RuntimeException(sqle);
        }
    }
    
}
