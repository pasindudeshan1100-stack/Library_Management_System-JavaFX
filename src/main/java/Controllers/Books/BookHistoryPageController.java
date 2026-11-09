package Controllers.Books;

import Model.BookHistoryDTO;
import Model.IssueBookDTO;
import Model.ReturnBookDTO;
import Scene.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookHistoryPageController  {

    BookHistoryController bookHistoryController=new BookHistoryController();

    public TableView<BookHistoryDTO> historyTable;
    public TableColumn<BookHistoryDTO,String> colMemberId;
    public TableColumn<BookHistoryDTO,String> colBookId;
    public TableColumn<BookHistoryDTO,String> colBookTitle;
    public TableColumn<BookHistoryDTO,LocalDate> colIssueDate;
    public TableColumn<BookHistoryDTO,LocalDate> colDueDate;
    public TableColumn<BookHistoryDTO,LocalDate> colReturnDate;
    public TableColumn<BookHistoryDTO,String> colStatus;

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


    public void initialize() {

        colMemberId.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("book_title"));
        colIssueDate.setCellValueFactory(new PropertyValueFactory<>("issue_date"));
        colDueDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        historyTable.getItems().setAll(bookHistoryController.getAllBookHistory());
    }
}
