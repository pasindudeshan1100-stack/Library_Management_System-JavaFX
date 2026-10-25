package Controllers.Books;

import Model.Book;
import db.DBConnection;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.control.Alert.AlertType.ERROR;

public class AddBookController {
    Connection connection= DBConnection.getInstance().getConnection();

    public boolean AddBook(String author, String title, String category, int year, int quantity) {
        String sql="INSERT INTO books (book_title,author,category,published_year,quantity)VALUES(?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.setString(3,category);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, quantity);

            return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }
    public List<Book> getAllBooks(){
        List<Book>books=new ArrayList<>();
        String sql="SELECT * FROM books;";

        try {

            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();

            while (resultSet.next()){
                Book book=new Book(
                resultSet.getString("book_id"),
                resultSet.getString("book_title"),
                resultSet.getString("author"),
                resultSet.getString("category"),
                resultSet.getInt("published_year"),
                resultSet.getInt("quantity")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public boolean updateBook(String id,String author, String category, String title, int year, int quantity){
        String sql="UPDATE books SET book_title=?,author=?,category=?,published_year=?,quantity=? WHERE book_id=?;" ;
        try {
          PreparedStatement preparedStatement=  connection.prepareStatement(sql);
          preparedStatement.setString(3,title);
          preparedStatement.setString(1,author);
          preparedStatement.setString(2,category);
          preparedStatement.setInt(4,year);
          preparedStatement.setInt(5,quantity);
          preparedStatement.setString(6,id);
          return preparedStatement.executeUpdate()>0;



        } catch (SQLException e) {
            e.printStackTrace();


        }

        return false;
    }


}
