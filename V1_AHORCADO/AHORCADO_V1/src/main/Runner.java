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
public class Runner implements Runnable{

    @Override
    public void run() {
        
        new SplashScreen();
        int x=0;
        String cad= ".";
        
        try {
                     while(x<=100){
                         //barraDeProgreso.setValue(x);
                         //porcentaje.setText(x+"%");
                         //porcentaje2.setText(cad+x+"%");
                         x+=2;
                         cad+=".";
                         Thread.sleep(100);
                     }
                 } catch (Exception e) {
                     System.out.println("Exception "+ e.getMessage());
                 }
    }
    
}
