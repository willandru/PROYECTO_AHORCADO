/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     
     public Settings(){
         setLayout(null);
         inicializarBotones();
         agregarBotones();
         setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent ae) {

        Object origen = ae.getSource();
        if(origen == this.btnUploadFile){
            
            JFileChooser fileOpener = new JFileChooser();
            fileOpener.setCurrentDirectory(new File("./src/resources"));
            
            int ans = fileOpener.showOpenDialog(null);
            
            if(ans== JFileChooser.APPROVE_OPTION){
                try {
                    File dataFile = new File(fileOpener.getSelectedFile().getAbsolutePath());
                    System.out.println(dataFile);
                    
                    Scanner myReader = new Scanner(dataFile);
                    
                    boolean isCategory=false;
                    int numCategories=0;
                    
                    while (myReader.hasNextLine()) {
                        
                        System.out.println("scenes.Settings.actionPerformed()");
                        
                        String data = myReader.nextLine();
                        System.out.println();
                        if(!data.isBlank()){
                         isCategory= isUpper(data);
                        }
                        if(isCategory){
                            numCategories++;
                           System.out.println(data);
                              
                        }
                        
                       
                        
                        
                    }
                     System.out.println(numCategories);
                    myReader.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
}
            
            
            
        }else if(origen == this.btnGoMenu){
            System.out.println("GOMENUGOEMUUUGOGGOGO");
            //StatesApp.gameState=MENU;
            
           StatesApp.gameState=MENU;
        }
    }
    
    
   public boolean isUpper(String line){
       
      
       
       
       for(int i=0; i< line.length(); i++){
           
           if(!line.isBlank()){
                 if(Character.isLowerCase(line.charAt(i) )){
               return false;
           }
           }
           
         
           
       }
       return true;
       
   }
    
    
    
    
    
}
