/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author kaliw
 */
public enum StatesApp {
     PLAYIN,    MENU,    SETTINGS, QUIT;
    public static StatesApp gameState = MENU;
    
    public static void SetStatesApp(StatesApp state){
        gameState= state;
    }
}
