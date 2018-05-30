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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class SocialWorkerStartController implements Initializable {

    @FXML
    private AnchorPane socialWorkerStartPane;
    @FXML
    private Button opretSagButtonSocialWorker;
    @FXML
    private Button logUdSocialWorkerButton;
    @FXML
    private Button socialWorkerSeeCaseButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
     * Method changes scene to CreateCase.fxml.
     */
    private void opretSagButtonSocialWorkerClick(ActionEvent event) throws IOException {
        changeScreen(event, "CreateCase.fxml");
    }

    @FXML
     /**
     * Method changes scene to LoginScreen.fxml.
     */
    private void logUdSocialWorkerButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
      /**
     * Method changes scene to ShowCase.fxml.
     */
    private void socialWorkerSeeCaseButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "ShowCase.fxml");
    }
    
}
