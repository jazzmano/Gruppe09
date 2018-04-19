/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane SocialWorkerPane;
    
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
//        else
//        {
//            changeScene(loginScreenPane, userStartPane);
//        }

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
    }
    
}
