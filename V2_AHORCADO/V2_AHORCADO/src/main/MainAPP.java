/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import baseDatos.Datos;
import devices.Music;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.SwingUtilities;

/**
 *
 * @author kaliw
 */
public class MainAPP {
    //****VARIABLES****
    static SplashScreen instance1;
    static Music instance2;
    static Datos instance3;
    //UX uxInstance;
    
    //****MAIN****
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {            
                    instance1= new SplashScreen();
                    //instance2= new Music();    
                    instance3= new Datos();
            }
        });
    }
    //******METHODS*****
    
}
