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
public interface Icases {

    
    public List<String> getCaseList();
    public boolean isCaseInDb(String id);
    public String getCaseTextinput();
    public String getCaseCPR();
    public String getTime();
    public String getCaseID();
    public List<String> getSpecificCaseList(String CPR);
    public int howManyCasesInDB();
    public void createCaseNEW(String text, String title);
    public void deleteFromCases(String ID);
    public void deleteFromPercas(String ID);
    public boolean isIDInDB(String ID);
    public void deleteCase(String ID);
    public String getTitle();
    public void evaluateCase(String text1, String text2, String text3);
    public String getDescription();
    public String getEffortNeeded();
    public String getEvaluation();
    public void CreateCaseInPercasAndCases(String cpr, String textinput,String title);
    public boolean ChecIfCprExists(String CPR);
    public void insertInToPercas(String cpr);
}
