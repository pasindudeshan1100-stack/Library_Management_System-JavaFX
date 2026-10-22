package Controllers.Books;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddBookPageController {

    AddBookController addBookController= new AddBookController();
    @FXML
    private ComboBox<String> cmbCategory;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookTitle;

    @FXML
    private TextField txtPublishedYear;

    @FXML
    private TextField txtQuantity;

    @FXML
    void addBookOnAction(ActionEvent event) {
    String author= txtAuthor.getText();
    String title=txtBookTitle.getText();
    String category=cmbCategory.getValue();
    String year=txtPublishedYear.getText();
    String  quantity= txtQuantity.getText();
    try {

        boolean isAdded=addBookController.AddBook(
                author.trim(),
                title.trim(),
                category.trim(),
                year.trim(),
                quantity.trim()
        );
        if (isAdded){
            new Alert(Alert.AlertType.INFORMATION,"New Book added Successfully!").show();

        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to add Book").show();
        }

    } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR,"Error"+e.getMessage()).show();
    }

    }

    @FXML
    void clearFields(ActionEvent event) {

    }
    public void initialize(){
        cmbCategory.getItems().addAll(
                "Fiction",
                "Non-Fiction",
                "Science",
                "Technology",
                "Computer Science",
                "Education",
                "History",
                "Biography",
                "Mystery",
                "Fantasy",
                "Romance",
                "Horror",
                "Adventure",
                "Self-Help",
                "Business",
                "Mathematics",
                "Literature",
                "Reference"
        );
    }
}

