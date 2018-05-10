///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package javafxapplication2;
//
//import acquaintance.IBusiness;
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.text.Text;
//import javafxapplication2.Logic.logicCreatCase;
//import javafxapplication2.Logic.logicLogin;
//
///**
// *
// * @author euc
// */
//public class FXMLDocumentController implements Initializable {
//    
////    private logicLogin login = new logicLogin();
////    private logicCreatCase createCase = new logicCreatCase();
//    private IBusiness business;
//    
//    private Label label;
//    @FXML
//    private AnchorPane loginScreenPane;
//    @FXML
//    private TextField passwordField;
//    @FXML
//    private TextField usernameField;
//    @FXML
//    private Button loginButton;
//    @FXML
//    private AnchorPane loginFailedScreenPane;
//    @FXML
//    private TextField failedUsernameField;
//    @FXML
//    private Button failedLoginButton;
//    @FXML
//    private PasswordField failedPasswordField;
//    @FXML
//    private AnchorPane adminStartPane;
//    @FXML
//    private AnchorPane userStartPane;
//   // private TextArea testFelt;
//    @FXML
//    private Button AdminCreateCaseButton;
//    @FXML
//    private Button ListOfUserButton;
//    @FXML
//    private Button AcessUserButton;
//    @FXML
//    private Button backToAdminPane;
//    @FXML
//    private TextField CreateUsernameTextField;
//    @FXML
//    private TextField CreateUserPasswordTextField;
//    @FXML
//    private TextField CreateUserTypeTextField;
//    @FXML
//    private Button BackToAcessUserAnchorPaneButton;
//    @FXML
//    private Button CreateNewUserButton;
//    @FXML
//    private Button CreateUserButton;
//    @FXML
//    private Text IfUsertypeIsWrong;
//    @FXML
//    private Button deleteUserButton;
//    @FXML
//    private TextField deleteUserTextField;
//    @FXML
//    private Button confirmButton;
//    @FXML
//    private Text erBrugerenSlettetLabel;
//    @FXML
//    private TextField deletePasswordTextField;
//    @FXML
//    private ListView<String> TestListView;
//    @FXML
//    private TextField cprField;
//    @FXML
//    private TextArea caseInputField;
//    @FXML
//    private Button createCaseButton;
//    @FXML
//    private Button opretSagButtonSocialWorker;
//    @FXML
//    private Button backToStartPaneButton;
//    @FXML
//    private AnchorPane secretaryStartPane;
//    @FXML
//    private AnchorPane socialWorkerStartPane;
//    @FXML
//    private AnchorPane accessUserAnchorPane;
//    @FXML
//    private AnchorPane createUserAnchorPane;
//    @FXML
//    private AnchorPane createCaseAnchorPane;
//    @FXML
//    private Button logUdAdminPaneButton;
//    @FXML
//    private Button logUdBorgerPaneButton;
//    @FXML
//    private Button logUdSecretaryPaneButton;
//    @FXML
//    private Button logUdSocialWorkerButton;
//    @FXML
//    private Button showCaseAdminButton;
//    @FXML
//    private AnchorPane showCaseAnchorPane;
//    @FXML
//    private Button seeListOfCaseButton;
//    @FXML
//    private ListView<String> showCaseListView;
//    @FXML
//    private TextField idSearchField;
//    @FXML
//    private Button findeCaseButton;
//    @FXML
//    private AnchorPane findCaseAnchorPane;
//    @FXML
//    private TextArea showCaseArea;
//    @FXML
//    private Label indsnfoinsdofosfd;
//    @FXML
//    private Label cprOutputLabel;
//    @FXML
//    private Label caseTimeLabel;
//    @FXML
//    private Label caseIDLabel;
//    @FXML
//    private Button SeeCaseBackButton;
//    @FXML
//    private Button socialWorkerSeeCaseButton;
//    @FXML
//    private Button secretaryCaseButton;
//    @FXML
//    private Button BackToUserMenueButton;
//    @FXML
//    private TextField searchBarCaseList;
//    @FXML
//    private Button searchButtonCaseList;
//    
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//    
//    public void injectBusiness(IBusiness business){
//        this.business = business;
//    }
//    
//    @FXML
//    private void loginButtonClick(ActionEvent event) {
//        //String username = usernameField.getText();
//        //String password = passwordField.getText();
//        //check.trimForSpaceUsername(username);
//        //check.trimForSpacePassword(password);
//        //changeScene(loginScreenPane, adminStartPane);
//        
//        boolean a = business.isProfileInDB(usernameField.getText(),passwordField.getText());
//        if(a == true){
//            int i = business.getUserType();
//            //changeScene(loginScreenPane, SocialWorkerPane);
//            if(business.getUserType() == 1){
//                changeScene(loginScreenPane, adminStartPane);
//            }else if(business.getUserType() == 2){
//                changeScene(loginScreenPane, socialWorkerStartPane);
//            }else if(business.getUserType() == 3){
//                changeScene(loginScreenPane, secretaryStartPane);
//            }else if(business.getUserType() == 4){
//                changeScene(loginScreenPane, userStartPane);
//            }
//        }
//        else
//        {
//            changeScene(loginScreenPane, loginFailedScreenPane);
//        }
//
//    }
//    
//    //method designed to switch between existing scenes. 
//    private void changeScene(AnchorPane from, AnchorPane to) {
//        from.setVisible(false);
//        from.setDisable(true);
//        to.setVisible(true);
//        to.setDisable(false);
//    }
//
//    @FXML
//    private void failedLoginButtonClick(ActionEvent event) {
//        boolean a = business.isProfileInDB(failedUsernameField.getText(),failedPasswordField.getText());
//        if(a == true){
//            int i = business.getUserType();
//            //changeScene(loginScreenPane, SocialWorkerPane);
//            if(business.getUserType() == 1){
//                changeScene(loginFailedScreenPane, adminStartPane);
//            }else if(business.getUserType() == 2){
//                changeScene(loginFailedScreenPane, socialWorkerStartPane);
//            }else if(business.getUserType() == 3){
//                changeScene(loginFailedScreenPane, secretaryStartPane);
//            }else if(business.getUserType() == 4){
//                changeScene(loginFailedScreenPane, userStartPane);
//            }
//        }
//    }
//
////    private void TestClick(ActionEvent event) {
////        testFelt.setText(login.getListOfUseres());
////    }
//
//    @FXML
//    private void AdminCreateCaseButtonClick(ActionEvent event) {
//        changeScene(adminStartPane, createCaseAnchorPane);
//    }
//
//    @FXML
//    private void ListOfUserButtonClick(ActionEvent event) {
//          ObservableList<String> userTest = FXCollections.observableArrayList(business.getUserList()); 
//          TestListView.setItems(userTest);
////        ListOfUsersField.setText(login.getListOfUseresName());
////        ListOfPasswodFiled.setText(login.getListOfUseresPassword());
////        ListOfUsertypeFiled.setText(login.getListOfUseresType());
////        
//    }
//
//    @FXML
//    private void acessUserButtonClick(ActionEvent event) {
//        changeScene(adminStartPane, accessUserAnchorPane);
//    }
//
//    @FXML
//    private void backToAdminPaneClick(ActionEvent event) {
//        changeScene(accessUserAnchorPane,adminStartPane);
//    }
//
//    @FXML
//    private void BackToAcessUserAnchorPaneButtonClick(ActionEvent event) {
//        changeScene(createUserAnchorPane, accessUserAnchorPane);
//    }
//
//    @FXML
//    private void CreateNewUserButtonClick(ActionEvent event) {
//        if(Integer.parseInt(CreateUserTypeTextField.getText()) <= 4 && Integer.parseInt(CreateUserTypeTextField.getText()) > 0){
//           // business.createNewUser(CreateUsernameTextField.getText(), CreateUserPasswordTextField.getText(), Integer.parseInt(CreateUserTypeTextField.getText()));
//            IfUsertypeIsWrong.setText("bruger oprettet");
//        }else{
//            IfUsertypeIsWrong.setText("forkert input i brugertype ");
//        }
//    }
//
//    @FXML
//    private void CreateUserButtonClick(ActionEvent event) {
//        changeScene(accessUserAnchorPane, createUserAnchorPane);
//    }
//
//    @FXML
//    private void deleteUserButtonClick(ActionEvent event) {
//        deleteUserTextField.setVisible(true);
//        deleteUserTextField.setDisable(false);
//        deletePasswordTextField.setVisible(true);
//        deletePasswordTextField.setDisable(false);
//        confirmButton.setVisible(true);
//        confirmButton.setDisable(false);
//    }
//
//    @FXML
//    private void conformButtonClick(ActionEvent event) {
//        if(business.isProfileInDB(deleteUserTextField.getText(), deletePasswordTextField.getText())){
//            business.deleteUser(deleteUserTextField.getText(),deletePasswordTextField.getText());
//            erBrugerenSlettetLabel.setText("Brugeren er fjernet");
//        }else
//            erBrugerenSlettetLabel.setText("Ingen bruger med det navn");
//        
//    }
//
//    @FXML
//    private void createCaseButtonClick(ActionEvent event) {
//        business.creataNewCase(cprField.getText(), caseInputField.getText());
//    }
//
//    @FXML
//    private void opretSagButtonSocialWorkerClick(ActionEvent event) {
//        changeScene(socialWorkerStartPane, createCaseAnchorPane);
//    }
//
//    @FXML
//    private void backToStartPaneButtonClick(ActionEvent event) {
//        if(business.getUserType() == 1){
//          changeScene(createCaseAnchorPane, adminStartPane);
//        }else
//            changeScene(createCaseAnchorPane, socialWorkerStartPane); 
//    }
//
//    @FXML
//    private void logUdAdminPaneButtonClick(ActionEvent event) {
//        changeScene(adminStartPane, loginScreenPane);
//    }
//
//    @FXML
//    private void logUdBorgerPaneButtonClick(ActionEvent event) {
//        changeScene(userStartPane, loginScreenPane);
//    }
//
//    @FXML
//    private void logUdSecretaryButtonClick(ActionEvent event) {
//        changeScene(secretaryStartPane, loginScreenPane);
//    }
//
//    @FXML
//    private void logUdSocialWorkerButtonClick(ActionEvent event) {
//        changeScene(socialWorkerStartPane, loginScreenPane);
//    }
//
//    @FXML
//    private void showCaseAdminButtonClick(ActionEvent event) {
//        changeScene(adminStartPane, showCaseAnchorPane);
//    }
//
//    @FXML
//    private void seeListOfCaseButtonClick(ActionEvent event) {
//        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getCaseList()); 
//        showCaseListView.setItems(UserCase);
//    }
//
//    @FXML
//    private void findeCaseButtonClick(ActionEvent event) {
//        if(business.isCaseInDB(idSearchField.getText())){
//            changeScene(showCaseAnchorPane, findCaseAnchorPane);
//            showCaseArea.setWrapText(true);
//            showCaseArea.setText(business.getCaseTextInput());
//            cprOutputLabel.setText(business.getCaseCPR());
//            caseTimeLabel.setText(business.getTime());
//            caseIDLabel.setText(business.getCaseID());
//        }else{
//            indsnfoinsdofosfd.setText("ID findes ikke - prøv igen! ");
//        }
//    }
//
//    @FXML
//    private void SeeCaseBackButtonclick(ActionEvent event) {
//        changeScene(findCaseAnchorPane, showCaseAnchorPane);
//    }
//
//    @FXML
//    private void socialWorkerSeeCaseButtonClick(ActionEvent event) {
//        changeScene(userStartPane, showCaseAnchorPane);
//    }
//
//    @FXML
//    private void BackToUserMenueButtonClick(ActionEvent event) {
//        if(business.getUserType()==1){
//            changeScene(showCaseAnchorPane, adminStartPane);
//        }else if(business.getUserType()  == 2){
//            changeScene(showCaseAnchorPane,socialWorkerStartPane);
//        }else if(business.getUserType() == 3){
//            changeScene(showCaseAnchorPane, secretaryStartPane);
//        }
//    }
//
//    @FXML
//    private void secretaryCaseButtonClick(ActionEvent event) {
//        changeScene(secretaryStartPane, showCaseAnchorPane);
//    }
//
//    @FXML
//    private void searchButtonCaseListClick(ActionEvent event) {
//        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getSpecificCaseList(searchBarCaseList.getText())); 
//        showCaseListView.setItems(UserCase);
//    }
//
//    
//}
