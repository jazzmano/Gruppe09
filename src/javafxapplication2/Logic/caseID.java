/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

/**
 *
 * @author nicol
 */
public class caseID {
    
    private int id = 1;
    
    public caseID(){
        
    }
    public void increaseID(){
        this.id++;
    }
    
    public int getID(){
        return this.id;
    }
}
