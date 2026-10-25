package Controllers.Books;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String quantity= txtQuantity.getText();

        if (author.isBlank()
                || title.isBlank()
                || category == null
                || year.isBlank()
                || quantity.isBlank()) {

            new Alert(
                    Alert.AlertType.WARNING,
                    "Please fill all fields!"
            ).showAndWait();

            return;
        }
        try {
            int publishedYear = Integer.parseInt(year.trim());
            int bookQuantity = Integer.parseInt(quantity.trim());

            boolean isAdded=addBookController.AddBook(
                    author.trim(),
                    title.trim(),
                    category.trim(),
                    publishedYear,
                    bookQuantity
            );
            if (isAdded){
                new Alert(Alert.AlertType.INFORMATION,"New Book added Successfully!").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"Failed to add Book").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Error"+e.getMessage()).show();
        }
        clearFields();
    }


    @FXML
    void clearFields() {
        txtAuthor.clear();
        txtBookId.clear();
        txtBookTitle.clear();
        txtQuantity.clear();
        txtPublishedYear.clear();
        cmbCategory.setValue(null);

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
        txtBookId.textProperty().addListener(
                (observableValue, oldValue, newValue) ->{
                    if (newValue==null||newValue.trim().isEmpty()){
                       clearFields();
                    }
                    else{
                     loadBookDetails(newValue.trim());


                    }
                }
        );
    }
    public void loadBookDetails(String bookId) {
        Connection connection= DBConnection.getInstance().getConnection();

        String sql="SELECT * FROM books WHERE book_id = ?;";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,bookId);
            ResultSet resultSet= preparedStatement.executeQuery();
            if (resultSet.next()){
                txtAuthor.setText(resultSet.getString("author"));
                txtBookTitle.setText(resultSet.getString("book_title"));
                cmbCategory.setValue(resultSet.getString("category"));
                txtPublishedYear.setText(String.valueOf(resultSet.getInt("published_year")));
                txtQuantity.setText(String.valueOf(resultSet.getInt("quantity")));

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    public void UpdateOnAction(ActionEvent actionEvent) {

        String id=txtBookId.getText().trim();
        String author=txtAuthor.getText().trim();
        String category=cmbCategory.getValue().trim();
        String title=txtBookTitle.getText().trim();
        String year=txtPublishedYear.getText().trim();
        String Quantity=txtQuantity.getText().trim();

            int published_year=Integer.parseInt(year);
            int quantity=Integer.parseInt(Quantity);
       boolean isUpdated= addBookController.updateBook(id,author,category,title,published_year,quantity);
       if (isUpdated){
           new Alert(Alert.AlertType.INFORMATION,"Updated Book Successfully!").show();

       }
       else {
           new Alert(Alert.AlertType.ERROR,"Failed to update Book!").show();
       }

    }

    public void DeleteOnAction(ActionEvent actionEvent) {

    }
}



