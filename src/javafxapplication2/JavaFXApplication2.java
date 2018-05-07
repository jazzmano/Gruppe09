/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import acquaintance.IBusiness;
import acquaintance.IUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author euc
 */
public class JavaFXApplication2 extends Application implements IUI{
    
   public static IBusiness business;
    
//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
//        Parent root = loader.load();
//        
//        FXMLDocumentController controller = loader.getController();
//        controller.injectBusiness(business);
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    @Override
//    public void injectBusiness(IBusiness businessLayer) {
//        business = businessLayer;
//    }
//
//    @Override
//    public void startApplication(String[] args) {
//        launch(args);
//    }
     @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        Parent root = loader.load();
        
        LoginScreenController controller = loader.getController();
        controller.injectBusiness(business);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void injectBusiness(IBusiness businessLayer) {
        business = businessLayer;
    }

    @Override
    public void startApplication(String[] args) {
        launch(args);
    }
        
   
}
