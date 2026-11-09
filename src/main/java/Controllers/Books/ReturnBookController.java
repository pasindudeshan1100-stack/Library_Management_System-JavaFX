package Controllers.Books;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReturnBookController {
    Connection connection= DBConnection.getInstance().getConnection();

    public boolean ReturnBook(String memberId, String bookId, String booktitle, LocalDate returnDate) {
        String sql="INSERT INTO returnBooks (member_id,book_id,book_title,return_date)VALUES (?,?,?,?);";
        try {
            java.sql.PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,memberId);
            preparedStatement.setString(2,bookId);
            preparedStatement.setString(3,booktitle);
            preparedStatement.setString(4, String.valueOf(returnDate));
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void updateReturnedBooks(String bookId, String memberId) {
        String sql="UPDATE issueBooks SET status='RETURNED'WHERE book_id=? AND member_id=? AND status IN ('ISSUED', 'OVERDUE');";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,memberId);
            preparedStatement.setString(2,bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
