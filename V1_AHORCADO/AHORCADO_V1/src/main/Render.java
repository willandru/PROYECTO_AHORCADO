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
    
    public Render(){
        
    }
    
        public void render(Graphics g){
        
        switch(StatesApp.gameState){
            case MENU:
                StatesApp.getMenu().render(g);
                break;
            case PLAYIN:
                renderGame.getPlaying().render(g);
                break;
            case SETTINGS:
                renderGame.getSetts().render(g);
                break;
            
        }
    }
    
}
