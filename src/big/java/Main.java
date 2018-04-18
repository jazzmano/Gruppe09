/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package big.java;

import java.util.Scanner;

/**
 *
 * @author nicol
 */
public class Main {
    public static void main(String[] args) {
//
//        Runnable r = new BigJava("nigger fagot");
//        Thread t = new Thread(r);
//        t.start();
//
//        Runnable a = new BigJava("ding");
//        Thread d = new Thread(a);
//        d.start();
          
//           MyThread a = new MyThread("sdinsidn");
//           a.start();
//           MyThread d = new MyThread("dnsolidnspo");
//           d.start();


            Thread t = new Thread(new MyRunnable(1,"ding"));
           
            Thread s = new Thread(new MyRunnable(2,"lort"));
            Scanner reader = new Scanner(System.in);
            System.out.println("oisdnhfoønsdoifnsdoifnswnføoisdnf");
            int a = 22;
            while(true){
                String a = reader.nextLine();
                if(a.equalsIgnoreCase("a")){
                   s.start();
                }else if(a.equalsIgnoreCase("b")){
                     t.start();
                }else if(a.equalsIgnoreCase("c")){
                    t.interrupt(); 
                    s.interrupt(); 
                    break;
                }
            }

    }
}
