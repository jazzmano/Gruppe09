/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class LoginScreenController implements Initializable {
    
    private static IBusiness business;

    @FXML
    private AnchorPane loginScreenPane;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   public void injectBusiness(IBusiness business){
        LoginScreenController.business = business;
    }
    /**
     * Method to change between FXML documents(scenes)
     */
    private void changeScreen(ActionEvent event, String a) throws IOException{ 
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }

    @FXML
    /**
     * Checks if the username and password is in the database.
     * If username and password is true, the method checks for usertype.
     * It loads a specific .fxml document depending on the usertype.
     * If the username and password doesn't exist in the database, the method changes scene.
     */
    private void loginButtonClick(ActionEvent event) throws IOException { 
        boolean a = business.isProfileInDB(usernameField.getText(), passwordField.getText());
        if(a== true){ 
            int i = business.getUserType();
            
            if(business.getUserType()==1){ 
                changeScreen(event, "AdminStart.fxml");
            }else if(business.getUserType() == 2){
                changeScreen(event, "SocialWorkerStart.fxml");
            }else if(business.getUserType() == 3){
                changeScreen(event, "SecretaryStart.fxml");
            }else if(business.getUserType()== 4){
                changeScreen(event, "UserStart.fxml");
            }
        }
        else{
            changeScreen(event, "LoginScreenFailed.fxml");
        }
    }
    
}
