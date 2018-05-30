/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import java.util.List;

/**
 *
 * @author nicol
 */
public interface IBusiness {
    
    public void injectData(IData dataLayer);
    
    public boolean isProfileInDB(String name,String password);
    
    public int getUserType();
    
    public String getUsername();
    
    public String getPassword();
    
    public List<String> getUserList();
   
    public void createNewUser(String username,String password,int usertype,String cpr,String address,String number,String name);
    
    public void deleteUser(String name,String password);
    
   // public void creataNewCase(String cpr,String textInput);
    
    public List<String> getCaseList();
    
    public boolean isCaseInDB(String id);
    
    public String getCaseTextInput();
    
    public String getCaseCPR();
    
    public String getTime();
    
    public String getCaseID();
    
    public List<String> getSpecificCaseList(String list);
    
    public void CreateCaseInPercasAndCases(String cpr, String textinput,String title);
    public boolean ChecIfCprExists(String CPR);
    
    public void insertInToPercas(String cpr);
     
    
    public int howManyCasesInDB();
    public void createCaseNEW(String text,String title);
    public void deleteFromCases(String ID);
    public void deleteFromPercas(String ID);
    public boolean isIDInDB(String ID);
    public void deleteCase(String ID);
    public String getName();
    public String getAddress();
    public String getNumber();
    public String getCpr();

    public String getTitle();
    public List<String> citizenCaseList();
    public void evaluateCase(String text1, String text2, String text3);
    public String getDescription();
    public String getEffortNeeded();
    public String getEvaluation();

}
