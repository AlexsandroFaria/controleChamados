/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.tableModel;

import br.com.cc.model.Usuario;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alafaria
 */
public class TabelaModeloUsuario extends AbstractTableModel{
    
    public static final int COLUNA_ID = 0;
    public static final int COLUNA_NOME = 1;
    public static final int COLUNA_USUARIO = 2;
    public static final int COLUNA_SENHA = 3;
    public ArrayList<Usuario>lista;

    public TabelaModeloUsuario(ArrayList<Usuario>lista) {
        this.lista = new ArrayList(lista);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Usuario usuario = lista.get(linha);
        if (coluna == COLUNA_ID) return usuario.getIdUsuario();
        if (coluna == COLUNA_NOME) return usuario.getNomeCompleto();
        if (coluna == COLUNA_USUARIO) return usuario.getUsuario();
        if (coluna == COLUNA_SENHA) return usuario.getSenha();
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        if (coluna == COLUNA_ID) return "ID";
        if (coluna == COLUNA_NOME) return "Nome";
        if (coluna == COLUNA_USUARIO) return "Usuário";
        if (coluna == COLUNA_SENHA) return "Senha";
        return "";
    }  
}
