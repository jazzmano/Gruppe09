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
public class characterCheck {
    private String username; 
    private String password; 
    
    public characterCheck(){
        
    }
    public String trimForSpaceUsername(String username){
        this.username = username.trim();
        return this.username;
    }
    public String trimForSpacePassword(String password){
        password.trim();
        return password;
    }
    
    
}
