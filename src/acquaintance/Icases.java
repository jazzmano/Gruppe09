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
public interface Icases {

    
    public List<String> getCaseList();
    public boolean isCaseInDb(String id);
    public String getCaseTextinput();
    public String getCaseCPR();
    public String getTime();
    public String getCaseID();
    public List<String> getSpecificCaseList(String CPR);
    public boolean Test(String CPR);
    public void test2OpretTing(String cpr, String textinput);
    public int howManyCasesInDB();
    public void createCaseNEW(String text);
    public void virknu(String cpr);
    public void deleteFromCases(String ID);
    public void deleteFromPercas(String ID);
    public boolean isIDInDB(String ID);
    public void deleteCase(String ID);
}
