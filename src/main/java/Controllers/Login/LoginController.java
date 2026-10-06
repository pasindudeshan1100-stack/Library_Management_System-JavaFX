package Controllers.Login;

public class LoginController {
    public boolean checkNameandPassword(String UserName,String Password){
        if (UserName.equals("pasindu")&& Password.equals("1234")) {
            return true;
        }
        return false;

    }
}
