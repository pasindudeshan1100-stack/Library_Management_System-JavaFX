package Controllers.Dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Scene.SceneManager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class HomePageController{

    public Label lblUserName;
    @FXML

    private Button logoutButton;

    @FXML
    void BooksbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/book_page.fxml");
    }

    @FXML
    void DashboardbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Dashboard/home.fxml");
    }

    @FXML
    void HistorybtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/book_history_page.fxml");
    }

    @FXML
    void IssuebtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/issue_book_page.fxml");
    }

    @FXML
    void MemberbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Members/member_page.fxml");
    }

    @FXML
    void ReturnbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/return_book_page.fxml");
    }

}


