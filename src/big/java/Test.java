/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big.java;

/**
 *
 * @author nicol
 */
public class Test {
    
    private int tal;
    private String ting;
    
    public Test(int tal, String ting){
        this.tal = tal;
        this.ting = ting;
    }
    
    public int getTal(){
        return this.tal;
    }
    
    public String getString(){
        return this.ting;
    }
    
    public void doStuff(){
        tal++;
    }
    public void ding(){
        ting = ting+ting;
    }
}
