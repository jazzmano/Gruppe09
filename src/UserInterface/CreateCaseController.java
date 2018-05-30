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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static UserInterface.JavaFXApplication2.business;

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
    @FXML
    private TextField TitleTextField;
    @FXML
    private Label isCaseCreatedlabel;

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
     * Method tests if any of the inserted values are empty, if they are, the case wont be created.
     * If none are empty, the case is created
     */
    private void createCaseButtonClick(ActionEvent event) {
    if(cprField.getText().equals("") || caseInputField.getText().equals("") || TitleTextField.getText().equals("")){
        isCaseCreatedlabel.setText("ingen sag oprettet"); 
        }
        else
        {
        business.CreateCaseInPercasAndCases(cprField.getText(), caseInputField.getText(),TitleTextField.getText());
        isCaseCreatedlabel.setText("sag er oprettet"); 
    }

    }

    @FXML
    /**
     * Method returns the user to the start menu, since both admin and social worker can access Create Case, the method needs to know what start menu to return to.
     * If the usertype = 1(admin), the method returns to AdminStart.fxml
     * Else if the usertype = 2(social worker), the method returns to SocialWorkerStart.fxml
     */
    private void backToStartPaneButtonClick(ActionEvent event) throws IOException { 
        if(business.getUserType() == 1){ 
            changeScreen(event, "AdminStart.fxml");
        }else if(business.getUserType()==2){ 
            changeScreen(event, "SocialWorkerStart.fxml");
        }
    }
    
}
