package Controllers.Books;

import Model.BookHistoryDTO;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookHistoryController {
   public  List<BookHistoryDTO> getAllBookHistory(){

       Connection connection= DBConnection.getInstance().getConnection();

       List<BookHistoryDTO>bookHistoryList=new ArrayList<>();
       String sql= "SELECT issueBooks.member_id,issueBooks.book_id,issueBooks.issue_date,issueBooks.due_date," +
               "issueBooks.status,returnBooks.book_title,returnBooks.return_date FROM  issueBooks LEFT JOIN returnBooks " +
               "ON issueBooks.member_id=returnBooks.member_id AND issueBooks.book_id=returnBooks.book_id; ";

       try {
          PreparedStatement preparedStatement= connection.prepareStatement(sql);
          ResultSet resultSet= preparedStatement.executeQuery();

          while (resultSet.next()){
              bookHistoryList.add(new BookHistoryDTO(
                      resultSet.getString("member_id"),
                      resultSet.getString("book_id"),
                      resultSet.getString("book_title"),
                      resultSet.getDate("issue_date").toLocalDate(),
                      resultSet.getDate("due_date").toLocalDate(),
                      resultSet.getDate("return_date") == null ? null :
                              resultSet.getDate("return_date").toLocalDate(),
                      resultSet.getString("status")

                      ));
          }


       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return bookHistoryList;
   }
}
