
package Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/view/Dashboard/home.fxml")
                );

                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("Library Management System");
                stage.show();

                // Close the login window
                Stage loginStage = (Stage) txtName.getScene().getWindow();
                loginStage.close();

            } catch (IOException e) {
                e.printStackTrace();

                new Alert(
                        Alert.AlertType.ERROR,
                        "Unable to open the dashboard."
                ).showAndWait();
            }

        } else {
            new Alert(
                    Alert.AlertType.ERROR,
                    "Incorrect username or password. Please try again."
            ).showAndWait();
        }
    }
}


