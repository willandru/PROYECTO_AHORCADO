/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import scenes.StatesApp;
import static scenes.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class MENU extends JPanel implements ActionListener{
    
    private BufferedImage imgbtn1;
    private BufferedImage rojoT;
    private BufferedImage verT;
    private BufferedImage negT;

     private JButton btnPlay, btnSetts, btnQuit;
    
    public MENU(){
       
       
        setLayout(null);
        setBackground(new Color(0x137756));
        initButtons();
        addButtons();
        setVisible(true);
        
    }

     
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object origen = ae.getSource();
         if(origen == this.btnPlay){
           StatesApp.gameState=PLAYIN;
           System.out.println("actiion PLAYING");
            
        } else if(origen == this.btnSetts){
            StatesApp.gameState=SETTINGS;
            System.out.println("actiion SETTINGS");
            
        }else if(origen == this.btnQuit){
            System.exit(0);
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
