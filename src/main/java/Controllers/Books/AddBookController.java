package Controllers.Books;

import Model.Book;
import db.DBConnection;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddBookController {
    Connection connection= DBConnection.getInstance().getConnection();

    public boolean AddBook(String author, String title, String category, String year, String quantity) {
        String sql="INSERT INTO books (book_title,author,category,published_year,quantity)VALUES(?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,category);
            preparedStatement.setString(4,year);
            preparedStatement.setString(5,quantity);

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Book>
}
