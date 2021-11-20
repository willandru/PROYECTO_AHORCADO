/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import scenes.Settings;

/**
 *
 * @author kaliw
 */
public class Datos implements Runnable{
    
    //Vector <Categoria>
     private  JFileChooser fileOpener = new JFileChooser(); 
    
     public Vector <Integer> vecNumWords;  /// WHATTT IS THIS FOOR
     public Vector <Categoria> vecCategorias ;
      private int numCategories;
     
     
     
     
    public Datos(){
        
    }
    
    
    
      
    public void readFile(){
        
          fileOpener.setCurrentDirectory(new File("./src/resources"));
            int ans = fileOpener.showOpenDialog(null);
        
        if(ans== JFileChooser.APPROVE_OPTION){
                try {
                    File dataFile = new File(fileOpener.getSelectedFile().getAbsolutePath());
                    System.out.println(dataFile);
                    
                    Scanner myReader = new Scanner(dataFile);
                    
                    boolean validLine;
                    boolean isCategory=false;
                    boolean isWord=false;
                    
                    numCategories=0;
                    int numPalabras=0;
                    vecNumWords = new Vector<>();
                    Categoria newCategory =new Categoria();
                    vecCategorias = new Vector<>();
                    
                    while (myReader.hasNextLine()) {
                       String data = myReader.nextLine();
                       
                       validLine= Pattern.matches("[a-zA-Z ]+", data);
                        
 
                            if(validLine){
                                
                                if(Pattern.matches("[A-Z ]+", data)){
                                    newCategory= new Categoria(data);
                                    numCategories++;
                                    numPalabras=0;
                                    
                                    vecCategorias.add(newCategory);
                                    System.out.println("Categoria "+ numCategories + " ; "+ data);
                                }
                                else{
                                    numPalabras++;
                                    newCategory.addPalabra(data); //****CUIDADO            CUIDADOO
                                                   
                                }               
                            }               
                    }
                    System.out.println(vecCategorias);
                  System.out.println(numCategories);
                  myReader.close();
                  
                                     vecCategorias.get(0).printWords();
                   vecCategorias.get(1).printWords();
                                      vecCategorias.get(2).printWords();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }
}
    }
    
    
    
    
    public String randomWord(){
        String palabraRandom;
        Categoria catRandom;
        int categoriaRandom = (int) (Math.random()*numCategories-1+0);
        
        catRandom= vecCategorias.get(categoriaRandom);
        int numPalabras = catRandom.getNumPalabras();
        
        int numPalabraRandom = (int) (Math.random()*numPalabras-1+0);
        
        palabraRandom= catRandom.getPalabra(numPalabraRandom);
        
        return palabraRandom;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
