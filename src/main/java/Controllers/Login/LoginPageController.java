
package Controllers.Login;

import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class LoginPageController {

    LoginController loginController = new LoginController();

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void ClearbtnOnAction(ActionEvent event) {
        txtName.clear();
        txtPassword.clear();
    }

    @FXML
    void LoginbtnOnAction(ActionEvent event) {

        String username = txtName.getText().trim();
        String password = txtPassword.getText();

        if (username.isBlank() || password.isBlank()) {
            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

            return;
        }

        if (loginController.checkNameandPassword(username, password)) {

                SceneManager.switchPage("/view/Dashboard/home.fxml");


        } else {
            new Alert(
                    Alert.AlertType.ERROR,
                    "Unable to Login.Incorrect username or password. Please try again."
            ).showAndWait();
        }
    }
}


