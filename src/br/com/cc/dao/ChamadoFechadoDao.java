/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.dao;

import br.com.cc.connection.ConnectionFactory;
import br.com.cc.model.Chamado;
import br.com.cc.model.ChamadosFechados;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alafaria
 */
public class ChamadoFechadoDao {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;

    public ChamadoFechadoDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarChamadoFechado(ChamadosFechados chamadosFechados) {
        String sql = "insert into fechar_chamado (numero_chamado, contrato, nome_cliente, problema, fechamento, status, data) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, chamadosFechados.getNumeroChamado());
            stmt.setInt(2, chamadosFechados.getContrato());
            stmt.setString(3, chamadosFechados.getNomeCliente());
            stmt.setString(4, chamadosFechados.getProblema());
            stmt.setString(5, chamadosFechados.getMensagemFechamento());
            stmt.setString(6, chamadosFechados.getStatus());
            stmt.setString(7, chamadosFechados.getDataFechamento());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Chamado " + chamadosFechados.getNumeroChamado() + " encerrado com sucesso!");
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o chamado fechado");
            throw new RuntimeException(sqle);
        }
    }

    public ArrayList<Chamado> listarChamadosFechadosPorNumeroChamado(String numeroChamado) {
        String sql = "select * from chamados where numero_chamado = " + numeroChamado;
        ArrayList<Chamado> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Chamado chamado = new Chamado();
                chamado.setNumeroChamado(rs.getInt("numero_chamado"));
                chamado.setContrato(rs.getInt("contrato"));
                chamado.setNomeCliente(rs.getString("nome_cliente"));
                chamado.setProblema(rs.getString("problema"));
                lista.add(chamado);
            } else {
                JOptionPane.showMessageDialog(null, "Chamado não encontrado! Tente novamente!.", "AVISO", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> listarChamadosFechadosTabela() {
        String sql = "select * from fechar_chamado";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setIdChamadoFechado(rs.getInt("id_fechar_chamado"));
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setProblema(rs.getString("problema"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta na tabela");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> listarChamadosFechados(String situacao) {
        String sql = "select * from fechar_chamado where status like '%" + situacao + "%'";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setProblema(rs.getString("problema"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar consulta");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> consultarChamadosFechadosPorNumeroChamado(String numeroChamado) {
        String sql = "select * from fechar_chamado where numero_chamado like '%" + numeroChamado + "%'";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setProblema(rs.getString("problema"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

    public ArrayList<ChamadosFechados> consultarChamadosFechadosPorNumeroContrato(String numeroContrato) {
        String sql = "select * from fechar_chamado where contrato like '%" + numeroContrato + "%'";
        ArrayList<ChamadosFechados> lista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ChamadosFechados chamadosFechados = new ChamadosFechados();
                chamadosFechados.setNumeroChamado(rs.getInt("numero_chamado"));
                chamadosFechados.setContrato(rs.getInt("contrato"));
                chamadosFechados.setNomeCliente(rs.getString("nome_cliente"));
                chamadosFechados.setProblema(rs.getString("problema"));
                chamadosFechados.setMensagemFechamento(rs.getString("fechamento"));
                chamadosFechados.setStatus(rs.getString("status"));
                chamadosFechados.setDataFechamento(rs.getString("data"));
                lista.add(chamadosFechados);
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro na consulta!");
            throw new RuntimeException(sqle);
        }
        return lista;
    }

}
