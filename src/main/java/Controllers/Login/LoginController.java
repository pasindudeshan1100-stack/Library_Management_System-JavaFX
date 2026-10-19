package Controllers.Login;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

   Connection connection=DBConnection.getInstance().getConnection();
    public boolean checkNameandPassword(String UserName,String Password){
        String sql="SELECT * FROM users;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String dbUsaername= resultSet.getString("username");
                String dbPassword= resultSet.getString("password");
                if (UserName.equals(dbUsaername)&& Password.equals(dbPassword)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;

    }
}
