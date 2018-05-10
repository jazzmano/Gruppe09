
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
public class Data implements IData {

    Connection db = null;
    private String cpr;
    private String time;
    private String textinput;
    
    private String caseID;
    private int usertype;
    private String userName;
    private String password1;
    // test se om det virker
    private String getCPR;
    private String address;
    private String number;
    private String name;

    private int antalSager = 20;

    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";

    public Data() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {

        }
    }

    @Override
    public boolean isInProfileDB(String name, String password) {
        Statement a = null;
        ResultSet øv = null;
        String nameInDatabase = "";
        String passwordInDatabase = "";
        boolean valid = false;
        try {

            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            //øv = a.executeQuery("select * from Users");
            øv = a.executeQuery("select * from Persons");

            while (øv.next()) {
                nameInDatabase = øv.getString(1);
                passwordInDatabase = øv.getString(2);
                if (nameInDatabase.equalsIgnoreCase(name.trim()) && passwordInDatabase.equalsIgnoreCase(password.trim())) {
                    this.usertype = øv.getInt(3);
                    this.password1 = øv.getString(2);
                    this.userName = øv.getString(1);
                    this.getCPR = øv.getString(4);
                    this.address = øv.getString(5);
                    this.number = øv.getString(6);
                    this.name = øv.getString(7);
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

    public String getCpr() {
        return this.getCPR;
    }

    public String getAddress() {
        return this.address;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int getUsertype() {
        return this.usertype;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password1;
    }

    @Override
    public List<String> getUserlist() {
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        String usertype = "";
        test.add("username \t: password \t: userType");
        try {
            a = db.createStatement();
            //øv = a.executeQuery("select * from Users");
            øv = a.executeQuery("select * from Persons");
            while (øv.next()) {
                if (øv.getString(3).equalsIgnoreCase("1")) {
                    usertype = "Admin\n";
                } else if (øv.getString(3).equalsIgnoreCase("2")) {
                    usertype = "Sagsbehanlder\n";
                } else if (øv.getString(3).equalsIgnoreCase("3")) {
                    usertype = "Sekratær\n";
                } else {
                    usertype = "Borger\n";
                }
                test.add(øv.getString("username") + " \t\t:\t" + øv.getString("password") + " \t\t:\t" + usertype);
            }

        } catch (Exception e) {

        }
        return test;
    }

    @Override
    public void createNewUser(String username, String password, int usertype, String cpr, String address, String number, String name) {
        Statement a = null;
        ResultSet øv = null;
        try {
            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            //øv = a.executeQuery("insert into Users values('"+username+"','"+password+"',"+usertype+")"); 
            øv = a.executeQuery("insert into Persons values('" + username + "','" + password + "'," + usertype + ",'" + cpr + "','" + address + "','" + number + "','" + name + "')");

        } catch (Exception e) {

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
    @Override
    public void deleteUser(String name, String password) {
        Statement a = null;
        ResultSet øv = null;
        try {

            //Connection db = DriverManager.getConnection(this.url, this.username, this.password);
            a = db.createStatement();
            øv = a.executeQuery("delete from Persons where username = '" + name + "' and password = '" + password + "'");

        } catch (Exception e) {

        }

    }

    
    //Skal muligvis bruges eller slettes.
    
    
//    @Override
//    public void createNewCase(String cpr, String textInput) {
//        Statement a = null;
//        ResultSet øv = null;
//        Statement aa = null;
//        ResultSet øvø = null;
//        Date currentTime = new Date();
//        try {
//            aa = db.createStatement();
//            øvø = aa.executeQuery("select * from caseTable");
//            int i = 0;
//            while (øvø.next()) {
//                i++;
//            }
//            a = db.createStatement();
//            øv = a.executeQuery("insert into caseTable values('" + cpr + "','" + currentTime + "','" + textInput + "','" + i + "')");
//        } catch (Exception e) {
//
//        }
//    }
    
    @Override
    public List<String> getCaseList() {
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        test.add("ID\t:\t\tCPR\t\t:\t Time");

        try {
            a = db.createStatement();
            øv = a.executeQuery("select percas.caseID , percas.cpr, cases.date "
                    + "from cases,percas,persons "
                    + "where percas.caseid = cases.caseid AND "
                    + "percas.cpr = persons.cpr");

            while (øv.next()) {
                test.add(øv.getString(1) + "\t\t" + øv.getString(2)+ "\t\t\t" + øv.getString(3));
            }

        } catch (Exception e) {

        }
        return test;
    }

    @Override
    public boolean isCaseInDb(String id) {
        Statement a = null;
        ResultSet øv = null;
        boolean i = false;
       // String cprInDb = "";
        String idInDb = "";

        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from cases");
            while (øv.next()) {
         //       cprInDb = øv.getString(1);
                idInDb = øv.getString(1);
                if (idInDb.equalsIgnoreCase(id.trim())) {
                   // this.cpr = øv.getString(1);
                    this.caseID = øv.getString(1);
                    this.time = øv.getString(2);
                    this.textinput = øv.getString(3);
                    i = true;
                    break;
                }
            }
        } catch (Exception e) {

        }
        return i;
    }
//skal muligvis bruges eller slettes
    @Override
    public String getCaseTextinput() {
        Statement a = null;
        ResultSet øv = null;
        String text = "Text:\t";
        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from cases where caseid = '" + caseID + "'");
            while (øv.next()) {
                text += øv.getString(3);
            }

        } catch (Exception e) {

        }
        return text;
    }
////    skal muligvis bruges eller slettes
    @Override
    public String getCaseCPR() {
        Statement a = null;
        ResultSet øv = null;
        String text = "CPR :\t";
        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from percas where caseid = '" + this.caseID + "';");
            while (øv.next()) {
                text += øv.getString(1);
            }
        } catch (Exception e) {

        }
        return text;
    }
    
  

    @Override
    public String getTime() {

        Statement a = null;
        ResultSet øv = null;
        String text = "Time:\t";
        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from cases where caseid = '" + this.caseID + "';");
            while (øv.next()) {
                text += øv.getString(2);
            }

        } catch (Exception e) {

        }
        return text;

    }

    @Override
    public String getCaseID() {
        Statement a = null;
        ResultSet øv = null;
        String text = "CaseID :\t";
        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from cases where caseid = '" + this.caseID + "';");
            while (øv.next()) {
                text += øv.getString(1);
            }

        } catch (Exception e) {

        }
        return text;
    }

    @Override
    public List<String> getSpecificCaseList(String CPR) {
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        test.add("CPR\t:\t ID\t:\t Time");

        try {
            a = db.createStatement();
            øv = a.executeQuery("select persons.cpr, cases.caseid,cases.date "
                    + "from persons,cases,percas "
                    + "where percas.cpr ='"+CPR+"' AND "
                    + "percas.cpr = persons.cpr AND "
                    + " cases.caseid = percas.caseid ");

            while (øv.next()) {
                test.add(øv.getString(1) + "\t\t" + øv.getString(2) + "\t\t" + øv.getString(3));
            }

        } catch (Exception e) {

        }
        return test;
    }

    public boolean Test(String CPR) {
        Statement a = null;
        ResultSet øv = null;

        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from persons where cpr = '" + CPR + "';");
            while (øv.next()) {
                if (øv.getString(4).equals(CPR)) {
                    return true;
                }
            }

        } catch (Exception e) {

        }
        return false;
    }

    public void test2OpretTing(String cpr, String textinput) {
        if (Test(cpr) == true) {
            createCaseNEW(textinput);
            virknu(cpr);
        }
    }

    public int howManyCasesInDB() {
        Statement a = null;
        ResultSet øv = null;
        int i = 300;
        try {
            a = db.createStatement();
            øv = a.executeQuery("select * from cases");

            while (øv.next()) {
               i++;
            }

        } catch (Exception e) {

        }
        return i;

    }

    public void createCaseNEW(String text) {
        Statement a = null;
        ResultSet øv = null;
        Date currentTime = new Date();
        try {
            a = db.createStatement();
            øv = a.executeQuery("insert into cases values('" + howManyCasesInDB()+ "','" + currentTime + "','" + text + "')");
        } catch (Exception e) {

        }
    }

    public void virknu(String cpr) {
        Statement a = null;
        ResultSet øv = null;
        try {
            a = db.createStatement();//vigtig fejlen er i den nedenstående linje 
            øv = a.executeQuery("insert into percas values('" + cpr + "','" + (howManyCasesInDB()-1) + "')");

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        Data a = new Data();
        System.out.println(a.Test("123"));
        System.out.println(a.howManyCasesInDB());
       
        
    }


}
