/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.tableModel;

import br.com.cc.model.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloClientes extends AbstractTableModel{

    public static final int COLUNA_CONTRATO = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_ENDERECO = 2;
    public static final int COLUNA_CONTATO = 3;
    public static final int COLUNA_TELEFONE = 4;
    public static final int COLUNA_EMAIL = 5;
    public ArrayList<Cliente>lista;
    
    public TabelaModeloClientes(ArrayList<Cliente>lista){
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente cliente = lista.get(linha);
        if (coluna == COLUNA_CONTRATO) return cliente.getContrato();
        if (coluna == COLUNA_NOME) return cliente.getNomeCliente();
        if (coluna == COLUNA_ENDERECO) return cliente.getEndereco();
        if (coluna == COLUNA_CONTATO) return cliente.getContato();
        if (coluna == COLUNA_TELEFONE) return cliente.getTelefone();
        if (coluna == COLUNA_EMAIL) return cliente.getEmail();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_CONTRATO) return "Número do Contrato";
        if (coluna == COLUNA_NOME) return "Nome";
        if (coluna == COLUNA_ENDERECO) return "Endereço";
        if (coluna == COLUNA_CONTATO) return "Contato";
        if (coluna == COLUNA_TELEFONE) return "Telefone";
        if (coluna == COLUNA_EMAIL) return "E-mail";
        return "";
    }
    
    
}
