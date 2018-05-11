/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import java.util.List;

/**
 *
 * @author nicol
 */
public interface IData {
    
    public boolean isInProfileDB(String name, String password);
    public int getUsertype();
    public String getUsername();
    public String getPassword();
    public List<String> getUserlist();
    public void createNewUser(String username,String password,int usertype,String cpr,String address,String number,String name);
    public void deleteUser(String name,String password);
    
  //  public void createNewCase(String cpr,String textInput);
    public List<String> getCaseList();
    public boolean isCaseInDb(String id);
    public String getCaseTextinput();
    public String getCaseCPR();
    public String getTime();
    public String getCaseID();
    public List<String> getSpecificCaseList(String CPR);
    
    public String getCpr();
    public String getAddress();
    public String getNumber();
    public String getName();
    
    public boolean Test(String CPR);
    public void test2OpretTing(String cpr,String textinput);
    public int howManyCasesInDB();
    public void createCaseNEW(String text);
    public void deleteFromCases(String ID);
    public void deleteFromPercas(String ID);
    public boolean isIDInDB(String ID);
    public void deleteCase(String ID);
}