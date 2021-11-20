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
     private  JFileChooser fileOpener; 
    
     public Vector <Categoria> vecCategoriasCUSTOM;
     
      public Vector <Categoria> vecCategoriasDEFAULTS;
      private int numCategories;
      
      
      
      
      private Thread threadDATA=null; 
      private File defaultWords;
      
      public  boolean defaults= true;
      public  boolean customFIle = false;
      
     static Datos instance;
     
     
      public Datos(){
          threadDATA = new Thread(this);
          Vector <Categoria> vecCategoriasCUSTOM = null ;
          
          loadDefaults();
          
          
          threadDATA.start();
        
    }

    public static Datos getInstance() {
        
        if (instance == null) {
            instance = new Datos();
        }
        return instance;
    }
    
     
     
   public void loadDefaults(){
       try{
       defaultWords= new File("./src/resources/defailtsWords.txt");
        System.out.println("data defaults: " + defaultWords);
       }catch(Exception e){
           
       }
       
   }
    
    
      
    public void readFile(){
        fileOpener = new JFileChooser();
        
          fileOpener.setCurrentDirectory(new File("./src/resources"));
            int ans = fileOpener.showOpenDialog(null);
        
        if(ans== JFileChooser.APPROVE_OPTION){
                
 
          vecCategoriasCUSTOM=saveFile(vecCategoriasCUSTOM);
                    
                    
                    System.out.println(vecCategoriasCUSTOM);
                  System.out.println(numCategories);
                
                  
                                     vecCategoriasCUSTOM.get(0).printWords();
                   vecCategoriasCUSTOM.get(1).printWords();
                                      vecCategoriasCUSTOM.get(2).printWords();

              
}
    }
    
    
    public Vector<Categoria> saveFile(Vector<Categoria> cats){
        
        
        if (cats == null){
            try { 
            File dataFile = new File(fileOpener.getSelectedFile().getAbsolutePath());
            Scanner myReader = new Scanner(dataFile);
                 
                    boolean validLine;
                    boolean isCategory=false;
                    boolean isWord=false;
                    
                    numCategories=0;
                    int numPalabras=0;
                   
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
                                    System.out.println("Categoria "+ numCategories + " ; "+ data);
                                }
                                else{
                                    numPalabras++;
                                    newCategory.addPalabra(data); //****CUIDADO            CUIDADOO
                                                   
                                }               
                            }               
                    }
                      myReader.close();
              } catch (FileNotFoundException ex) {
                    Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
                }        
        }
        
        return cats;
    }
    
    public String randomWord(){
        String palabraRandom;
        Categoria catRandom;
        int categoriaRandom = (int) (Math.random()*numCategories-1+0);
        
        catRandom= vecCategoriasCUSTOM.get(categoriaRandom);
        int numPalabras = catRandom.getNumPalabras();
        
        int numPalabraRandom = (int) (Math.random()*numPalabras-1+0);
        
        palabraRandom= catRandom.getPalabra(numPalabraRandom);
        
        System.out.println(palabraRandom);
        return palabraRandom;
    }

    @Override
    public void run() {
        
        while(threadDATA !=null){
            try{
               // Thread.sleep(600);
               
               if(!defaults){
                   readFile();
               }
               
                
            }catch (Exception e){
                e.printStackTrace();
            }
            threadDATA=null;
            System.out.println("....JUJU...)");
        }
        System.out.println("baseDatos.Datos.run():: JUJU");
    }
    
}
