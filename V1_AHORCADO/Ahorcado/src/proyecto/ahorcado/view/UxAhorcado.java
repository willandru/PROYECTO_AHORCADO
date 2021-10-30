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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH_SCREEN, HEIGTH_SCREEN);
        frame.setResizable(true);

        imageStart = new JLabel();
        imageStart.setVerticalAlignment(JLabel.CENTER);
       

        imageStart.setOpaque(true);
        imageStart.setForeground(new Color(120, 90, 40));
       // imageStart.setBackground(new Color(10, 70, 20));
        this.addImagePanel("https://cdn.pling.com/img/4/5/8/1/c7d4bcbeac5f159189b860afb4bb9c7b92358a550db93e2a4cec03912b54001a6ddb.gif");


        frame.add(imageStart);
        frame.setVisible(true);

    }
    
    
    public static UxAhorcado getInstance() {
        if (instance == null) {
            instance = new UxAhorcado();
        }
        return instance;
    }
    
    public void addImagePanel(String path) {
        Image image = null;
        try {
            URL url = new URL(path);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image newimg = image.getScaledInstance(WIDTH_SCREEN , HEIGTH_SCREEN/2 , java.awt.Image.SCALE_SMOOTH);
        imageStart.setIcon(new ImageIcon(newimg));
        
    }
    
}
