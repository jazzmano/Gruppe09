/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafxapplication2.Logic.characterCheck;
import javafxapplication2.Logic.logicLogin;

/**
 *
 * @author nicol
 */
public class NewClass {
    public static void main(String[] args) {
        characterCheck a = new characterCheck();
        String b = "nicolai  ";
        System.out.println(b.length());
        a.trimForSpacePassword(b);
        System.out.println(b.length());
    }
}
