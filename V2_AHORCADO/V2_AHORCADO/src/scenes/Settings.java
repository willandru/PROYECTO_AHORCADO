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
     private JButton btnGoMenu, btnUploadFile, btnMusic;
     private  JFileChooser fileOpener = new JFileChooser(); 
     private Datos DATOSTEXTO = new Datos();
     
     
     
     public Settings(){
         setLayout(null);
         inicializarBotones();
         agregarBotones();
         setVisible(true);
     }


    @Override
    public void actionPerformed(ActionEvent ae) {

        Object origen = ae.getSource();
        if(origen == this.btnUploadFile){
            
            DATOSTEXTO.readFile();
            
            
            
            
        }else if(origen == this.btnGoMenu){
            System.out.println("GOMENUGOEMUUUGOGGOGO");
            //StatesApp.gameState=MENU;
            
           StatesApp.gameState=MENU;
        }
    }
  
    
    
    

        
  
   
    
    
    
    
   
   
   
    
    private void inicializarBotones() {
        btnGoMenu= new JButton("Back");
        btnGoMenu.setBounds(120,450,150,70);
        btnGoMenu.addActionListener(this);
        
        btnUploadFile = new JButton("UPLOAD FILE");
        btnUploadFile.setBounds(120,150,150,70);
        btnUploadFile.addActionListener(this);
        
        btnMusic = new JButton("MUSIC");
        btnMusic.setBounds(120,300,150,70);
        btnMusic.addActionListener(this);
   
    }

    private void agregarBotones() {
        this.add(btnGoMenu);
        this.add(btnUploadFile);
        this.add(btnMusic);
    }
    
}
