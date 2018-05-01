/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic.starter;

import acquaintance.IBusiness;
import acquaintance.IData;
import acquaintance.IUI;
import javafxapplication2.JavaFXApplication2;
import javafxapplication2.Logic.BussniessFacade.Business;
import javafxapplication2.Logic.Data;

/**
 *
 * @author nicol
 */
public class starter {
    
    public static void main(String[] args) {
    
        IData data = new Data();
        IBusiness bus = new Business();
        bus.injectData(data);
        IUI ui = new JavaFXApplication2();
        
        ui.injectBusiness(bus);
        ui.startApplication(args);
    
    }
    
    
}
