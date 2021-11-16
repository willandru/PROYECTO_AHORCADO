/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kaliw
 */
public class Settings extends JPanel{
     private JButton btnGoMenu, btnUploadFile, btnMusic;
     
     public Settings(){
          setLayout(null);
         inicializarBotones();
         agregarBotones();
         setVisible(true);
     }

    private void inicializarBotones() {
        btnGoMenu= new JButton("Back");
        btnGoMenu.setBounds(70,310,250,70);
        
        btnUploadFile = new JButton("UPLOAD FILE");
        btnUploadFile.setBounds(70,310,250,70);
        
        btnMusic = new JButton("MUSIC");
        btnMusic.setBounds(70,310,250,70);
   
    }

    private void agregarBotones() {
        this.add(btnGoMenu);
        this.add(btnUploadFile);
        this.add(btnMusic);
    }
    
}
