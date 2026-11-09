package Controllers.Books;


import Model.ReturnBookDTO;
import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReturnBookPgeController implements Initializable {
    ReturnBookController returnBookController=new ReturnBookController();
    public Button btnReset;
    public Button btnReturnBook;
    public DatePicker dpReturnDate;
    public TextField txtBookName;
    public TextField txtBookId;
    public TextField txtMemberId;

    public void DashboardbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Dashboard/home.fxml");

    }

    public void BooksbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_page.fxml");

    }

    public void MemberbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Members/member_page.fxml");

    }

    public void IssuebtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/issue_book_page.fxml");

    }

    public void ReturnbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/return_book_page.fxml");

    }

    public void HistorybtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_history_page.fxml");


    }

    public void btnResetOnAction(ActionEvent actionEvent) {
        txtBookId.clear();
        txtBookName.clear();
        txtMemberId.clear();
        dpReturnDate.setValue(null);
    }

    public void btnReturnOnAction(ActionEvent actionEvent) {
        ReturnBookDTO returnBookDTO=new ReturnBookDTO(txtMemberId.getText().trim(),txtBookId.getText().trim(),txtBookName.getText().trim(),dpReturnDate.getValue());
        boolean isReturned=returnBookController.ReturnBook(
            returnBookDTO.getMemberId(),
            returnBookDTO.getBookId(),
            returnBookDTO.getBooktitle(),
            returnBookDTO.getReturnDate()
        );
        if (isReturned){
            new Alert(Alert.AlertType.INFORMATION," Book Returned Successfully!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to return Book").show();
        }
        txtBookId.clear();
        txtBookName.clear();
        txtMemberId.clear();
        dpReturnDate.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        returnBookController.updateReturnedBooks(txtBookId.getText().trim(),txtMemberId.getText().trim());
    }
}
