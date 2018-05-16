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
    @FXML
    private Label Title;
    @FXML
    private AnchorPane displayTheCasePane;
    @FXML
    private Button backToMainScreen;
    @FXML
    private Button logOutButton;
    @FXML
    private TextArea showCaseTextArea;
    @FXML
    private Button goToFirstInput;
    @FXML
    private Button backToMainInput1;
    @FXML
    private Button logOutFirstInput;
    @FXML
    private TextArea firstInputTextArea;
    @FXML
    private Button goToSecondInput;
    @FXML
    private Button backToFirstInput;
    @FXML
    private Button logOutSecondInput;
    @FXML
    private TextArea secondInputTextArea;
    @FXML
    private Button goToThirdInput;
    @FXML
    private Button backToSecondInput;
    @FXML
    private Button logOutThirdInput;
    @FXML
    private TextArea thirdInputTextArea;
    @FXML
    private Button evaluateCaseButton;
    @FXML
    private AnchorPane firstInputPane;
    @FXML
    private AnchorPane secondInputPane;
    @FXML
    private AnchorPane thirdInputPane;
    @FXML
    private TextArea sdescription;
    @FXML
    private TextArea nEvaluation;
    @FXML
    private TextArea effortsneeded;

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
            Title.setText(business.getTitle());
            sdescription.setText(business.getDescription());
            nEvaluation.setText(business.getEvaluation());
            effortsneeded.setText(business.getEffortNeeded());
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
//         deleteCaseTextField.setVisible(true);
//        deleteCaseTextField.setDisable(false);
//        deleteCaseSafetyButton.setVisible(true);
//        deleteCaseSafetyButton.setDisable(false);
    if(business.isIDInDB(deleteCaseTextField.getText())){
            business.deleteCase(deleteCaseTextField.getText());
            deleteCaseLabel.setText("Sagen er slettet");
        }else{
            deleteCaseLabel.setText("Der er en fejl med SagID");
        }
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

    @FXML
    private void backToMainScreen(ActionEvent event) {
        change(displayTheCasePane, showCaseAnchorPane);
    }

    @FXML
    private void logOutButton(ActionEvent event) throws IOException {
        changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void goToFirstInput(ActionEvent event) {
        change(displayTheCasePane,firstInputPane);
    }

    @FXML
    private void backToMainInput1(ActionEvent event) {
        change(firstInputPane,displayTheCasePane );
    }

    @FXML
    private void logOutFirstInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void goToSecondInput(ActionEvent event) {
        change(firstInputPane, secondInputPane);
    }

    @FXML
    private void backToFirstInput(ActionEvent event) {
        change(secondInputPane, firstInputPane);
    }

    @FXML
    private void logOutSecondInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void goToThirdInput(ActionEvent event) {
        change(secondInputPane, thirdInputPane);
    }

    @FXML
    private void backToSecondInput(ActionEvent event) {
        change(thirdInputPane, secondInputPane);
    }

    @FXML
    private void logOutThirdInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void evaluateCaseButton(ActionEvent event) {
        if(firstInputTextArea.getText().equals("") || secondInputTextArea.getText().equals("") || thirdInputTextArea.getText().equals("")){
            
        }else{
            business.evaluateCase(firstInputTextArea.getText(), secondInputTextArea.getText(), thirdInputTextArea.getText());
        }
            
    }

    @FXML
    private void startEvaluationButton(ActionEvent event) {
        if(business.isCaseInDB(deleteCaseTextField.getText())== true){
            change(showCaseAnchorPane, displayTheCasePane);
            showCaseTextArea.setText(business.getCaseTextInput());
        }
    }
    
}
