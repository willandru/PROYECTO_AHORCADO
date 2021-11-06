/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import main.App;
import main.UI;

/**
 *
 * @author kaliw
 */
public class Menu extends UI implements ScreenMethods{
    
    private BufferedImage imgbtn1;
    private BufferedImage rojoT;
    private BufferedImage verT;
    private BufferedImage negT;

     private JButton btnPlay, btnSetts, btnQuit;
    
    public Menu(){
        super();
        getContentPane().setBackground(Color.green);
        importImages();
        initButtons();
        addButtons();
    }

    
    

                @Override
                public void render(Graphics g) {
                }

                @Override
                public void mouseClick(int x, int y) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseMov(int x, int y) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mousePress(int x, int y) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void mouseReleas(int x, int y) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }


    
    
    private void importImages() {
    InputStream is1 = getClass().getResourceAsStream("/images/btn1.png");
    InputStream is2 = getClass().getResourceAsStream("/images/rojT.png");
    InputStream is3 = getClass().getResourceAsStream("/images/verT.png");
    InputStream is4 = getClass().getResourceAsStream("/images/negT.png");
        try {
            imgbtn1 = ImageIO.read(is1);
            rojoT = ImageIO.read(is2);
            verT= ImageIO.read(is3);
            negT= ImageIO.read(is4);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
 
        
    }

    private void initButtons() {
        
        btnPlay = new JButton();
        btnPlay.setBounds(100,300,124,40);
        
        btnSetts=new JButton();
        btnSetts.setBounds(100,370,124,40);
        
        btnQuit=new JButton("QUIT");
        btnQuit.setBounds(100,440,124,40);
    }

    private void addButtons() {
        this.add(btnPlay);
        this.add(btnSetts);
        this.add(btnQuit);

    }
    
}
