
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

import acquaintance.IData;
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
public class Data implements IData{
    Connection db = null;
    private String cpr;
    private String time;
    private String textinput;
    private String caseID;
    private int usertype;
    private String userName;
    private String password1;
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";

    public Data(){
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }catch(SQLException e){
            
        }
    }

    public boolean isInProfileDB(String name, String password) {
        Statement a = null;
        ResultSet øv = null;
        String nameInDatabase = "";
        String passwordInDatabase = "";
        boolean valid = false;
        try {

            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            øv = a.executeQuery("select * from Users");
            while (øv.next()) {
                nameInDatabase = øv.getString(1);
                passwordInDatabase = øv.getString(2);
                if (nameInDatabase.equalsIgnoreCase(name.trim()) && passwordInDatabase.equalsIgnoreCase(password.trim())) {
                this.usertype = øv.getInt(3);
                this.password1 = øv.getString(2);
                this.userName = øv.getString(1);
                    valid = true;
                    break;
                    //return true;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        if (valid == true) {
            return true;
        } else {
            return false;
        }
     //   return false;
    }
    public int getUsertype(){
        return this.usertype;
    }
    public String getUsername(){
        return this.userName;
    }
    public String getPassword(){
        return this.password1;
    }
    
    public List<String> getUserlist(){
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        String usertype = "";
        test.add("username :   password    : userType");
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from Users");
             while (øv.next()){
                  if(øv.getString(3).equalsIgnoreCase("1")){
                  usertype="Admin\n";
              }else if(øv.getString(3).equalsIgnoreCase("2")){
                  usertype="Sagsbehanlder\n";
              }else if(øv.getString(3).equalsIgnoreCase("3")){
                  usertype="Sekratær\n";
              }else{
                  usertype="Borger\n";
              }
                test.add(øv.getString("username")+"     :    "+øv.getString("password")+"   :    "+usertype);
             }
            
        }catch(Exception e){
            
        }
        return test;
    }
    
    
    public void createNewUser(String username,String password,int usertype){
      Statement a = null;
      ResultSet øv = null;
      try {
            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            øv = a.executeQuery("insert into Users values('"+username+"','"+password+"',"+usertype+")"); 
            
            
            
            
      }catch(Exception e){
          
      }
    }

//    public String getListOfUseresName(){
//       String test = "Username :\n";
//       try {
//
//            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
//            Statement a = db.createStatement();
//            ResultSet øv = a.executeQuery("select * from Users"); 
//            while(øv.next()){
//                test += øv.getString(1)+"\n";
//            }
//       }catch(Exception e){
//           
//       }
//       return test;
//    }
//  public String getListOfUseresPassword(){
//       
//       String test = "Password :\n";
//       try {
//
//           // Connection db = DriverManager.getConnection(this.url, this.username, this.password);
//            Statement a = db.createStatement();
//            ResultSet øv = a.executeQuery("select * from Users"); 
//            while(øv.next()){
//                test += øv.getString(2)+"\n";
//            }
//       }catch(Exception e){
//           
//       }
//       return test;
//    }
  
  
//   public String getListOfUseresType(){
//       Statement a = null;
//       ResultSet øv = null;
//       
//       String test = "Usertype :\n";
//       try {
//
//            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
//            a = db.createStatement();
//            øv = a.executeQuery("select * from Users"); 
//            while(øv.next()){
//         
//              if(øv.getString(3).equalsIgnoreCase("1")){
//                  test+="Admin\n";
//              }else if(øv.getString(3).equalsIgnoreCase("2")){
//                  test+="Sagsbehanlder\n";
//              }else if(øv.getString(3).equalsIgnoreCase("3")){
//                  test+="Sekratær\n";
//              }else{
//                  test+="Borger\n";
//              }
//            }
//       }catch(Exception e){
//           
//       }
//       return test;
//    }
   
   public void deleteUser(String name,String password){
       Statement a = null;
       ResultSet øv = null;
     try {

            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            øv = a.executeQuery("delete from Users where username = '"+name+"' and password= '"+password+"'"); 
            
     }catch(Exception e){
         
     }        
    
}

//    public static void main(String[] args){
////        logicLogin a = new logicLogin();
////        System.out.println(a.isInProfileDB("Kristian" , "1234"));
////        System.out.println(a.getUsertype());
////        a.createNewUser("noget","1234",3);
//        Date r = new Date();
//       
//        System.out.println(r);
//        //System.out.println(a.getListOfUseres());
//    }


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
