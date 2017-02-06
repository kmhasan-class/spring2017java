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

    double number1;
    double number2;
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
        number2 = Double.parseDouble(secondNumber);
        double result = 0;
        // write if/else to make sure we are using the right operator
        if (operator == '+') {
            result = number1 + number2;
        } else if (operator == '-') {
            result = number1 - number2;
        } else if (operator == '/') {
            result = number1 / number2;
        }
        displayField.setText("" + result);
    }

    @FXML
    private void handleAdditionAction(ActionEvent event) {
        String firstNumber = displayField.getText();
        number1 = Double.parseDouble(firstNumber);
        displayField.clear();
        operator = '+';
    }

    @FXML
    private void handleSubtractionAction(ActionEvent event) {
        String firstNumber = displayField.getText();
        number1 = Double.parseDouble(firstNumber);
        displayField.clear();
        operator = '-';
    }

    @FXML
    private void handleDivisionAction(ActionEvent event) {
        String firstNumber = displayField.getText();
        number1 = Double.parseDouble(firstNumber);
        displayField.clear();
        operator = '/';
    }

    @FXML
    private void handleDotAction(ActionEvent event) {
        String oldText = displayField.getText();
        if (!oldText.contains(".")) {
            String newText = oldText + ".";
            displayField.setText(newText);
        }
    }

    @FXML
    private void handleZeroAction(ActionEvent event) {
        // fix this part so that we do not have any leading zeros
        // for integers
        String oldText = displayField.getText();
        String newText = oldText + "0";
        displayField.setText(newText);        
    }

    @FXML
    private void handleThreeAction(ActionEvent event) {
        String oldText = displayField.getText();
        String newText = oldText + "3";
        displayField.setText(newText);        
    }

    @FXML
    private void handleAllClearAction(ActionEvent event) {
        displayField.setText("");
        // displayField.clear();
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        String oldText = displayField.getText();
/*
        String newText = "";
        for (int i = 0; i < oldText.length() - 1; i++)
            newText = newText + oldText.charAt(i);
*/
        String newText = oldText.substring(0, oldText.length() - 1);
        displayField.setText(newText);
    }

}
