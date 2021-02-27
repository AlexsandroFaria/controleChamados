/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cc.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alafaria
 */
public class ConnectionFactoryNewDatabase {
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost?useTimezone=true&serverTimezone=UTC", "root", "alex");
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
    
}
    

