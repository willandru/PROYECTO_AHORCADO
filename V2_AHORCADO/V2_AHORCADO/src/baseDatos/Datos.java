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

import main.StatesApp;
import static main.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class Datos implements Runnable{
    
    //Vector <Categoria>
     private  JFileChooser fileOpener; 
    
     public Vector <Categoria> vecCategoriasCUSTOM;
     
      public Vector <Categoria> vecCategoriasDEFAULTS;
      
      public Vector <Integer> vecNumPalabras;
      public int numCategories;
      public  int numPalabras=0;
      public  int numTotPalabras=0;
      
      
      
      private Thread threadDATA=null; 
      private File defaultWords;
      
      public  boolean customLOADED= false;
      public boolean defaultsLOADED=false;
   
     static Datos instance;
     
     
      public Datos(){
          threadDATA = new Thread(this);
        
          vecCategoriasDEFAULTS = null;
          
          
           System.err.println("->CONSTRUCTOR: Base de DATOS");
         
          
        
               threadDATA.start();
          
          System.out.println("Vector categorias DEFAULTS: " +vecCategoriasDEFAULTS);
           
        
         
        
    }

    public static Datos getInstance() {
        
        if (instance == null) {
            instance = new Datos();
        }
        return instance;
    }
 
   public Vector<Categoria> loadDefaults(Vector<Categoria> catDef){
       try{
       defaultWords= new File("./src/resources/defaultsWords.txt");
       
        System.out.println("PATH FILE DEFAULTS: " + defaultWords);
        
           catDef=saveFileContent(catDef, defaultWords);
           
           
          
       }catch(Exception e){
           
       }
       
       return catDef;
   }

    public Vector<Categoria> saveFileContent(Vector<Categoria> cats, File file){
        System.out.println("saveFileContent () BASE DE DATOS,...LEYENDO Y GUARDANDO DATOS . . .");
        
        
        if (cats == null){
            try { 
            
            Scanner myReader = new Scanner(file);
                 
                    boolean validLine;
                    boolean isCategory=false;
                    boolean isWord=false;
                    
                    numCategories=0;
                    numPalabras=0;
                    numTotPalabras=0;
                   
                    Categoria newCategory =new Categoria();
                    cats = new Vector<>();
                    
                    while (myReader.hasNextLine()) {
                       String data = myReader.nextLine();
                       
                       validLine= Pattern.matches("[a-zA-Z ]+", data);
                        
 
                            if(validLine){
                                
                                if(Pattern.matches("[A-Z ]+", data)){
                                    newCategory= new Categoria(data);
                                    numCategories++;
                                    numPalabras=0;
                                    
                                    cats.add(newCategory);
                                    System.out.println("CATEGORIAS LEIDAS "+ numCategories + " ; "+ data);
                                    System.out.println("Numero de Palabras Categoria: "+ numPalabras);
                                }
                                else{
                                    numPalabras++;
                                    numTotPalabras++;
                                    System.out.println("Palabras Encontradas: "+ numPalabras);
                                    newCategory.addPalabra(data.toUpperCase()); //****CUIDADO            CUIDADOO                 
                                }               
                            }               
                    }
                      myReader.close();
                      
                      System.out.println("NUEMRO DE CATEGORIAS LEIDAS: "+ numCategories);
                      System.out.println("Numero PALABRAS en TOTAL: "+ numTotPalabras);
              } catch (FileNotFoundException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }        
        }
        
        return cats;
    }
    
    public void sendFileChoosener(){
       
        fileOpener = new JFileChooser();
        
          fileOpener.setCurrentDirectory(new File("./src/resources"));
            int ans = fileOpener.showOpenDialog(null);
        
        if(ans== JFileChooser.APPROVE_OPTION){
                  vecCategoriasCUSTOM = null ;
            File dataFile = new File(fileOpener.getSelectedFile().getAbsolutePath());
          vecCategoriasCUSTOM=saveFileContent(vecCategoriasCUSTOM, dataFile);
                    
          customLOADED= true;          
          
          StatesApp.fileState= WAIT;
          
                    System.out.println("CUSTOM FILE : LOADED");
                  System.out.println("CATEGORIAS: " + numCategories);
                  System.out.println("PALABRAS TOTALES: "+ numTotPalabras);
                
                 for (int i=0; i<numCategories; i++){
                     vecCategoriasCUSTOM.get(i).printWords();
                 }
                               
     StatesApp.fileState= WAIT;     
         
}
        else{
         StatesApp.fileState= WAIT;     
        //StatesApp.fileState= DEFAULT_FILE; 
        vecCategoriasCUSTOM=vecCategoriasDEFAULTS;
        customLOADED=true;
        }
    }
      
    @Override
    public void run() {
        System.out.println("HILO BASE DATOS: inica");
        while(threadDATA !=null){
            try{
               // Thread.sleep(600);
                System.out.println("HILO BASE DATOS: while loop BEGINS");
                System.out.println("FILE_STATE: " + StatesApp.fileState);
                
                
                switch(StatesApp.fileState){
                    
                   case CUSTOM_FILE:
                           if(!customLOADED){
                               sendFileChoosener();
                            }
                       break;
               
                   case DEFAULT_FILE:
                       if(!defaultsLOADED){
                           
                           vecCategoriasDEFAULTS=loadDefaults(vecCategoriasDEFAULTS);
                           defaultsLOADED= true;
                           
                            System.out.println("..DEFAULTS LOADED..");
                            System.out.println("CATEGORIAS: "+numCategories);
                            System.out.println("PALABRAS TOTALES: "+ numTotPalabras);
                
                           
                                for (int i=0; i<numCategories; i++){
                         vecCategoriasDEFAULTS.get(i).printWords();
                                  }
                                                                                          
                       }
                       //System.out.println("Default DATA loaded)");
                       
                       break;
                       
                   case WAIT:
                       
                       customLOADED=false;
                       
                       if(!defaultsLOADED){
                           vecCategoriasDEFAULTS=loadDefaults(vecCategoriasDEFAULTS);
                           defaultsLOADED= true;
                            System.out.println("baseDatos.Datos.run()::: DEFAULTS LOADED" + 3);
                       }
                       System.out.println("waiting...");
                       
                       break;
               }
               
                
            }catch (Exception e){
                e.printStackTrace();
            }
           
           // System.out.println(StatesApp.fileState);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println("end of the thread DATOS");
    }

    public Vector<Categoria> getVecCategoriasDEFAULTS() {
        return vecCategoriasDEFAULTS;
    }
    public Vector<Categoria> getVecCategoriasCUSTOM() {
        return vecCategoriasCUSTOM;
    }
    
    
    
    
    
    
}
