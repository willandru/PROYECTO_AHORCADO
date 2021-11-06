/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.StatesApp;
import static main.StatesApp.*;


/**
 *
 * @author kaliw
 */
public class Menu extends JPanel implements ActionListener{
    
    private BufferedImage imgbtn1;
    private BufferedImage rojoT;
    private BufferedImage verT;
    private BufferedImage negT;

     private JButton btnPlay, btnSetts, btnQuit;
    
    public Menu(){
       
       
        setLayout(null);
        setBackground(new Color(0x137756));
        importImages();
        initButtons();
        addButtons();
        setVisible(true);
        
    }

     
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object origen = ae.getSource();
         if(origen == this.btnPlay){
           StatesApp.gameState=PLAYIN;
            
        } else if(origen == this.btnSetts){
            StatesApp.gameState=SETTINGS;
            
        }else if(origen == this.btnQuit){
            System.exit(0);
        }
        
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
        btnPlay.setBounds(130,300,124,40);
        
        btnSetts=new JButton();
        btnSetts.setBounds(130,390,124,40);
        
        btnQuit=new JButton("QUIT");
        btnQuit.setBounds(130,480,124,40);
          btnPlay.addActionListener(this);
         btnSetts.addActionListener(this);
          btnQuit.addActionListener(this);
    }

    private void addButtons() {
        this.add(btnPlay);
        this.add(btnSetts);
        this.add(btnQuit);

    }

    
    
    
    
    
    
    
    
   
    
}
