package Controllers.Members;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMemberController {

    Connection connection= DBConnection.getInstance().getConnection();

    public boolean addMember(String name, String email, String phonenumber, String adress) {
        String sql="INSERT INTO members (full_name,email,phone_number,adress) VALUES (?,?,?,?);";
        try {
           PreparedStatement preparedStatement= connection.prepareStatement(sql);
             preparedStatement.setString(1,name);
             preparedStatement.setString(2,email);
             preparedStatement.setString(3,phonenumber);
             preparedStatement.setString(4,adress);

       return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
