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
public interface IBusiness {
    
    public void injectData(IData dataLayer);
    
    public boolean isProfileInDB(String name,String password);
    
    public int getUserType();
    
    public String getUsername();
    
    public String getPassword();
    
    public List<String> getUserList();
   
    public void createNewUser(String username,String password,int usertype);
    
    public void deleteUser(String name,String password);
    
    public void creataNewCase(String cpr,String textInput);
    
    public List<String> getCaseList();
    
    public boolean isCaseInDB(String cpr,String id);
    
    public String getCaseTextInput();
    
    public String getCaseCPR();
    
    public String getTime();
    
    public String getCaseID();
    
    public List<String> getSpecificCaseList(String list);
}
