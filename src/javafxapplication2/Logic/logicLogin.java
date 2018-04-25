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
public class logicLogin{
    private int usertype;
    private String userName;
    private String password1;
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";

    public logicLogin() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public boolean isInProfileDB(String name, String password) {
        String nameInDatabase = "";
        String passwordInDatabase = "";
        boolean valid = false;
        try {

            Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            Statement a = db.createStatement();
            ResultSet øv = a.executeQuery("select * from Users");
            while (øv.next()) {
                nameInDatabase = øv.getString(1);
                passwordInDatabase = øv.getString(2);
                if (nameInDatabase.equalsIgnoreCase(name.trim()) && passwordInDatabase.equalsIgnoreCase(password.trim())) {
                this.usertype = øv.getInt(3);
                //this.password1 = øv.getString(2);
                //this.userName = øv.getString(1);
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
    
    
    public void createNewUser(String username,String password,int usertype){
        
      try {
            Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            Statement a = db.createStatement();
            ResultSet øv = a.executeQuery("insert into Users values('"+username+"','"+password+"',"+usertype+")"); 
            
            
            
            
      }catch(Exception e){
          
      }
    }

    public String getListOfUseresName(){
       String test = "Username :\n";
       try {

            Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            Statement a = db.createStatement();
            ResultSet øv = a.executeQuery("select * from Users"); 
            while(øv.next()){
                test += øv.getString(1)+"\n";
            }
       }catch(Exception e){
           
       }
       return test;
    }
  public String getListOfUseresPassword(){
       String test = "Password :\n";
       try {

            Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            Statement a = db.createStatement();
            ResultSet øv = a.executeQuery("select * from Users"); 
            while(øv.next()){
                test += øv.getString(2)+"\n";
            }
       }catch(Exception e){
           
       }
       return test;
    }
  
  
   public String getListOfUseresType(){
       String test = "Usertype :\n";
       try {

            Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            Statement a = db.createStatement();
            ResultSet øv = a.executeQuery("select * from Users"); 
            while(øv.next()){
              //  test += øv.getString(3)+"\n";
              if(øv.getString(3).equalsIgnoreCase("1")){
                  test+="Admin\n";
              }else if(øv.getString(3).equalsIgnoreCase("2")){
                  test+="Sagsbehanlder\n";
              }else if(øv.getString(3).equalsIgnoreCase("3")){
                  test+="Sekratær\n";
              }else{
                  test+="Borger\n";
              }
            }
       }catch(Exception e){
           
       }
       return test;
    }

//    public static void main(String[] args) {
//        logicLogin a = new logicLogin();
//        System.out.println(a.isInProfileDB("Kristian" , "1234"));
//        System.out.println(a.getUsertype());
//        a.createNewUser("noget","1234",3);
//        System.out.println(a.getListOfUseres());
//    }
}
