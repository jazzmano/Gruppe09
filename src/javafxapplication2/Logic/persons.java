/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

import acquaintance.Ipersons;
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
    
    @Override
    public String getCpr() {
        return this.getCPR;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
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
}
