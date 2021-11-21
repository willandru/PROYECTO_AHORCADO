/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import scenes.*;

/**
 *
 * @author kaliw
 */
public class UI extends JFrame {
    
    private JPanel myPanel;
    private static final int ANCHO=400;
    private static final int ALTO=680;
    
    public static UI instance;
 
    
   //BOOLEANS  :: Permiten al HILO SWINGwORKER correr infinitamente y 
// No repintar infinitamente la escena y los botones cada vez
    
    public boolean continua=true;
    public boolean menuPintado=false;
    public boolean settsPintado=false;
    public boolean playPintado=false;
    
    
//ESCENAS :: Las diferentes Escenas pintadas en el Frame 
    public Menu m;
    public Playing p;
    public Settings s;
 
    UI(){
//Inicializamos el FRAME
        setSize(ANCHO, ALTO);
        setBackground(new Color(0x123456));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
 //INICIALIZAMOS Y AGREGAMOS el panel principal unido directamente al FRAME       
        myPanel=new JPanel ();
        initMainPanel();
        add(myPanel);
      
 //EMPIEZA EL HILO SWING WORKER  
        start();
        
        
        setVisible(true);
    }

    private void initMainPanel() {
        
        myPanel.setSize(ANCHO, ALTO);
        myPanel.setBackground(new Color(0x987297));
        myPanel.setLayout(null);
    }
    
   
    private void start(){
        SwingWorker<Void, StatesApp> worker = new SwingWorker<Void, StatesApp>() {
            @Override
            protected Void doInBackground() throws Exception {
                
                System.out.println("BEGIN WORKER");
                //MENU m = new Menu();
                
              while(continua){ 
                  Thread.sleep(30);
            switch(StatesApp.gameState){
              
            case MENU:
               
                if(!menuPintado){
                m = new Menu();
                m.setSize(ANCHO, ALTO);
                //m.setBackground(Color.blue);
                
                myPanel.removeAll();
                myPanel.add(m);
                myPanel.revalidate();
                myPanel.repaint();
                 
                System.out.println("Menu painted");
                menuPintado=true;
                playPintado=false;
                settsPintado=false;
                
            }
                //publish(StatesApp.gameState);
                //System.out.println("MENU holi PUBLISHED");
        
                break;
            case PLAYING:
                
                if(!playPintado){
                p = new Playing();
                p.setSize(ANCHO, ALTO);
                
                
                myPanel.removeAll();
                myPanel.add(p);
                myPanel.revalidate();
                myPanel.repaint();
                System.out.println("PLAYIN painted");
                playPintado=true;
                menuPintado=false;
                settsPintado=false;
                }
                 //publish(StatesApp.gameState);
                //System.out.println("PLAYING holi PUBLISHED");
               // System.out.println("");
                break;
            case SETTINGS:
                
                if(!settsPintado){
                s= new Settings();
                s.setSize(ANCHO, ALTO);
                s.setBackground(Color.green);
                
                myPanel.removeAll();
                myPanel.add(s);
                myPanel.revalidate();
                myPanel.repaint();
                System.out.println("SETTS painted");
                settsPintado=true;
                menuPintado=false;
                playPintado=false;
               
                }
                 //System.out.println(StatesApp.gameState);
                //System.out.println("SETTINGS");
                
                break;
            
                    
            
                }
               
              }
                

                return null;
            }

            @Override
            protected void process(List<StatesApp> chunks) {
                 StatesApp value= chunks.get(chunks.size()-1);
                
                System.out.println("kali.process(): "  + value);
                    // StatesApp.gameState= StatesApp.Menu;
                 
                
            }
            
           
        };
        worker.execute();
    }
    
    public static UI getInstance() {
        
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }

    
}

