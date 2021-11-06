/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import javax.swing.JFrame;
import screens.Menu;

/**
 *
 * @author kaliw
 */
public class UI extends JFrame{
    private static UI instance;
    private static final int WIDTH_SCREEN = 400;
    private static final int HEIGHT_SCREEN = 700;
    private Menu menu=new Menu();
    
    public UI(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        add(menu);
        
        
        setVisible(true);
    }

    public static UI getInstance() {
        
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }
    
    
}
