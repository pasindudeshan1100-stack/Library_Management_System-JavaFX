package Controllers.Books;


import Model.BookDTO;
import Model.IssueBookDTO;
import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class IssueBookPageController implements Initializable {

    IssueBookController issueBookController=new IssueBookController();

    public TextField txtMemberId;
    public TextField txtBookId;
    public DatePicker dpIssueDate;
    public DatePicker dpDueDate;
    public Button btnReset;
    public Button btnIssueBook;

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
       txtMemberId.clear();
       dpDueDate.setValue(null);
       dpIssueDate.setValue(null);

    }

    public void btnIssueOnAction(ActionEvent actionEvent) {
        IssueBookDTO issueBookDTO=new IssueBookDTO(txtBookId.getText().trim(),txtMemberId.getText().trim(),dpIssueDate.getValue(),dpDueDate.getValue());
        boolean isAdded=issueBookController.addIssueBook(
                issueBookDTO.getBookId(),
                issueBookDTO.getMemberId(),
                issueBookDTO.getIssueDate(),
                issueBookDTO.getDueDate()
        );
        if (isAdded){
            new Alert(Alert.AlertType.INFORMATION," Book issued Successfully!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to issue Book").show();
        }
        txtBookId.clear();
        txtMemberId.clear();
        dpDueDate.setValue(null);
        dpIssueDate.setValue(null);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        issueBookController.updateOverdueBooks();
    }
}
