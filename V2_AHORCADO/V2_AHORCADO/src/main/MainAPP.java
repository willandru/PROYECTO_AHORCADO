/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.SwingUtilities;

/**
 *
 * @author kaliw
 */
public class MainAPP {
    //****VARIABLES****
    static UI uiInstance;
    //UX uxInstance;
    
    //****MAIN****
    public static void main(String[] args) {
        
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               uiInstance= new UI();
            }
        });
        
    }
    //******METHODS*****
    
}
