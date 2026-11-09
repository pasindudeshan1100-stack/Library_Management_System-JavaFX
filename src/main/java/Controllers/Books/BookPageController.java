package Controllers.Books;

import Model.BookDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Scene.SceneManager;

import java.io.IOException;
import java.util.List;

public class BookPageController {

    public Button logoutButton;
    AddBookController addBookController=new AddBookController();
    @FXML
    private TableColumn<BookDTO, String> actionColumn;

    @FXML
    private TableColumn<BookDTO, String> authorColumn;

    @FXML
    private TableView<BookDTO> bookTable;

    @FXML
    private TableColumn<BookDTO, String> categoryColumn;

    @FXML
    private TableColumn<BookDTO, String> idColumn;

    @FXML
    private TableColumn<BookDTO, String> isbnColumn;

    @FXML
    private TableColumn<BookDTO, Integer> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<BookDTO, String> titleColumn;

    @FXML
    private TableColumn<BookDTO, Integer> yearColumn;


    @FXML
    void AddBooksbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/add_book.fxml");


    }

    public void  initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("bookid"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        loadBooks();

    }

    private void loadBooks() {
        try {
            List<BookDTO> BookList = addBookController.getAllBooks();
            ObservableList<BookDTO> data = FXCollections.observableArrayList(BookList);
            bookTable.setItems(data);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Unable to load members");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    public void HistorybtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_history_page.fxml");

    }

    public void ReturnbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/return_book_page.fxml");

    }

    public void IssuebtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/issue_book_page.fxml");

    }

    public void MemberbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Members/member_page.fxml");

    }

    public void BooksbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Books/book_page.fxml");
    }

    public void DashboardbtnOnAction(ActionEvent actionEvent) {
        SceneManager.switchPage("/view/Dashboard/home.fxml");

    }
}




