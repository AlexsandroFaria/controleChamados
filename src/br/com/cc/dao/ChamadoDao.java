/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.dao;

import br.com.cc.connection.ConnectionFactory;
import br.com.cc.model.Chamado;
import br.com.cc.model.ChamadosFechados;
import br.com.cc.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class ChamadoDao {

    private Connection con;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;

    public ChamadoDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public ArrayList<Cliente> listarClientesPorContrato(String contrato) {
        String sql = "select * from clientes where contrato like '%" + contrato + "%'";
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setContrato(rs.getInt("contrato"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setContato(rs.getString("contato"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado! Favor cadastrar no menu Clientes.", "AVISO", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<Chamado> listarChamadoTabela() {
        String sql = "select * from chamados";
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setEndereco(rs.getString("endereco"));
                chamado.setContato(rs.getString("contato"));
                chamado.setTelefone(rs.getString("telefone"));
                chamado.setEmail(rs.getString("email"));
                chamado.setProblema(rs.getString("problema"));
                chamado.setObservacao(rs.getString("observacao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setData(rs.getString("data"));
                lista.add(chamado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta no banco de dados");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public void cadastrarChamado(String numeroChamado, Chamado chamado) {
        try {
            String sqlConsulta = "select * from chamados where numero_chamado = ?";
            stmt = con.prepareStatement(sqlConsulta);
            stmt.setString(1, numeroChamado);
            rs = stmt.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Número chamado já existe!");
            } else {
                String sql = "insert into chamados (numero_chamado, contrato, nome_cliente, endereco, contato, telefone, email, problema, observacao, status, data) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, chamado.getNumeroChamado());
                stmt.setInt(2, chamado.getContrato());
                stmt.setString(3, chamado.getNomeCliente());
                stmt.setString(4, chamado.getEndereco());
                stmt.setString(5, chamado.getContato());
                stmt.setString(6, chamado.getTelefone());
                stmt.setString(7, chamado.getEmail());
                stmt.setString(8, chamado.getProblema());
                stmt.setString(9, chamado.getObservacao());
                stmt.setString(10, chamado.getStatus());
                stmt.setString(11, chamado.getData());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Chamado número " + chamado.getNumeroChamado() + " cadastrado com sucesso!");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir chamado no banco!");
            throw new RuntimeException(sqle);
        }
    }

    public void excluirChamado(int numeroChamado) {
        String sql = "delete from chamados where numero_chamado = " + "'" + numeroChamado + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Chamado de número " + numeroChamado + " excluído com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir chamado no Banco de Dados!", "ERRO", JOptionPane.ERROR);
            throw new RuntimeException(sqle);
        }
    }

    public void alterarChamado(Chamado chamado) {
        String sql = "update chamados set contrato = ?, nome_cliente = ?, endereco = ?, contato = ?, telefone = ?, email = ?, problema = ?, observacao = ?, status = ?, data = ? where numero_chamado = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, chamado.getContrato());
            stmt.setString(2, chamado.getNomeCliente());
            stmt.setString(3, chamado.getEndereco());
            stmt.setString(4, chamado.getContato());
            stmt.setString(5, chamado.getTelefone());
            stmt.setString(6, chamado.getEmail());
            stmt.setString(7, chamado.getProblema());
            stmt.setString(8, chamado.getObservacao());
            stmt.setString(9, chamado.getStatus());
            stmt.setString(10, chamado.getData());
            stmt.setInt(11, chamado.getNumeroChamado());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Chamado número " + chamado.getNumeroChamado() + " alterado com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar alteração no Banco de Dados!");
            throw new RuntimeException(sqle);
        }

    }

    public ArrayList<Chamado> listarChamadoTabelaPorNumeroChamado(String numeroChamado) {
        String sql = "select * from chamados where numero_chamado like '%" + numeroChamado + "%'";
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setEndereco(rs.getString("endereco"));
                chamado.setContato(rs.getString("contato"));
                chamado.setTelefone(rs.getString("telefone"));
                chamado.setEmail(rs.getString("email"));
                chamado.setProblema(rs.getString("problema"));
                chamado.setObservacao(rs.getString("observacao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setData(rs.getString("data"));
                lista.add(chamado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public ArrayList<Chamado> listarChamadoTabelaPorContrato(String contrato) {
        String sql = "select * from chamados where contrato like '%" + contrato + "%'";
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setEndereco(rs.getString("endereco"));
                chamado.setContato(rs.getString("contato"));
                chamado.setTelefone(rs.getString("telefone"));
                chamado.setEmail(rs.getString("email"));
                chamado.setProblema(rs.getString("problema"));
                chamado.setObservacao(rs.getString("observacao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setData(rs.getString("data"));
                lista.add(chamado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public ArrayList<Chamado> listarChamadoTabelaPorSituacao(String situacao) {
        String sql = "select * from chamados where status like '%" + situacao + "%'";
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setProblema(rs.getString("problema"));
                chamado.setObservacao(rs.getString("observacao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setData(rs.getString("data"));
                lista.add(chamado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public ArrayList<Chamado> listarChamadoTabelaPorData(String data) {
        String sql = "select * from chamados where data like '%" + data + "%'";
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setEndereco(rs.getString("endereco"));
                chamado.setContato(rs.getString("contato"));
                chamado.setTelefone(rs.getString("telefone"));
                chamado.setEmail(rs.getString("email"));
                chamado.setProblema(rs.getString("problema"));
                chamado.setObservacao(rs.getString("observacao"));
                chamado.setStatus(rs.getString("status"));
                chamado.setData(rs.getString("data"));
                lista.add(chamado);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> listarChamadoTabelaPorDataFechamento(String data) {
        String sql = "select * from fechar_chamado where data like '%" + data + "%'";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> listarChamadoPorPeriodoData(String dataInicio, String dataFim) {
        String sql = "select numero_chamado, contrato, nome_cliente, fechamento, status, data from fechar_chamado where data between ? and ?";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, dataInicio);
            stmt.setString(2, dataFim);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException();
        }
        return lista;
    }

    public void excluirChamadoFechado(int numeroChamado) {
        String sql = "delete from chamados where numero_chamado = " + "'" + numeroChamado + "'";
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir chamado no Banco de Dados!", "ERRO", JOptionPane.ERROR);
            throw new RuntimeException(sqle);
        }
    }

    public void alterarChamadoConjuntoCliente(Chamado chamado) {
        String sqlChamado = "update chamados set nome_cliente = ?, endereco = ?, contato = ?, telefone = ?, email = ? where contrato = ?";
        try {
            stmt = con.prepareStatement(sqlChamado);
            stmt.setString(1, chamado.getNomeCliente());
            stmt.setString(2, chamado.getEndereco());
            stmt.setString(3, chamado.getContato());
            stmt.setString(4, chamado.getTelefone());
            stmt.setString(5, chamado.getEmail());
            stmt.setInt(6, chamado.getContrato());
            stmt.execute();
            stmt.close();
        } catch (SQLException sqle) {
            throw new RuntimeException();
        }
    }
}
