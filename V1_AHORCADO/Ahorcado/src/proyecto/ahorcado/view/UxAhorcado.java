/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.ahorcado.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto.ahorcado.engine.StartImage;

/**
 *
 * @author kaliw
 */



public class UxAhorcado extends JFrame {
    
     private static UxAhorcado instance;
    private static final int WIDTH_SCREEN = 400;
    private static final int HEIGTH_SCREEN = 600;
   
    
    JFrame frame;
    JPanel imageStart;
   
    
    public UxAhorcado() {
        // Creando ventana
        super("Ahorcado");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH_SCREEN, HEIGTH_SCREEN);
        this.setResizable(true);

        imageStart = new StartImage(this);
        this.add(imageStart);
        this.add(imageStart);
        
        this.setVisible(true);

    }
    
    
    public static UxAhorcado getInstance() {
        if (instance == null) {
            instance = new UxAhorcado();
        }
        return instance;
    }
     public void refreshUX() {
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
   
    
}
