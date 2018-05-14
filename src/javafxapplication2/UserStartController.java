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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class UserStartController implements Initializable {

    @FXML
    private AnchorPane userStartPane;
    @FXML
    private Button logUdBorgerPaneButton;
    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label numberLabel;
    @FXML
    private Label CPRLabel;
    @FXML
    private ListView<?> CaseListView;
    @FXML
    private Button GoToCaseButton;
    @FXML
    private TextField userCaseIDSearchTextField;
    @FXML
    private Button refreshButton;

    /**
     * Initializes the controller class.
     */
    
    private void changeScreen(ActionEvent event, String a) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logUdBorgerPaneButtonClick(ActionEvent event) throws IOException {
        changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void GoToCaseButtonClicked(ActionEvent event) {
    }

    @FXML
    private void refreshButtonClicked(ActionEvent event) {
    }
    
}
