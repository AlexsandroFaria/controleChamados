/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import br.com.cc.connection.ConnectionFactory;
import br.com.cc.model.Chamado;
import br.com.cc.model.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class ClienteDao {

    private Connection con;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;

    public ClienteDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarClientes(String contrato, Cliente cliente) {
        try {
            String sqlConsulta = "select * from clientes where contrato = ?";
            stmt = con.prepareStatement(sqlConsulta);
            stmt.setString(1, contrato);
            rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Contrato do cliente já existe!");
            }else{
                String sql = "insert into clientes (contrato, nome_cliente, endereco, contato, telefone, email) values (?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, cliente.getContrato());
                stmt.setString(2, cliente.getNomeCliente());
                stmt.setString(3, cliente.getEndereco());
                stmt.setString(4, cliente.getContato());
                stmt.setString(5, cliente.getTelefone());
                stmt.setString(6, cliente.getEmail());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Cliente Contrato " + cliente.getContrato() + " Cadastrado com sucesso!");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente no Banco!", "AVISO", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException(sqle);
        }
    }

    public ArrayList<Cliente> listarClientesTabela() {
        String sql = "select * from clientes";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdClientes(rs.getInt("id_clientes"));
                cliente.setContrato(rs.getInt("contrato"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public void excluirCliente(int contrato) {
        String sql = "delete from clientes where contrato = " + "'" + contrato + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Cliente contrato " + contrato + " foi excluido com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário!");
            throw new RuntimeException();
        }
    }

    public void alterarCliente(Cliente cliente) {
        String sqlCliente = "update clientes set nome_cliente = ?, endereco = ?, contato = ?, telefone = ?, email = ? where contrato = ?";
        try {
            stmt = con.prepareStatement(sqlCliente);
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getContato());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setInt(6, cliente.getContrato());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente contrato " + cliente.getContrato() + " foi alterado com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente");
            throw new RuntimeException(sqle);
        }
    }

    public ArrayList<Cliente> listarClientesTabelaPorNome(String nome) {
        String sql = "select * from clientes where nome_cliente like '%" + nome + "%'";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setContrato(rs.getInt("contrato"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<Cliente> listarClientesTabelaPorContrato(String contrato) {
        String sql = "select * from clientes where contrato like '%" + contrato + "%'";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setContrato(rs.getInt("contrato"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<Cliente> listarClientesContrato() {
        String sql = "select * from clientes where contrato like = ?";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdClientes(rs.getInt("id_clientes"));
                cliente.setContrato(rs.getInt("contrato"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

}
