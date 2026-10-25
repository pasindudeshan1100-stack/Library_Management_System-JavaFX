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
LoginController loginController=new LoginController();
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
        if (txtPassword.getText().isBlank()
                || txtName.getText().isBlank()
        ) {

            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

            return;
        }
        txtName.clear();
        txtPassword.clear();
    if (loginController.checkNameandPassword(txtName.getText(),txtPassword.getText())){
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Dashboard/home.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
         }else {
        new Alert(Alert.AlertType.ERROR,"Incorrect username or password. Please try again.").show();
    }
        txtName.clear();
        txtPassword.clear();
    }

}


