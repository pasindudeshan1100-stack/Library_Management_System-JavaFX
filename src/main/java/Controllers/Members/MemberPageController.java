package Controllers.Members;

import Model.Member;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MemberPageController {

    public Button btnSearch;
    public TextField txtSearch;
    public Button btnAddMember;
    public Button logoutButton;
    private AddMemberController addMemberController=new AddMemberController();
    @FXML
    private TableColumn<Member, String> colAdress;

    @FXML
    private TableColumn<Member, String> colEmail;

    @FXML
    private TableColumn<Member, String> colMemberId;

    @FXML
    private TableColumn<Member, String> colName;

    @FXML
    private TableColumn<Member, String> colPhonenumber;

    @FXML
    private TableView<Member> tblMembers;

    @FXML
    private AnchorPane txtAdrss;

    @FXML
    void AddMemberbtnOnAction(ActionEvent event) {
        Stage stage=new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Members/add_member.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void BooksbtnOnAction(ActionEvent event) {

    }

    @FXML
    void DashboardbtnOnAction(ActionEvent event) {

    }

    @FXML
    void HistorybtnOnAction(ActionEvent event) {

    }

    @FXML
    void IssuebtnOnAction(ActionEvent event) {

    }

    @FXML
    void MemberbtnOnAction(ActionEvent event) {

    }

    @FXML
    void ReturnbtnOnAction(ActionEvent event) {

    }
    @FXML
        public void initialize(){
        colMemberId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        colAdress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        loadMembers();
        }

    public void loadMembers() {
      try{
          List<Member>memberList=addMemberController.getAllMembers();
          ObservableList<Member> data= FXCollections.observableArrayList(memberList);
          tblMembers.setItems(data);
      } catch (Exception e) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Database Error");
          alert.setHeaderText("Unable to load members");
          alert.setContentText(e.getMessage());
          alert.showAndWait();
        }


    }

    public void RefreshbtnOnAction(ActionEvent actionEvent) {

    }

    public void SearchbtnOnAction(ActionEvent actionEvent) {
    }

    public void UpdatebtnOnAction(ActionEvent actionEvent) {
    }

    public void DeletebtnOnAction(ActionEvent actionEvent) {
    }
}





