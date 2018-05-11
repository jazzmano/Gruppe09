/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ShowCaseController implements Initializable {

    @FXML
    private AnchorPane showCaseAnchorPane;
    @FXML
    private Button seeListOfCaseButton;
    @FXML
    private ListView<String> showCaseListView;
    @FXML
    private TextField idSearchField;
    @FXML
    private Button findeCaseButton;
    @FXML
    private Label indsnfoinsdofosfd;
    @FXML
    private Button BackToUserMenueButton;
    @FXML
    private TextField searchBarCaseList;
    @FXML
    private Button searchButtonCaseList;
    @FXML
    private AnchorPane findCaseAnchorPane;
    @FXML
    private TextArea showCaseArea;
    @FXML
    private Label cprOutputLabel;
    @FXML
    private Label caseTimeLabel;
    @FXML
    private Label caseIDLabel;
    @FXML
    private Button SeeCaseBackButton;
    @FXML
    private Button deleteCaseButton;
    @FXML
    private TextField deleteCaseTextField;
    @FXML
    private Button deleteCaseSafetyButton;
    @FXML
    private Label deleteCaseLabel;

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
     private void change(AnchorPane from, AnchorPane to) {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
    }
    
    @FXML
    private void seeListOfCaseButtonClick(ActionEvent event) {
        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getCaseList()); 
        showCaseListView.setItems(UserCase);
    }

    @FXML
    private void findeCaseButtonClick(ActionEvent event) throws IOException {
        if(business.isCaseInDB(idSearchField.getText())){
            change(showCaseAnchorPane, findCaseAnchorPane);
            showCaseArea.setWrapText(true);
            showCaseArea.setText(business.getCaseTextInput());
            cprOutputLabel.setText(business.getCaseCPR());
            caseTimeLabel.setText(business.getTime());
            caseIDLabel.setText(business.getCaseID());
        }else{
            indsnfoinsdofosfd.setText("ID findes ikke - prøv igen! ");
        }   
        
    }

    @FXML
    private void BackToUserMenueButtonClick(ActionEvent event) throws IOException {
        if(business.getUserType()==1){
            changeScreen(event, "AdminStart.fxml");
        }else if(business.getUserType()==2){
            changeScreen(event, "SocialWorkerStart.fxml");
        }else if(business.getUserType()==3){
            changeScreen(event, "SecretaryStart.fxml");
        }
    }

    @FXML
    private void searchButtonCaseListClick(ActionEvent event) {
        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getSpecificCaseList(searchBarCaseList.getText())); 
        showCaseListView.setItems(UserCase);
    }

    @FXML
    private void SeeCaseBackButtonclick(ActionEvent event) {
        change(findCaseAnchorPane, showCaseAnchorPane);
    }

    @FXML
    private void deleteCaseButtonClicked(ActionEvent event) {
         deleteCaseTextField.setVisible(true);
        deleteCaseTextField.setDisable(false);
        deleteCaseSafetyButton.setVisible(true);
        deleteCaseSafetyButton.setDisable(false);
    }

    @FXML
    private void deleteCaseSafetyButtonClicked(ActionEvent event) {
        if(business.isIDInDB(deleteCaseTextField.getText())){
            business.deleteCase(deleteCaseTextField.getText());
            deleteCaseLabel.setText("Sagen er slettet");
        }else{
            deleteCaseLabel.setText("Der er en fejl med SagID");
        }
    }
    
}
