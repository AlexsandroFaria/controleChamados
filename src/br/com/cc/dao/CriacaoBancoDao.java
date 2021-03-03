/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.dao;

import br.com.cc.connection.ConnectionFactoryNewDatabase;
import br.com.cc.view.TelaLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alafaria
 */
public class CriacaoBancoDao {
    
    private ResultSet rs;
    private PreparedStatement stmt;
    private Connection con;
    private Statement st;
    TelaLogin telaLogin =  new TelaLogin();
    
    public CriacaoBancoDao(){
        this.con = new ConnectionFactoryNewDatabase().getConnection();
    }
    
    public void criarBancoDados(){
        
        try {
            st = con.createStatement();
            
            st.execute("create database if not exists controle_de_chamados");
            
            st.execute("create table if not exists controle_de_chamados.usuarios(\n"
                    + "id_usuario int(11) not null auto_increment, \n"
                    + "nome varchar(100) DEFAULT NULL,\n"
                    + "usuario varchar(100) DEFAULT NULL,\n"
                    + "senha varchar(100) DEFAULT NULL,\n"
                    + "primary key(id_usuario)\n"
                    + ")");
            
            st.execute("insert into controle_de_chamados.usuarios (nome, usuario, senha) values ('Administrador', 'admin', 'admin')");
            
            st.execute("create table if not exists controle_de_chamados.clientes(\n"
                    + "id_clientes int(11) not null auto_increment,\n"
                    + "contrato int(11) not null,\n"
                    + "nome_cliente varchar(100) default null,\n"
                    + "endereco varchar(100) default null,\n"
                    + "contato varchar(100) default null,\n"
                    + "telefone varchar(50) default null,\n"
                    + "email varchar(100) default null,\n"
                    + "primary key(id_clientes)\n"
                    + ")");
            
            st.execute("create table if not exists controle_de_chamados.chamados(\n"
                    + "id_chamado int(11) not null auto_increment,\n"
                    + "numero_chamado int(11) not null,\n"
                    + "contrato int(11) not null,\n"
                    + "nome_cliente varchar(100) default null,\n"
                    + "endereco varchar(100) default null,\n"
                    + "contato varchar(100) default null,\n"
                    + "telefone varchar(50) default null,\n"
                    + "email varchar(100) default null,\n"
                    + "problema varchar(255) default null,\n"
                    + "observacao varchar(255) default null,\n"
                    + "status varchar(100) default null,\n"
                    + "data varchar(11) default null,\n"
                    + "primary key(id_chamado)\n"
                    + ")");
            
            
            st.execute("create table if not exists controle_de_chamados.fechar_chamado(\n"
                    + "id_fechar_chamado int(11) not null auto_increment,\n"
                    + "numero_chamado int(11) not null,\n"
                    + "contrato int(11) not null,\n"
                    + "nome_cliente varchar(100) default null,\n"
                    + "problema varchar(255) default null,\n"
                    + "fechamento varchar(255) default null,\n"
                    + "status varchar(100) default null,\n"
                    + "data varchar(11) default null,\n"
                    + "primary key(id_fechar_chamado)\n"
                    + ")");
                             
            System.out.println("Banco ok");
            JOptionPane.showMessageDialog(null, "Estrutura de banco de dados criada!","Aviso",JOptionPane.WARNING_MESSAGE);
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }       
    }
}
