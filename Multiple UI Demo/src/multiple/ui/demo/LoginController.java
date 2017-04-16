/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.ui.demo;

import java.io.IOException;
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
    private void handleLoginAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        // username: admin
        // password:test1234
        if (username.equals("admin") && password.equals("test1234")) {
            // take us to the next page
            System.out.println("Login okay");
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

            Scene scene = new Scene(root);

            //Stage stage = MultipleUIDemo.getMainStage();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } else {
            // inform the user that the username and password is wrong
            System.out.println("Login failed");
        }
    }

}
