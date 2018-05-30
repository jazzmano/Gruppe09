/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Acquaintance.IBusiness;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static UserInterface.JavaFXApplication2.business;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class AccessUserController implements Initializable {
    
    
    
    @FXML
    private AnchorPane accessUserAnchorPane;
    @FXML
    private Button ListOfUserButton;
    @FXML
    private Button CreateUserButton;
    @FXML
    private Button backToAdminPane;
    @FXML
    private Button deleteUserButton;
    @FXML
    private TextField deleteUserTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private Text erBrugerenSlettetLabel;
    @FXML
    private TextField deletePasswordTextField;
    @FXML
    private ListView<String> TestListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    /**
     *  Method to change between .fxml documents (scenes)
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
     * Method adds an arraylist containing users to a listview
     */
    private void ListOfUserButtonClick(ActionEvent event) {
          ObservableList<String> userTest = FXCollections.observableArrayList(business.getUserList()); 
          TestListView.setItems(userTest);
    }

    @FXML
    /**
     * Method changes scene to CreateUser.fxml
     */
    private void CreateUserButtonClick(ActionEvent event) throws IOException { 
        changeScreen(event, "CreateUser.fxml");
    }

    @FXML
    /**
     * Method changes scene to AdminStart.fxml
     */
    private void backToAdminPaneClick(ActionEvent event) throws IOException {
        changeScreen(event, "AdminStart.fxml");
    }

    @FXML
    /**
     * Displays two textfields and a confirm button for deleting users
     */
    private void deleteUserButtonClick(ActionEvent event) {
        deleteUserTextField.setVisible(true);
        deleteUserTextField.setDisable(false);
        deletePasswordTextField.setVisible(true);
        deletePasswordTextField.setDisable(false);
        confirmButton.setVisible(true);
        confirmButton.setDisable(false);
    }

    @FXML
    /**
     * Checks if name and password exists in the database, if it does, the user gets deleted
     */
    private void conformButtonClick(ActionEvent event) {
        if(business.isProfileInDB(deleteUserTextField.getText(), deletePasswordTextField.getText())){
            business.deleteUser(deleteUserTextField.getText(), deletePasswordTextField.getText());
            erBrugerenSlettetLabel.setText("Bruger er fjernet");
        }else
            erBrugerenSlettetLabel.setText("Ingen bruger med det navn");
    }
    
}
