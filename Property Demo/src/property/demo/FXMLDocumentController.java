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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

// For alerts please read through this blog:
// http://code.makery.ch/blog/javafx-dialogs-official/
/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField propertyIdField;
    @FXML
    private TextField ownersNameField;
    @FXML
    private ListView<Property> ownersListView;
    private ObservableList<Property> ownersList;
    private int selectedIndex;
    @FXML
    private Label statusLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ownersListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ownersList = FXCollections.observableArrayList();
        ownersListView.setItems(ownersList);
        //ownersList = new ArrayList<>();
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
                //System.out.println(propertyId + ";" + owner);
                Property p = new Property(propertyId, owner);
                ownersList.add(p);
            }
        } catch (SQLException sqle) {

        }
    }
    
    // HOMETASK
    // try to do the update operation all by yourself

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        // HOMETASK
        // Show an alert if the user uses wrong input (string or blank)
        // for integers
        int propertyId = Integer.parseInt(propertyIdField.getText());
        String ownersName = ownersNameField.getText();
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.134/propertydb",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO property VALUES(" + propertyId + ", '" + ownersName + "')");
            statusLabel.setText("Added " + propertyId + " " + ownersName);
        } catch (SQLException sqle) {
            System.err.println("Cannot connect to the database");
        }
        System.out.println(propertyId + ";" + ownersName);
    }

    // HOMETASK:
    // Write some code that lets you delete multiple items at once
    @FXML
    private void handleDeleteAction(ActionEvent event) {
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.134/propertydb",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            int propertyId = ownersList.get(selectedIndex).getPropertyId();
            String ownersName = ownersList.get(selectedIndex).getOwnersName();
            statement.executeUpdate("DELETE FROM property WHERE propertyId = " 
                    + propertyId + " AND ownersName = '" 
                    + ownersName + "'");
            ownersList.remove(selectedIndex);
            statusLabel.setText("Deleted " + propertyId + " " + ownersName);
            propertyIdField.clear();
            ownersNameField.clear();
        } catch (SQLException sqle) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setHeaderText("Database error");
            alert.setContentText("Could not connect to the database");
            alert.showAndWait();
            System.err.println("Cannot connect to the database");
        }

    }

    @FXML
    private void handleListClickAction(MouseEvent event) {
        selectedIndex = ownersListView.getSelectionModel().getSelectedIndex();
        propertyIdField.setText(ownersList.get(selectedIndex).getPropertyId() + "");
        ownersNameField.setText(ownersList.get(selectedIndex).getOwnersName());
    }

}
