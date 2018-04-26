/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author nicol
 */
public class logicCreatCase {
    Connection db = null;
    private String cpr;
    private String time;
    private String textinput;
    private String caseID;
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";

    public logicCreatCase(){
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }catch(SQLException e){   
        }
    }
    public void createNewCase(String cpr,String textInput){
      Statement a = null;
      ResultSet øv = null;
      Statement aa = null;
      ResultSet øvø = null;
      Date currentTime = new Date();
      try {
            aa = db.createStatement();
            øvø = aa.executeQuery("select * from caseTable");
            int i = 0;
            while(øvø.next()){
            i++;
            }
            a = db.createStatement();
            øv = a.executeQuery("insert into caseTable values('"+cpr+"','"+currentTime+"','"+textInput+"','"+i+"')");    
      }catch(Exception e){
          
      }
    }
    
    public void getCaseID(){
        
    }
    public static void main(String[] args) {
        logicCreatCase a = new logicCreatCase();
        a.createNewCase("lksndlkvnslkvs", "oinsdgoinsoignoids");
    }
}
