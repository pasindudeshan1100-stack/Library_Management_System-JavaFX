package Controllers.Books;

import Model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class BookPageController {

    AddBookController addBookController=new AddBookController();
    @FXML
    private TableColumn<Book, String> actionColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> categoryColumn;

    @FXML
    private TableColumn<Book, String> idColumn;

    @FXML
    private TableColumn<Book, String> isbnColumn;

    @FXML
    private TableColumn<Book, Integer> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, Integer> yearColumn;


    @FXML
    void AddBooksbtnOnAction(ActionEvent event) {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Books/add_book.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

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
            List<Book> BookList = addBookController.getAllBooks();
            ObservableList<Book> data = FXCollections.observableArrayList(BookList);
            bookTable.setItems(data);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Unable to load members");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    }




