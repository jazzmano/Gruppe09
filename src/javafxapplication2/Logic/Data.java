package javafxapplication2.Logic;


import acquaintance.IData;
import java.util.List;
import javafxapplication2.Logic.cases;
import javafxapplication2.Logic.persons;


public class Data implements IData{
    
    cases cas = new cases();
    persons per = new persons();

    @Override
    public boolean isInProfileDB(String name, String password) {
       return  per.isInProfileDB(name, password);
    }

    @Override
    public int getUsertype() {
        return per.getUsertype();
    }

    @Override
    public String getUsername() {
        return per.getUsername();
    }

    @Override
    public String getPassword() {
        return per.getPassword();
    }

    @Override
    public List<String> getUserlist() {
        return per.getUserlist();
    }

    @Override
    public void createNewUser(String username, String password, int usertype, String cpr, String address, String number, String name) {
        per.createNewUser(username, password, usertype, cpr, address, number, name);
    }

    @Override
    public void deleteUser(String name, String password) {
        per.deleteUser(name, password);
    }

    @Override
    public List<String> getCaseList() {
        return cas.getCaseList();
    }

    @Override
    public boolean isCaseInDb(String id) {
        return cas.isCaseInDb(id);
    }

    @Override
    public String getCaseTextinput() {
        return cas.getCaseTextinput();
    }

    @Override
    public String getCaseCPR() {
        return cas.getCaseCPR();
    }

    @Override
    public String getTime() {
        return cas.getTime();
    }

    @Override
    public String getCaseID() {
        return cas.getCaseID();
    }

    @Override
    public List<String> getSpecificCaseList(String CPR) {
        return cas.getSpecificCaseList(CPR);
    }

    @Override
    public String getCpr() {
        return per.getCpr();
    }

    @Override
    public String getAddress() {
        return per.getAddress();
    }

    @Override
    public String getNumber() {
        return per.getNumber();
    }

    @Override
    public String getName() {
        return per.getName();
    }

    @Override
    public int howManyCasesInDB() {
        return cas.howManyCasesInDB();
    }

    @Override
    public void createCaseNEW(String text,String title) {
        cas.createCaseNEW(text,title);
    }

    @Override
    public void deleteFromCases(String ID) {
        cas.deleteFromCases(ID);
    }

    @Override
    public void deleteFromPercas(String ID) {
        cas.deleteFromPercas(ID);
    }

    @Override
    public boolean isIDInDB(String ID) {
       return cas.isIDInDB(ID);
    }

    @Override
    public void deleteCase(String ID) {
        cas.deleteCase(ID);
    }

    @Override
    public String getTitle() {
        return cas.getTitle();
    }

    @Override
    public List<String> citizenCaseList() {
        return per.citizenCaseList();
    }

    @Override
    public void evaluateCase(String text1, String text2, String text3) {
        cas.evaluateCase(text1, text2, text3);
    }

    @Override
    public String getDescription() {
        return cas.getDescription();
    }

    @Override
    public String getEffortNeeded() {
        return cas.getEffortNeeded();
    }

    @Override
    public String getEvaluation() {
        return cas.getEvaluation();
    }

    @Override
    public void CreateCaseInPercasAndCases(String cpr, String textinput,String title) {
        cas.CreateCaseInPercasAndCases(cpr, textinput,title);
    }

    @Override
    public boolean ChecIfCprExists(String CPR) {
        return cas.ChecIfCprExists(CPR);
    }

    @Override
    public void insertInToPercas(String cpr) {
        cas.insertInToPercas(cpr);
    }

    
    
    
}