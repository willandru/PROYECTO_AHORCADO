/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import screens.Menu;
import screens.Playing;
import screens.Settings;
import splashscreen.SplashScreen;

/**
 *
 * @author kaliw
 */
public class App {
    
     static UI ui;
     static SplashScreen ss;
     
    private Menu menu;
    private Playing playing;
    private Settings setts;

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public void setPlaying(Playing playing) {
        this.playing = playing;
    }

    public Settings getSetts() {
        return setts;
    }

    public void setSetts(Settings setts) {
        this.setts = setts;
    }
    
    
    
    
}
