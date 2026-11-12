package Controllers.Members;

import Model.MemberDTO;
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

    public List<MemberDTO> getAllMembers(){
        List<MemberDTO> members=new ArrayList<>();
        String sql="SELECT * FROM members;";
        try {
           PreparedStatement preparedStatement= connection.prepareStatement(sql);
           ResultSet resultSet=preparedStatement.executeQuery();
           while (resultSet.next()){
              MemberDTO member=new MemberDTO(
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

    public boolean UpdateMember(String name, String email, String adress, String phonenumber) {
        String sql="UPDATE members SET full_name=?,email=?,phone_number=?,adress=? WHERE member_id=?;" ;
        try {
          PreparedStatement preparedStatement=  connection.prepareStatement(sql);
          preparedStatement.setString(1,name);
          preparedStatement.setString(2,email);
          preparedStatement.setString(3,adress);
          preparedStatement.setString(4,phonenumber);

          return preparedStatement.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteMember(String id) {
        String sql="DELETE FROM members WHERE member_id=?;";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
