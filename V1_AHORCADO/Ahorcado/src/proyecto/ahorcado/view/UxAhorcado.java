/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ahorcado.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kaliw
 */



public class UxAhorcado {
    
     private static UxAhorcado instance;
    private static final int WIDTH_SCREEN = 400;
    private static final int HEIGTH_SCREEN = 600;
   
    
    JFrame frame;
    JLabel imageStart;
    
    
    public UxAhorcado() {
        // Creando ventana
        frame = new JFrame("Ahorcado V1");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(WIDTH_SCREEN, HEIGTH_SCREEN);
        frame.setResizable(false);

     



        frame.setVisible(true);

    }
    
    
    public static UxAhorcado getInstance() {
        if (instance == null) {
            instance = new UxAhorcado();
        }
        return instance;
    }
    
}
