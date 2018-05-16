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
    private ListView<String> CaseListView;
    @FXML
    private Button GoToCaseButton;
    @FXML
    private TextField userCaseIDSearchTextField;
    @FXML
    private Button refreshButton;
    @FXML
    private AnchorPane SeeCasePane;
    @FXML
    private Button seeCaseBackButton;
    @FXML
    private Button seeCaseLogOutButton;
    private TextArea SeeCaseTextArea;
    @FXML
    private Label TitleLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label noCaseFoundLabel;
    @FXML
    private Button myInformationButton;
    @FXML
    private TextArea showCaseArea;
    @FXML
    private TextArea sdescription;
    @FXML
    private TextArea nEvaluation;
    @FXML
    private TextArea effortsneeded;

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
     private void change(AnchorPane from, AnchorPane to) {
        from.setVisible(false);
        from.setDisable(true);
        to.setVisible(true);
        to.setDisable(false);
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
    private void GoToCaseButtonClicked(ActionEvent event) throws IOException{
        if(business.isCaseInDB(userCaseIDSearchTextField.getText())){
            change(userStartPane, SeeCasePane);
            showCaseArea.setText(business.getCaseTextInput());
            TitleLabel.setText(business.getTitle());
            dateLabel.setText(business.getTime());
            sdescription.setText(business.getDescription());
            nEvaluation.setText(business.getEvaluation());
            effortsneeded.setText(business.getEffortNeeded());
        }else{
            noCaseFoundLabel.setText("ingen sag findes med det ID");
        }
        
    }

    @FXML
    private void refreshButtonClicked(ActionEvent event) {
     ObservableList<String> UserCase = FXCollections.observableArrayList(business.citizenCaseList());
     CaseListView.setItems(UserCase);   
    }

    @FXML
    private void seeCaseBackButtonClick(ActionEvent event) {
        change(SeeCasePane, userStartPane);
    }

    @FXML
    private void seeCaseLogOutButtonClick(ActionEvent event) throws IOException {
          changeScreen(event, "LoginScreen.fxml");
    }

    @FXML
    private void myInformationButtonClick(ActionEvent event) {
        nameLabel.setText(business.getName());
        addressLabel.setText(business.getAddress());
        numberLabel.setText(business.getNumber());
        CPRLabel.setText(business.getCpr());
    }
    
}
