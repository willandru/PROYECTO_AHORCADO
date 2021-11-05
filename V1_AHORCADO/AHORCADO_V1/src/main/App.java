/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import splashscreen.SplashScreen;

/**
 *
 * @author kaliw
 */
public class App {
    
     static UI ui;
     static SplashScreen ss;

    private static void iniciarSplashScreen() {
        Runner run = new Runner();
        Thread thread1 = new Thread(run);
        thread1.start();
    }
     

    public static void main(String[] args) {
        
        ss.getInstance();
        ui.getInstance();
        iniciarSplashScreen();
        
        System.out.println("End main");
    }
}
