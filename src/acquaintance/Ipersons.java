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
public interface Ipersons {
    
    public boolean isInProfileDB(String name, String password);
    public String getCpr();
    public String getAddress();
    public String getNumber();
    public String getName();
    public int getUsertype();
    public String getUsername();
    public String getPassword();
    public List<String> getUserlist();
    public void createNewUser(String username, String password, int usertype, String cpr, String address, String number, String name);
    public void deleteUser(String name, String password);
    public List<String> citizenCaseList();
    
}
