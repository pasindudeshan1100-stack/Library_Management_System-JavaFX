package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BookPageController {

    @FXML
    private TableColumn<?, ?> actionColumn;

    @FXML
    private TableColumn<?, ?> authorColumn;

    @FXML
    private TableView<?> bookTable;

    @FXML
    private TableColumn<?, ?> categoryColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> isbnColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableColumn<?, ?> titleColumn;

    @FXML
    private TableColumn<?, ?> yearColumn;

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

}



