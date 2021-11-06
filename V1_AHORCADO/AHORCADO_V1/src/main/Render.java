/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;

/**
 *
 * @author kaliw
 */
public class Render {
    
    
    private App app;
    
    public Render(App ap){
        
        this.app=ap;
        
    }
    
        public void render(Graphics g){
        
        switch(StatesApp.gameState){
            case MENU:
               // app.getMenu().render(g);
                break;
            case PLAYIN:
                app.getPlaying().render(g);
                break;
            case SETTINGS:
                //app.getSetts().render(g);
                break;
            
        }
    }
    
}
