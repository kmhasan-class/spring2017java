/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview.demo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private ListView<String> namesListView;
    private ObservableList<String> namesList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namesList =  FXCollections.observableArrayList();
        namesList.add("John Doe");
        namesList.add("Jane Doe");
        namesListView.setItems(namesList);
    }    

    @FXML
    private void handleAddAction(ActionEvent event) {
        String name = nameField.getText();
        namesList.add(name);
        nameField.clear();
    }
    
}
