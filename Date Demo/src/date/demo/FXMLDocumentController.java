/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date.demo;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField quantityField;
    @FXML
    private DatePicker restockedField;
    @FXML
    private ComboBox<String> typeBox;
    private ObservableList<String> typeList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeList = FXCollections.observableArrayList();
        typeBox.setItems(typeList);
        
        typeList.add("Stationery");
        typeList.add("Dairy Product");
        typeList.add("Jewellery");
        typeList.add("Grocery");
    }    

    @FXML
    private void handleSubmitAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String type = typeBox.getSelectionModel().getSelectedItem();
        int quantity = Integer.parseInt(quantityField.getText());
        LocalDate localDate = restockedField.getValue();
        
        // Homework: use SimpleDateFormat to format your date appropriately
        System.out.println(id + "," + name + "," + type + "," + quantity + "," + localDate);
    }
    
}
