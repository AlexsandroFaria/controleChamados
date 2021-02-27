/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.utilitarios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author alafaria
 */
public class ColorJtable extends JTable {

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);

        if (getValueAt(row, column).getClass().equals(String.class)){
            String valor = (String) this.getValueAt(row, column);

            if (valor.equals("Fechado")) {
                component.setBackground(Color.white);
                component.setForeground(Color.red);
            }
            if (valor.equals("Em atendimento")){
                component.setBackground(Color.white);
                component.setForeground(Color.blue);
            }
        } else {
            component.setBackground(Color.black);
            component.setBackground(Color.white);
        }
        return component;
    }
}
