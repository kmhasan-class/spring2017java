/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.ui.demo.section.pkg4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kmhasan
 */
public class LoginController implements Initializable {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleCancelAction(ActionEvent event) {
        System.out.println("Cancel");
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {
        System.out.println("Login");
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals("admin") && password.equals("test")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("ManagerUI.fxml"));

                Scene scene = new Scene(root);
//                Stage stage = new Stage();
                Stage stage = MultipleUIDemoSection4.getMainStage();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {

            }
        }

    }

}
