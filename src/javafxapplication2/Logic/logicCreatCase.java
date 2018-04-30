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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        
    public List<String> getCaseList(){
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        test.add("CPR\t:\t ID\t:\t Time");
        
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from caseTable");
            
            while(øv.next()){
                test.add(øv.getString(1)+"\t\t"+øv.getString(4)+"\t\t"+øv.getString(2));
            }
            
        }catch(Exception e){
            
        }
       return test;
    }
    public boolean isCaseInDb(String cpr,String id){
        Statement a = null;
        ResultSet øv = null;
        boolean i = false;
        String cprInDb = "";
        String idInDb = "";
        
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from caseTable");
            while(øv.next()){
                cprInDb = øv.getString(1);
                idInDb = øv.getString(4);
                if(cprInDb.equalsIgnoreCase(cpr.trim()) && idInDb.equalsIgnoreCase(id.trim())){
                  this.cpr = øv.getString(1);
                  this.caseID = øv.getString(4);
                  this.time = øv.getString(2);
                  this.textinput = øv.getString(3);
                    i = true;
                    break;
                }
            }
        }catch(Exception e){
            
        }
        return i;
    }
    
    public String getCaseTextinput(){
         Statement a = null;
         ResultSet øv = null;
         String text = "Text:\t";
         try{
             a = db.createStatement();
             øv = a.executeQuery("select * from caseTable where cpr = '"+this.cpr+"' AND caseid = '"+this.caseID+"';");
            while(øv.next()){
                 text += øv.getString(3);
            }
            
         }catch(Exception e){
             
         }
         return text;
    }
    
    public String getCaseCPR(){
        Statement a = null;
        ResultSet øv = null;
        String text = "CPR :\t";
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from caseTable where cpr = '"+this.cpr+"' AND caseid = '"+this.caseID+"';");
            while(øv.next()){
                text += øv.getString(1);
            }
        }catch(Exception e){
            
        }
        return text;
    }
    
    public String getTime(){
        
    Statement a = null;
         ResultSet øv = null;
         String text = "Time:\t";
         try{
             a = db.createStatement();
             øv = a.executeQuery("select * from caseTable where cpr = '"+this.cpr+"' AND caseid = '"+this.caseID+"';");
            while(øv.next()){
                 text += øv.getString(2);
            }
            
         }catch(Exception e){
             
         }
         return text;
   
    }
    
    public String getCaseID(){
        Statement a = null;
         ResultSet øv = null;
         String text = "CaseID :\t";
         try{
             a = db.createStatement();
             øv = a.executeQuery("select * from caseTable where cpr = '"+this.cpr+"' AND caseid = '"+this.caseID+"';");
            while(øv.next()){
                 text += øv.getString(4);
            }
            
         }catch(Exception e){
             
         }
         return text;
    }
}
