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
public class MyRunnable implements Runnable{
    private int a;
    private String b;
    
    public MyRunnable(int a,String b){
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
      try{
          
          Test t = new Test(a,b);
          while(true){
          t.ding();
          t.doStuff();
              System.out.println(t.getString());
              System.out.println(t.getTal());
                Thread.sleep(1000);
          }
      }
      catch(InterruptedException exception){
          System.out.println(exception);
          
      }
      
    }
    
}
