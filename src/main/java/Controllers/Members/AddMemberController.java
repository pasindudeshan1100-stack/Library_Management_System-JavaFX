package Controllers.Members;

import Model.Member;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Member> getAllMembers(){
        List<Member> members=new ArrayList<>();
        String sql="SELECT * FROM members;";
        try {
           PreparedStatement preparedStatement= connection.prepareStatement(sql);
           ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
              Member member=new Member(
                      resultSet.getString("member_id"),
                      resultSet.getNString("full_name"),
                      resultSet.getString("email"),
                      resultSet.getString("phone_number"),
                      resultSet.getString("adress")
              );
              members.add(member);
           }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to load members.", e);

        }
        return members;
    }
}
