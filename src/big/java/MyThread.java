/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big.java;

import java.util.Date;

/**
 *
 * @author nicol
 */
public class MyThread extends Thread{

    private String ding;
    
    public MyThread(String ding){
        this.ding = ding;
    }
    
    public void run(){
        try{
            for(int i = 1;i<10;i++){
                Date now = new Date();
                System.out.println(now+" "+ding);
                Thread.sleep(1000);
            }
        }catch(InterruptedException exception){
            System.out.println(exception);
        }
        int b = 0;
    }
}       
    
    

