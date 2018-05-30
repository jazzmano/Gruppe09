/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
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
    
    public void createNewUser(String username,String password,int usertype,String cpr,String address,String number,String name){
        data.createNewUser(username, password, usertype,cpr,address,number,name);
    }
    
    public void deleteUser(String name,String password){
        data.deleteUser(name, password);
    }
    
//    public void creataNewCase(String cpr,String textInput){
//        data.createNewCase(cpr, textInput);
//    }
    
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
     public String getCpr(){
        return data.getCpr();
    }
    public String getAddress(){
        return data.getAddress();
    }
    
    public String getNumber(){
        return data.getNumber();
    }
    
    public String getName(){
        return data.getName();
    }

    @Override
    public int howManyCasesInDB() {
        return data.howManyCasesInDB();
    }

    @Override
    public void createCaseNEW(String text,String title) {
        data.createCaseNEW(text,title);
    }

    @Override
    public void deleteFromCases(String ID) {
        data.deleteFromCases(ID);
    }

    @Override
    public void deleteFromPercas(String ID) {
        data.deleteFromPercas(ID);
    }

    @Override
    public boolean isIDInDB(String ID) {
        return data.isIDInDB(ID);
    }

    @Override
    public void deleteCase(String ID) {
        data.deleteCase(ID);
    }

    @Override
    public String getTitle() {
        return data.getTitle();
    }

    @Override
    public List<String> citizenCaseList() {
        return data.citizenCaseList();
    }

    @Override
    public void evaluateCase(String text1, String text2, String text3) {
        data.evaluateCase(text1, text2, text3);
    }

    @Override
    public String getDescription() {
        return data.getDescription();
    }

    @Override
    public String getEffortNeeded() {
        return data.getEffortNeeded();
    }

    @Override
    public String getEvaluation() {
        return data.getEvaluation();
    }
     @Override
    public void CreateCaseInPercasAndCases(String cpr, String textinput,String title) {
        data.CreateCaseInPercasAndCases(cpr, textinput,title);
    }

    @Override
    public boolean ChecIfCprExists(String CPR) {
        return data.ChecIfCprExists(CPR);
    }

    @Override
    public void insertInToPercas(String cpr) {
        data.insertInToPercas(cpr);
    }
   
}
