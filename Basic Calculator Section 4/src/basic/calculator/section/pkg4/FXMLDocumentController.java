/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic.calculator.section.pkg4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    int number1;
    int number2;
    char operator;
    
    @FXML
    private TextField displayField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOneAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "1"; // + is for concatenation
        displayField.setText(newText);
    }

    @FXML
    private void handleTwoAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "2";
        displayField.setText(newText);
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        String secondNumber = displayField.getText();
        number2 = Integer.parseInt(secondNumber);
        int result = 0;
        // write if/else to make sure we are using the right operator
        result = number1 + number2;
        displayField.setText("" + result);
    }

    @FXML
    private void handleAdditionAction(ActionEvent event) {
        String firstNumber = displayField.getText();
        number1 = Integer.parseInt(firstNumber);
        displayField.clear();
        operator = '+';
    }

    @FXML
    private void handleSubtractionAction(ActionEvent event) {
        String firstNumber = displayField.getText();
        number1 = Integer.parseInt(firstNumber);
        displayField.clear();
        operator = '-';
    }

}
