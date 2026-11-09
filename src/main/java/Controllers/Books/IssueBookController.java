package Controllers.Books;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class IssueBookController {
    Connection connection= DBConnection.getInstance().getConnection();

    public boolean addIssueBook(String bookId, String memberId, LocalDate issueDate, LocalDate dueDate) {
        String sql="INSERT INTO issueBooks(member_id,book_id,issue_date,due_date)  VALUES (?,?,?,?);";
        try {
           PreparedStatement preparedStatement= connection.prepareStatement(sql);
           preparedStatement.setString(1,memberId);
           preparedStatement.setString(2,bookId);
           preparedStatement.setString(3, String.valueOf(issueDate));
           preparedStatement.setString(4, String.valueOf(dueDate));
         return   preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void updateOverdueBooks() {
        String sql="UPDATE issueBooks SET status='OVERDUE' WHERE due_date< CURDATE() AND status='ISSUED'; ";
        try {
            java.sql.PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



