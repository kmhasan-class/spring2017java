/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField studentIdField;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField cgpaField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.119/spring2017db",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student";
            
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                double cgpa = resultSet.getDouble("cgpa");
                System.out.println("student id " + id);
                System.out.println("student name " + name);
                System.out.println("cgpa " + cgpa);
            }
        } catch (SQLException sqle) {
            System.err.println("Could not connect to the database");
        }            
    }

    @FXML
    private void handleAddStudentAction(ActionEvent event) {
        int studentId = Integer.parseInt(studentIdField.getText());
        String studentName = studentNameField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.119/spring2017db",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO student VALUES(" + studentId 
                    + ", '" + studentName + "', " + cgpa + ")";
            System.out.println(query);
            statement.executeUpdate(query);
            
            studentIdField.clear();
            studentNameField.clear();
            cgpaField.clear();
        } catch (SQLException sqle) {
            System.err.println("Could not connect to the database");
        }
    }

}
