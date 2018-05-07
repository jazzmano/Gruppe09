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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class SecretaryStartController implements Initializable {

    @FXML
    private AnchorPane secretaryStartPane;
    @FXML
    private Button logUdSecretaryPaneButton;
    @FXML
    private Button secretaryCaseButton;

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
    private void logUdSecretaryButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void secretaryCaseButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "ShowCase.fxml");
    }
    
}
