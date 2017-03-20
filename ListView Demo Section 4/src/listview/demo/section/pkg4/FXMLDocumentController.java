/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview.demo.section.pkg4;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField colorNameField;
    @FXML
    private ListView<String> colorsListView;
    private ObservableList<String> colorsList;
    @FXML
    private ComboBox<String> colorsNameComboBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorsList = FXCollections.observableArrayList();
        colorsListView.setItems(colorsList);
        colorsNameComboBox.setItems(colorsList);
        
        colorsList.add("Black");
        colorsList.add("Pink");
        colorsList.add("Red");
        colorsList.add("Yellow");
        colorsList.add("White");
    }    

    @FXML
    private void handleAddColorAction(ActionEvent event) {
        String colorName = colorNameField.getText();
        colorsList.add(colorName);
    }
    
}
