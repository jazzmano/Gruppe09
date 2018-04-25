/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafxapplication2.Logic.characterCheck;
import javafxapplication2.Logic.logicLogin;

/**
 *
 * @author euc
 */
public class FXMLDocumentController implements Initializable {
    
    private logicLogin login = new logicLogin();
    
    
    private characterCheck check;
    
    private Label label;
    @FXML
    private AnchorPane loginScreenPane;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button loginButton;
    @FXML
    private AnchorPane loginFailedScreenPane;
    @FXML
    private TextField failedUsernameField;
    @FXML
    private Button failedLoginButton;
    @FXML
    private PasswordField failedPasswordField;
    @FXML
    private AnchorPane adminStartPane;
    @FXML
    private AnchorPane userStartPane;
    @FXML
    private AnchorPane SecretaryStartPane;
    private AnchorPane SocialWorkerPane;
    @FXML
    private AnchorPane SocialWorkerStartPane;
   // private TextArea testFelt;
    @FXML
    private Button AdminCreateCaseButton;
    @FXML
    private AnchorPane AcessUserAnchorPane;
    @FXML
    private Button ListOfUserButton;
    @FXML
    private Button AcessUserButton;
    @FXML
    private Button backToAdminPane;
    @FXML
    private TextField CreateUsernameTextField;
    @FXML
    private TextField CreateUserPasswordTextField;
    @FXML
    private TextField CreateUserTypeTextField;
    @FXML
    private Button BackToAcessUserAnchorPaneButton;
    @FXML
    private Button CreateNewUserButton;
    @FXML
    private AnchorPane CreateUserAnchorPane;
    @FXML
    private Button CreateUserButton;
    @FXML
    private Text IfUsertypeIsWrong;
    @FXML
    private Button deleteUserButton;
    @FXML
    private TextField deleteUserTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private Text erBrugerenSlettetLabel;
    @FXML
    private TextField deletePasswordTextField;
    @FXML
    private ListView<String> TestListView;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginButtonClick(ActionEvent event) {
        //String username = usernameField.getText();
        //String password = passwordField.getText();
        //check.trimForSpaceUsername(username);
        //check.trimForSpacePassword(password);
        //changeScene(loginScreenPane, adminStartPane);
        
        boolean a = login.isInProfileDB(usernameField.getText(),passwordField.getText());
        if(a == true){
            int i = login.getUsertype();
            //changeScene(loginScreenPane, SocialWorkerPane);
            if(login.getUsertype() == 1){
                changeScene(loginScreenPane, adminStartPane);
            }else if(login.getUsertype() == 2){
                changeScene(loginScreenPane, SocialWorkerPane);
            }else if(login.getUsertype() == 3){
                changeScene(loginScreenPane, SecretaryStartPane);
            }else if(login.getUsertype() == 4){
                changeScene(loginScreenPane, userStartPane);
            }
        }
        else
        {
            changeScene(loginScreenPane, loginFailedScreenPane);
        }

    }
    
    //method designed to switch between existing scenes. 
    private void changeScene(AnchorPane from, AnchorPane to) {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
    }

    @FXML
    private void failedLoginButtonClick(ActionEvent event) {
        boolean a = login.isInProfileDB(failedUsernameField.getText(),failedPasswordField.getText());
        if(a == true){
            int i = login.getUsertype();
            //changeScene(loginScreenPane, SocialWorkerPane);
            if(login.getUsertype() == 1){
                changeScene(loginFailedScreenPane, adminStartPane);
            }else if(login.getUsertype() == 2){
                changeScene(loginFailedScreenPane, SocialWorkerPane);
            }else if(login.getUsertype() == 3){
                changeScene(loginFailedScreenPane, SecretaryStartPane);
            }else if(login.getUsertype() == 4){
                changeScene(loginFailedScreenPane, userStartPane);
            }
        }
    }

//    private void TestClick(ActionEvent event) {
//        testFelt.setText(login.getListOfUseres());
//    }

    @FXML
    private void AdminCreateCaseButtonClick(ActionEvent event) {
        
    }

    @FXML
    private void ListOfUserButtonClick(ActionEvent event) {
          ObservableList<String> userTest = FXCollections.observableArrayList(login.getUserlist()); 
          TestListView.setItems(userTest);
//        ListOfUsersField.setText(login.getListOfUseresName());
//        ListOfPasswodFiled.setText(login.getListOfUseresPassword());
//        ListOfUsertypeFiled.setText(login.getListOfUseresType());
//        
    }

    @FXML
    private void acessUserButtonClick(ActionEvent event) {
        changeScene(adminStartPane, AcessUserAnchorPane);
    }

    @FXML
    private void backToAdminPaneClick(ActionEvent event) {
        changeScene(AcessUserAnchorPane,adminStartPane);
    }

    @FXML
    private void BackToAcessUserAnchorPaneButtonClick(ActionEvent event) {
        changeScene(CreateUserAnchorPane, AcessUserAnchorPane);
    }

    @FXML
    private void CreateNewUserButtonClick(ActionEvent event) {
        if(Integer.parseInt(CreateUserTypeTextField.getText()) <= 4 && Integer.parseInt(CreateUserTypeTextField.getText()) > 0){
            login.createNewUser(CreateUsernameTextField.getText(), CreateUserPasswordTextField.getText(), Integer.parseInt(CreateUserTypeTextField.getText()));
            IfUsertypeIsWrong.setText("bruger oprettet");
        }else{
            IfUsertypeIsWrong.setText("forkert input i brugertype ");
        }
    }

    @FXML
    private void CreateUserButtonClick(ActionEvent event) {
        changeScene(AcessUserAnchorPane, CreateUserAnchorPane);
    }

    @FXML
    private void deleteUserButtonClick(ActionEvent event) {
        deleteUserTextField.setVisible(true);
        deleteUserTextField.setDisable(false);
        deletePasswordTextField.setVisible(true);
        deletePasswordTextField.setDisable(false);
        confirmButton.setVisible(true);
        confirmButton.setDisable(false);
    }

    @FXML
    private void conformButtonClick(ActionEvent event) {
        if(login.isInProfileDB(deleteUserTextField.getText(), deletePasswordTextField.getText())){
            login.deleteUser(deleteUserTextField.getText(),deletePasswordTextField.getText());
            erBrugerenSlettetLabel.setText("Brugeren er fjernet");
        }else
            erBrugerenSlettetLabel.setText("Ingen bruger med det navn");
        
    }
    
}
