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
public class GradePrediction {

    private final String HOSTNAME = "172.17.0.119";
    private final String USERNAME = "spring2017aj";
    private final String PASSWORD = "aj";
    private final String DBNAME = "predictdb";
    private final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
    
    public GradePrediction() {
        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(GradePrediction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        new GradePrediction();
    }
}
