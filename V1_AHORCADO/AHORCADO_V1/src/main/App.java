/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;
import splashscreen.SplashScreen;

/**
 *
 * @author kaliw
 */
public class App {
    

     static SplashScreen ss;


    public static void main(String[] args) {
        
        ss.getInstance();

       
        
        System.out.println("End main");
    }
}
