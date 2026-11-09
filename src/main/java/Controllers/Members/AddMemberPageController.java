package Controllers.Members;

import Model.BookDTO;
import Model.MemberDTO;
import com.sun.jdi.connect.spi.Connection;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AddMemberPageController {
    public Button btnUpdate;
    public Button btnDelete;
    AddMemberController addMemberController=new AddMemberController();

    @FXML
    private Label lblMessage;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtPhone;

     MemberPageController    memberPageController=new MemberPageController();
    @FXML
    void AddbtnOnAction(ActionEvent event) {
        String fullname=txtFullName.getText();
        String email=txtEmail.getText();
        String phonenumber=txtPhone.getText();
        String adress=txtAddress.getText();

        boolean isadded=addMemberController.addMember(
                fullname.trim(),
                email.trim(),
                phonenumber.trim(),
                adress.trim()
        );
    if (isadded){
    new Alert(Alert.AlertType.INFORMATION,"New Member Added Successfully!").show();
     clearfields();
    
    }
    else {
        new Alert(Alert.AlertType.ERROR,"Failed to Add Member.").show();
    }
    }

    private void clearfields() {
        txtMemberId.clear();
        txtFullName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtEmail.clear();
        txtAddress.clear();      

    }

    @FXML
    void ResetbtnOnAction(ActionEvent event) {
    txtMemberId.clear();
    txtFullName.clear();
    txtEmail.clear();
    txtPhone.clear();
    txtEmail.clear();
    txtAddress.clear();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        MemberDTO memberDTO=new MemberDTO(
                txtMemberId.getText().trim(),
                txtFullName.getText().trim(),
                txtEmail.getText().trim(),
                txtAddress.getText().trim(),
                txtPhone.getText().trim()
        );
        boolean isUpdate= addMemberController.UpdateMember(
                memberDTO.getName(),
                memberDTO.getEmail(),
                memberDTO.getAdress(),
                memberDTO.getPhonenumber()

        );
        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION," Member updated Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to update Member.").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        MemberDTO memberDTO=new MemberDTO(
                txtMemberId.getText().trim(),
                txtFullName.getText().trim(),
                txtEmail.getText().trim(),
                txtAddress.getText().trim(),
                txtPhone.getText().trim()

        );
        boolean isDelete= addMemberController.deleteMember(
               memberDTO.getId()

        );
        if (isDelete){
            new Alert(Alert.AlertType.INFORMATION," Member Deleted Successfully!").show();
            clearfields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to delete Member.").show();
        }
    }
}

