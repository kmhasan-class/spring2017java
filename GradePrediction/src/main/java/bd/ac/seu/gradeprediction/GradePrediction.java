/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.gradeprediction;

import java.sql.*;
import java.util.*;

/**
 *
 * @author kmhasan
 */
public class GradePrediction {

    public GradePrediction() {
        try {
            Connection connection = ConnectionSingleton.getConnection();

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student;";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            List<Student> studentsList = new ArrayList<>();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                studentsList.add(new Student(id, name));
            }
            
            for (Student student : studentsList)
                System.out.println(student);
            
            // Add code to find out the student names that are
            // more than 10 characters long
        } catch (SQLException ex) {
            //Logger.getLogger(GradePrediction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String args[]) {
        new GradePrediction();
    }
}
