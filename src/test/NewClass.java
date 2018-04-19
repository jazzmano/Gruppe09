/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafxapplication2.Logic.logicLogin;

/**
 *
 * @author nicol
 */
public class NewClass {
    public static void main(String[] args) {
        logicLogin a = new logicLogin();
        a.isInProfileDB("Kristian","1234");
        System.out.println(a.getUsertype());
    }
}
