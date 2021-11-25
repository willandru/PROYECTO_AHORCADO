/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import baseDatos.Categoria;
import baseDatos.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import main.StatesApp;
import static main.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class Settings extends JPanel implements ActionListener{
     private JButton btnGoMenu, btnUploadFile, btnMusic, btnDefaults;
     private  JFileChooser fileOpener = new JFileChooser(); 
     

     
     public Settings(){
         
         System.err.println("CONSTRUCTOR: SETTINGS");
         setLayout(null);
         inicializarBotones();
         agregarBotones();
         setVisible(true);
     }


    @Override
    public void actionPerformed(ActionEvent ae) {

        Object origen = ae.getSource();
        if(origen == this.btnUploadFile){
            
            StatesApp.fileState=CUSTOM_FILE;
            System.out.println("UPDATED");
          
 
            
            
        }else if(origen == this.btnGoMenu){
            System.out.println("GOMENUGOEMUUUGOGGOGO");
            //StatesApp.gameState=MENU;
           StatesApp.gameState=MENU;
        }else if(origen == this.btnDefaults){
            System.out.println("SET DEFAULTS");
            //StatesApp.gameState=MENU;
           StatesApp.fileState=DEFAULT_FILE;
        }
    }
  
    
    
    

        
  
   
    
    
    
    
   
   
   
    
    private void inicializarBotones() {
        btnGoMenu= new JButton("Back");
        btnGoMenu.setBounds(120,450,150,70);
        btnGoMenu.addActionListener(this);
        
        btnUploadFile = new JButton("UPLOAD FILE");
        btnUploadFile.setBounds(120,150,150,60);
        btnUploadFile.addActionListener(this);
        
        btnMusic = new JButton("MUSIC");
        btnMusic.setBounds(120,300,150,70);
        btnMusic.addActionListener(this);
        
        btnDefaults= new JButton("Set Defaults");
        btnDefaults.setBounds(120,230,150,40);
        btnDefaults.addActionListener(this);
   
    }

    private void agregarBotones() {
        this.add(btnGoMenu);
        this.add(btnUploadFile);
        this.add(btnMusic);
        this.add(btnDefaults);
    }
    
}
