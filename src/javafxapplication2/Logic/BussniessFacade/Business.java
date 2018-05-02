/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2.Logic.BussniessFacade;

import acquaintance.IBusiness;
import acquaintance.IData;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Business implements IBusiness{
    
    private IData data;
    
    public void injectData(IData dataLayer){
        data = dataLayer;
    }
    
    public boolean isProfileInDB(String name,String password){
        return data.isInProfileDB(name, password);
    }
    
    public int getUsertype(){
        return data.getUsertype();
    }
    
    public String getUsername(){
        return data.getUsername();
    }
    
    public String getPassword(){
        return data.getPassword();
    }
    
    public List<String> getUserList(){
        return data.getUserlist();
    }
    
    public void createNewUser(String username,String password,int usertype){
        data.createNewUser(username, password, usertype);
    }
    
    public void deleteUser(String name,String password){
        data.deleteUser(name, password);
    }
    
    public void creataNewCase(String cpr,String textInput){
        data.createNewCase(cpr, textInput);
    }
    
    public List<String> getCaseList(){
        return data.getCaseList();
    }
    
    public boolean isCaseInDB(String id){
        return data.isCaseInDb(id);
    }
    
    public String getCaseTextInput(){
        return data.getCaseTextinput();
    }
    
    public String getCaseCPR(){
        return data.getCaseCPR();
    }
    
    public String getTime(){
        return data.getTime();
    }
    
    public String getCaseID(){
        return data.getCaseID();
    }

    @Override
    public int getUserType() {
        return data.getUsertype();
    }
    public List<String> getSpecificCaseList(String list){
        return data.getSpecificCaseList(list);
    }
}
