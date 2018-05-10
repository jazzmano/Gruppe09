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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static javafxapplication2.JavaFXApplication2.business;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class CreateCaseController implements Initializable {

    @FXML
    private AnchorPane createCaseAnchorPane;
    @FXML
    private TextField cprField;
    @FXML
    private TextArea caseInputField;
    @FXML
    private Button createCaseButton;
    @FXML
    private Button backToStartPaneButton;

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
    private void createCaseButtonClick(ActionEvent event) {
    business.test2OpretTing(cprField.getText(), caseInputField.getText());

    }

    @FXML
    private void backToStartPaneButtonClick(ActionEvent event) throws IOException {
        if(business.getUserType() == 1){
            changeScreen(event, "AdminStart.fxml");
        }else if(business.getUserType()==2){
            changeScreen(event, "SocialWorkerStart.fxml");
        }
    }
    
}
