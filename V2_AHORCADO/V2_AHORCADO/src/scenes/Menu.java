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

import main.StatesApp;
import static main.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class Menu extends JPanel implements ActionListener{
    
  

     private JButton btnClasssic, btnSetts, btnQuit, btnHistory, btnStore;
     private int numero;
     private JPanel imagePan;
     
     private static final int ANCHO=400;
    private static final int ALTO=680;
    
    public Menu(){
        setLayout(null);
        setBackground(new Color(0x134756));
        initButtons();
        addButtons();
       
    
        setVisible(true);
        
    }

    
    

 
    public int  getNumero(){
        return numero;
    }
    


    private void initButtons() {

        btnClasssic = new JButton("CLASSIC");
        btnClasssic.setBounds(70,130,250,70);
        
        btnHistory=new JButton("HISTORY");
        btnHistory.setBounds(70,220,250,70);
        
        btnStore=new JButton("TIENDA");
        btnStore.setBounds(70,310,250,70);
        
        btnSetts=new JButton("SETTINGS");
        btnSetts.setBounds(70,400,250,70);
        
        btnQuit=new JButton("QUIT");
        btnQuit.setBounds(150,490,100,70);
        
       

        btnClasssic.addActionListener(this);
        btnSetts.addActionListener(this);
        btnQuit.addActionListener(this);
        btnHistory.addActionListener(this);
        btnStore.addActionListener(this);
    }

    private void addButtons() {
        this.add(btnClasssic);
        this.add(btnSetts);
        this.add(btnQuit);
        this.add(btnHistory);
        this.add(btnStore);
        

    }

    
    
    
    
    
    
    
    
    
     
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object origen = ae.getSource();
         if(origen == this.btnClasssic){
             numero=1;
           StatesApp.gameState=PLAYING;
           System.out.println("actiion PLAYING");
            
        } else if(origen == this.btnSetts){
            numero=2;
            StatesApp.gameState=SETTINGS;
            System.out.println("actiion SETTINGS");
            System.out.println("state: "+ StatesApp.gameState);

            
        }else if(origen == this.btnQuit){
            System.exit(0);
        }
        
    }
   
    
}
