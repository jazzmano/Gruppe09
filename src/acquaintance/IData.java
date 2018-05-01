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
    public void createNewUser(String username,String password,int usertype);
    public void deleteUser(String name,String password);
    
    public void createNewCase(String cpr,String textInput);
    public List<String> getCaseList();
    public boolean isCaseInDb(String cpr,String id);
    public String getCaseTextinput();
    public String getCaseCPR();
    public String getTime();
    public String getCaseID();
    
 
}