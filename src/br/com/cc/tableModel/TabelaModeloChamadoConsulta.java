/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.tableModel;

import br.com.cc.model.Chamado;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloChamadoConsulta extends AbstractTableModel{

    public static final int COLUNA_NUMERO_CHAMADO = 0;
    public static final int COLUNA_CONTRATO = 1;
    public static final int COLUNA_NOME_CLIENTE = 2;
    public static final int COLUNA_PROBLEMA = 3;
    public static final int COLUNA_OBSERVACAO = 4;
    public static final int COLUNA_STATUS = 5;
    public static final int COLUNA_DATA = 6;
    public ArrayList<Chamado>lista;
    
    public TabelaModeloChamadoConsulta(ArrayList<Chamado>lista){
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Chamado chamado = lista.get(linha);
        if (coluna == COLUNA_NUMERO_CHAMADO)return chamado.getNumeroChamado();
        if (coluna == COLUNA_CONTRATO) return chamado.getContrato();
        if (coluna == COLUNA_NOME_CLIENTE) return chamado.getNomeCliente();
        if (coluna == COLUNA_PROBLEMA) return chamado.getProblema();
        if (coluna == COLUNA_OBSERVACAO) return chamado.getObservacao();
        if (coluna == COLUNA_STATUS) return chamado.getStatus();
        if (coluna == COLUNA_DATA) return chamado.getData();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_NUMERO_CHAMADO) return "Número do Chamado";
        if (coluna == COLUNA_CONTRATO) return "Contrato";
        if (coluna == COLUNA_NOME_CLIENTE) return "Nome do Cliente";
        if (coluna == COLUNA_PROBLEMA) return "Problema";
        if (coluna == COLUNA_OBSERVACAO) return "Observação";
        if (coluna == COLUNA_STATUS) return "Status";
        if (coluna == COLUNA_DATA) return "Data";
        return "";
    }
    
    
}
