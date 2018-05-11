/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic;

import acquaintance.Icases;
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
public class cases implements Icases{
   
    private String textinput;
    private String time;
    private String caseID;
    Connection db = null;
    private final String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/jrqqkajy";
    private final String username = "jrqqkajy";
    private final String password = "HBsjDFGy5QmbskR9yiPzvJMl1qtnQ9s8";
    
    public cases() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {

        }
    }
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
    @Override
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
    @Override
     public void test2OpretTing(String cpr, String textinput) {
        if (Test(cpr) == true) {
            createCaseNEW(textinput);
            virknu(cpr);
        }
    }
    @Override
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
    @Override
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
    @Override
     public void virknu(String cpr) {
        Statement a = null;
        ResultSet øv = null;
        try {
            a = db.createStatement();//vigtig fejlen er i den nedenstående linje 
            øv = a.executeQuery("insert into percas values('" + cpr + "','" + (howManyCasesInDB()-1) + "')");

        } catch (Exception e) {

        }
    }
}
