/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

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
import static UserInterface.JavaFXApplication2.business;

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
     private void change(AnchorPane from, AnchorPane to) {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
    }
    
    @FXML
    /**
     * Inserts arraylist containing all cases into a listview
     */
    private void seeListOfCaseButtonClick(ActionEvent event) {
        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getCaseList()); 
        showCaseListView.setItems(UserCase);
    }

    @FXML
    /**
     * Method checks if inserted caseID is in database.
     * If caseID exists, the pane is changed, and the case values are insereted into textareas.
     * If caseID does not exist, an error message is displayed.
     */
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
    /**
     * Returns the user to their start menu, depending on usertype.
     */
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
    /**
     * Takes the inserted CPR number, and displays cases contained within that value.
     */
    private void searchButtonCaseListClick(ActionEvent event) {
        ObservableList<String> UserCase = FXCollections.observableArrayList(business.getSpecificCaseList(searchBarCaseList.getText())); 
        showCaseListView.setItems(UserCase);
    }

    @FXML
    /**
     * Changes pane, works like a return button
     */
    private void SeeCaseBackButtonclick(ActionEvent event) {
        change(findCaseAnchorPane, showCaseAnchorPane);
    }

    @FXML
    /**
     * Checks if inserted caseID is in database.
     * If it is, the case gets deleted in the database.
     * Else, an error message is displayed.
     */
    private void deleteCaseButtonClicked(ActionEvent event) {
    if(business.isIDInDB(deleteCaseTextField.getText())){
            business.deleteCase(deleteCaseTextField.getText());
            deleteCaseLabel.setText("Sagen er slettet");
        }else{
            deleteCaseLabel.setText("Der er en fejl med SagID");
        }
    }

    @FXML
    /**
     * Confirm button when deleting case.
     * If ID is in database, case is removed.
     * Else, an error message is displayed.
     */
    private void deleteCaseSafetyButtonClicked(ActionEvent event) {
        if(business.isIDInDB(deleteCaseTextField.getText())){
            business.deleteCase(deleteCaseTextField.getText());
            deleteCaseLabel.setText("Sagen er slettet");
        }else{
            deleteCaseLabel.setText("Der er en fejl med SagID");
        }
    }

    @FXML
    /**
     * Returns to Show Case pane.
     */
    private void backToMainScreen(ActionEvent event) {
        change(displayTheCasePane, showCaseAnchorPane);
    }

    @FXML
    /**
     * Logs user out of the system, returns to loginScreen.fxml.
     */
    private void logOutButton(ActionEvent event) throws IOException {
        changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    /**
     * Goes to the first input pane, where user inserts first value for evaluating a case.
     */
    private void goToFirstInput(ActionEvent event) {
        change(displayTheCasePane,firstInputPane);
    }

    @FXML
    /**
     * Returns to Show Case pane.
     */
    private void backToMainInput1(ActionEvent event) {
        change(firstInputPane,displayTheCasePane );
    }

    @FXML
    /**
     * Logs user out of the system, returns to loginScreen.fxml.
     */
    private void logOutFirstInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    /**
     * Goes to the second input pane, where user inserts second value for evaluating a case.
     */
    private void goToSecondInput(ActionEvent event) {
        change(firstInputPane, secondInputPane);
    }

    @FXML
    /**
     * Returns to first input pane for evaluating a case.
     */
    private void backToFirstInput(ActionEvent event) {
        change(secondInputPane, firstInputPane);
    }

    @FXML
    /**
     * Logs user out of the system, returns to LoginScreen.fxml.
     */
    private void logOutSecondInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
     /**
     * Goes to the third input pane, where user inserts third value for evaluating a case.
     */
    private void goToThirdInput(ActionEvent event) {
        change(secondInputPane, thirdInputPane);
    }

    @FXML
    /**
     * Returns to second input pane for evaluating a case.
     */
    private void backToSecondInput(ActionEvent event) {
        change(thirdInputPane, secondInputPane);
    }

    @FXML
    /**
     * Logs user out of the system, returns to LoginScreen.fxml.
     */
    private void logOutThirdInput(ActionEvent event) throws IOException {
         changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    /**
     * Checks if any of the input textareas are empty. 
     * If not, the values are saved with the case, and the case is evaluated.
     */
    private void evaluateCaseButton(ActionEvent event) throws IOException {
        if(firstInputTextArea.getText().equals("") || secondInputTextArea.getText().equals("") || thirdInputTextArea.getText().equals("")){
            
        }else{
            business.evaluateCase(firstInputTextArea.getText(), secondInputTextArea.getText(), thirdInputTextArea.getText());
                     changeScreen(event, "ShowCase.fxml");
        }
            
    }

    @FXML
    /**
     * Checks if inserted caseID is in database
     * If it is, the screen is changed to displayTheCase pane, and case evaluation starts.
     */
    private void startEvaluationButton(ActionEvent event) {
        if(business.isCaseInDB(deleteCaseTextField.getText())== true){
            change(showCaseAnchorPane, displayTheCasePane);
            showCaseTextArea.setText(business.getCaseTextInput());
        }
    }
    
}
