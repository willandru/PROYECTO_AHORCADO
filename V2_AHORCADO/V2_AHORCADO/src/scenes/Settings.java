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
            
           
            fileOpener.setCurrentDirectory(new File("./src/resources"));
            int ans = fileOpener.showOpenDialog(null);
            readFile(ans);
            
            
            
            
        }else if(origen == this.btnGoMenu){
            System.out.println("GOMENUGOEMUUUGOGGOGO");
            //StatesApp.gameState=MENU;
            
           StatesApp.gameState=MENU;
        }
    }
    
    public void readFile(int ans){
        if(ans== JFileChooser.APPROVE_OPTION){
                try {
                    File dataFile = new File(fileOpener.getSelectedFile().getAbsolutePath());
                    System.out.println(dataFile);
                    
                    Scanner myReader = new Scanner(dataFile);
                    
                    boolean validLine;
                    boolean isCategory=false;
                    boolean isWord=false;
                    
                    int numCategories=0;
                    Vector <Integer> vecNumWords = new Vector<>();
                    Vector <String> vecWords = new Vector<>();
                    
                    
                    while (myReader.hasNextLine()) {
                       String data = myReader.nextLine();
                       
                       validLine= Pattern.matches("[a-zA-Z ]+", data);
                        
 
                            if(validLine){
                                
                                if(Pattern.matches("[A-Z ]+", data)){
                                    numCategories++;
                                    System.out.println("Categoria "+ numCategories + " ; "+ data);
                                }
                                else{
                                    System.out.println("Palabra:  "+ data);  
                                }               
                            }                   
                    }
                  System.out.println(numCategories);
                  myReader.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
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
