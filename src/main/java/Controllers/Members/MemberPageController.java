package Controllers.Members;

import Model.MemberDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import Scene.SceneManager;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class MemberPageController {

    public Button btnSearch;
    public TextField txtSearch;
    public Button btnAddMember;
    public Button logoutButton;
    private AddMemberController addMemberController=new AddMemberController();
    @FXML
    private TableColumn<MemberDTO, String> colAdress;

    @FXML
    private TableColumn<MemberDTO, String> colEmail;

    @FXML
    private TableColumn<MemberDTO, String> colMemberId;

    @FXML
    private TableColumn<MemberDTO, String> colName;

    @FXML
    private TableColumn<MemberDTO, String> colPhonenumber;

    @FXML
    private TableView<MemberDTO> tblMembers;

    @FXML
    private AnchorPane txtAdrss;

    @FXML
    void AddMemberbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Members/add_member.fxml");
    }

    @FXML
    void BooksbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/book_page.fxml");
    }

    @FXML
    void DashboardbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Dashboard/home.fxml");

    }

    @FXML
    void HistorybtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/book_history_page.fxml");

    }

    @FXML
    void IssuebtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/issue_book_page.fxml");

    }

    @FXML
    void MemberbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Members/member_page.fxml");

    }

    @FXML
    void ReturnbtnOnAction(ActionEvent event) {
        SceneManager.switchPage("/view/Books/return_book_page.fxml");

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
          List<MemberDTO>memberList=addMemberController.getAllMembers();
          ObservableList<MemberDTO> data= FXCollections.observableArrayList(memberList);
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





