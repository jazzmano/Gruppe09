/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.Ipersons;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class persons implements Ipersons{
    
    private String name;
    private String number;
    private String address;
    private String getCPR;
    private String userName;
    private String password1;
    private int usertype;

    Connection db = null;
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";
    
     public persons() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
        }
    }
     
    /**
     * Gets a username and a password, and checks if its in database.
     * If true, the method returns the values for the user, and logs them in
     * If false, a false value is returned
     * @param name
     * @param password
     * @return Boolean valid
     */
    @Override
    public boolean isInProfileDB(String name, String password) {
        Statement a = null;
        ResultSet øv = null;
        String nameInDatabase = "";
        String passwordInDatabase = "";
        boolean valid = false;
        try {
            a = db.createStatement();
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
    }
    
    /**
     * Gets the profiles CPR number
     * @return String getCPR
     */
    @Override
    public String getCpr() {
        
        return "CPR: "+this.getCPR;
    }
   /**
    * Gets profiles address
    * @return String address
    */
    @Override
    public String getAddress() {
        return "Address: "+this.address;
    }
    /**
    * Gets profiles phone number 
    * @return String number
    */ 
    @Override
    public String getNumber() {
        return "Number: "+this.number;
    }
    /**
    * Gets profiles name 
    * @return String name
    */
    @Override
    public String getName() {
        return "navn: "+this.name;
    }
    /**
     * Gets profiles usertype
     * @return Int usertype
     */
    @Override
    public int getUsertype() {
        return this.usertype;
    }
    
    /**
     * Gets profiles Username
     * @return String userName
     */
    @Override
        public String getUsername() {
        return this.userName;
    }
    /**
     * Gets profiles password
     * @return String password1
     */
    @Override
        public String getPassword() {
        return this.password1;
    }
    /**
     * Checks in database for users
     * Adds users with their name, password and usertype to ArrayList test
     * @return ArrayList test
     */
    @Override
        public List<String> getUserlist() {
        Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        String usertype = "";
        test.add("username \t: password \t: userType");
        try {
            a = db.createStatement();
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
     /**
      * Takes in user inputs
      * Adds a user in the database Persons with the user inputs
      * @param username
      * @param password
      * @param usertype
      * @param cpr
      * @param address
      * @param number
      * @param name 
      */
    @Override
    public void createNewUser(String username, String password, int usertype, String cpr, String address, String number, String name) {
        Statement a = null;
        ResultSet øv = null;
        try {
            a = db.createStatement();
            øv = a.executeQuery("insert into Persons values('" + username + "','" + password + "'," + usertype + ",'" + cpr + "','" + address + "','" + number + "','" + name + "')");

        } catch (Exception e) {

        }
    }
    /**
     * Takes in user input
     * Tries to delete users in database with that matching name and password
     * @param name
     * @param password 
     */
    @Override
     public void deleteUser(String name, String password) {
        Statement a = null;
        ResultSet øv = null;
        try {
            a = db.createStatement();
            øv = a.executeQuery("delete from Persons where username = '" + name + "' and password = '" + password + "'");

        } catch (Exception e) {

        }

    }
    /**
     * Checks in database for cases linked to the users CPR
     * If there is any, the values ID, Title and Time from the case is added to the ArrayList test
     * @return ArrayList test
     */
       @Override

     public List<String> citizenCaseList(){
       Statement a = null;
        ResultSet øv = null;
        ArrayList<String> test = new ArrayList();
        test.add("ID\t:\t Title\t:\t Time");

        try {
            a = db.createStatement(); 
            øv = a.executeQuery("select percas.caseID, cases.title, cases.date "
                    + "from percas, cases, persons "
                    + "where persons.cpr = '"+this.getCPR+"'" 
                    + " AND percas.caseID = cases.caseID"
                    + " AND percas.cpr = persons.cpr");
            
            while (øv.next()) {
                test.add(øv.getString(1) + "\t\t" + øv.getString(2)+ "\t\t\t" + øv.getString(3));
            }
        } catch (Exception e) {

        }   
        return test;
     }
     
}
