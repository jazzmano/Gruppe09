/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

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
import static javafxapplication2.JavaFXApplication2.business;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void changeScreen(ActionEvent event, String a) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }

    @FXML
    private void BackToAcessUserAnchorPaneButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "AccessUser.fxml");
    }

    @FXML
    private void CreateNewUserButtonClick(ActionEvent event) {
        if(Integer.parseInt(CreateUserTypeTextField.getText())<= 4 && Integer.parseInt(CreateUserTypeTextField.getText()) >0){
           business.createNewUser(CreateUsernameTextField.getText(), CreateUserPasswordTextField.getText(), Integer.parseInt(CreateUserTypeTextField.getText()));
           IfUsertypeIsWrong.setText("Bruger oprettet");
        }else{
            IfUsertypeIsWrong.setText("forkert input i brugertype");
        }
    }
    
}
