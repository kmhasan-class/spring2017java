/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.gradeprediction;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ConnectionSingleton {

    private static final String HOSTNAME = "172.17.0.119";
    private static final String USERNAME = "spring2017aj";
    private static final String PASSWORD = "aj";
    private static final String DBNAME = "predictdb";
    private static final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    private static ConnectionSingleton instance = new ConnectionSingleton();
    private static Connection connection;
    
    private ConnectionSingleton() {
        try {
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }
}
