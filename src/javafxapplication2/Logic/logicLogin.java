/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nicol
 */
public class logicLogin {
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";
    
    public logicLogin(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    public void test(){
        try{
        Connection db = DriverManager.getConnection(this.url, this.username, this.password);  
        Statement a = db.createStatement();
        ResultSet øv = a.executeQuery("select * from Users");
        while(øv.next()){
            System.out.println(øv.getString(1));
            System.out.println(øv.getString(2));
            System.out.println(øv.getString(3));
        }
        }catch(Exception e){
            
        }
        
    }
    public static void main(String[] args) {
        logicLogin a = new logicLogin();
        a.test();
    }
}
