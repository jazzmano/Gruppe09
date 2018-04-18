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
public class BigJava implements Runnable{
    
    private String greeting;
    private int delay = 1000;
    private int repetion =10;
    
    public BigJava(String greeting){
        this.greeting = greeting;
    }

    @Override
    public void run() {
        try{
            for(int i = 1;i<=repetion;i++){
                Date now = new Date();
                System.out.println(now+" "+greeting);
                Thread.sleep(delay);
            }
        }
        catch(InterruptedException exeption){
            System.out.println(exeption);
        }
    }

    
}
