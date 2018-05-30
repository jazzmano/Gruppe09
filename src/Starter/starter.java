/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IUI;
import UserInterface.JavaFXApplication2;
import Business.Business;
import Data.Data;

/**
 *
 * @author nicol
 */
public class starter {
    
    public static void main(String[] args) {
  /**
   Glue code
   */
        IData data = new Data();
        
        IBusiness bus = new Business();
        bus.injectData(data);
        
        IUI ui = new JavaFXApplication2();
        
        ui.injectBusiness(bus);
        
        ui.startApplication(args);
       
    
    }
    
    
}
