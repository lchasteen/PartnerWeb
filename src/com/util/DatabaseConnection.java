/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lchastee
 */
public class DatabaseConnection {
    private static Connection connection;
    
    static {
        try {
            Class.forName(QuestConfiguration.getDatabaseClass());          
            connection = DriverManager.getConnection(QuestConfiguration.getDatabaseName());
          
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            SimpleLog.setError(ex);
        }  catch (SQLException exp) {
            SimpleLog.setError(exp);
        }
        
    }
    
    public static Connection getConnection(){
        return connection;
    }
    
    public static void closeConnection() throws SQLException{
        if(connection != null){
            connection.close();
        }        
    }
    
}
