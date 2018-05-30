/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static UserInterface.JavaFXApplication2.business;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class CreateUserController implements Initializable {

    @FXML
    private AnchorPane createUserAnchorPane;
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
    private Text IfUsertypeIsWrong;
    @FXML
    private TextField CreataUserCprTextField;
    @FXML
    private TextField CreateUserAddressTextField;
    @FXML
    private TextField CreateUserNumberTextField;
    @FXML
    private TextField CreateUserNameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
     * Method changes scene to AccessUser.fxml
     */
    private void BackToAcessUserAnchorPaneButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "AccessUser.fxml");
    }

    @FXML
    /**
     * Method takes all the values inserted into textfields, and checks if the inserted usertype is between 1 and 4. 
     * If usertype is between 1-4, user is created
     * If else, the method displays an error message
     */
    private void CreateNewUserButtonClick(ActionEvent event) {
        if(Integer.parseInt(CreateUserTypeTextField.getText())<= 4 && Integer.parseInt(CreateUserTypeTextField.getText()) >0){
           business.createNewUser(CreateUsernameTextField.getText(), CreateUserPasswordTextField.getText(), Integer.parseInt(CreateUserTypeTextField.getText()),
                   CreataUserCprTextField.getText(),CreateUserAddressTextField.getText(),CreateUserNumberTextField.getText(),CreateUserNameTextField.getText());
           IfUsertypeIsWrong.setText("Bruger oprettet"); 
        }else{
            IfUsertypeIsWrong.setText("forkert input i brugertype");
        }
    }
    
}
