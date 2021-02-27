/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.tableModel;

import br.com.cc.model.ChamadosFechados;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloChamadosFechados extends AbstractTableModel{

    public static final int COLUNA_NUMERO_CHAMADO = 0;
    public static final int COLUNA_CONTRATO = 1;
    public static final int COLUNA_NOME_CLIENTE = 2;
    public static final int COLUNA_MENSSAGEM = 3;
    public static final int COLUNA_STATUS = 4;
    public static final int COLUNA_DATA = 5;
    public ArrayList<ChamadosFechados>lista;
    
    public TabelaModeloChamadosFechados(ArrayList<ChamadosFechados>lista){
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
        ChamadosFechados chamadosFechados = lista.get(linha);
        if (coluna == COLUNA_NUMERO_CHAMADO)return chamadosFechados.getNumeroChamado();
        if (coluna == COLUNA_CONTRATO) return chamadosFechados.getContrato();
        if (coluna == COLUNA_NOME_CLIENTE) return chamadosFechados.getNomeCliente();
        if (coluna == COLUNA_MENSSAGEM) return chamadosFechados.getMensagemFechamento();
        if (coluna == COLUNA_STATUS) return chamadosFechados.getStatus();
        if (coluna == COLUNA_DATA) return chamadosFechados.getDataFechamento();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_NUMERO_CHAMADO) return "Número do chamado";
        if (coluna == COLUNA_CONTRATO) return "Contrato";
        if (coluna == COLUNA_NOME_CLIENTE) return "Nome do Cliente";
        if (coluna == COLUNA_MENSSAGEM) return "Mensagem de Fechamento";
        if (coluna == COLUNA_STATUS) return "Status";
        if (coluna == COLUNA_DATA) return "Data de Fechamento";
        return "";
    }
}
