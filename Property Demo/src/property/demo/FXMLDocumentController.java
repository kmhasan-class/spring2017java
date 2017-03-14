/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package property.demo;

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
    private TextField propertyIdField;
    @FXML
    private TextField ownersNameField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.134/propertydb",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM property");
            while (resultSet.next()) {
                int propertyId = resultSet.getInt("propertyId");
                String owner = resultSet.getString("ownersName");
                System.out.println(propertyId + ";" + owner);
            }
        } catch (SQLException sqle) {

        }
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        int propertyId = Integer.parseInt(propertyIdField.getText());
        String ownersName = ownersNameField.getText();
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.134/propertydb",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO property VALUES(" + propertyId + ", '" + ownersName + "')");
        } catch (SQLException sqle) {
            System.err.println("Cannot connect to the database");
        }
        System.out.println(propertyId + ";" + ownersName);
    }

}
