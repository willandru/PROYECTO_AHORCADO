/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public boolean continua=true;
    public boolean menuPintado=false;
    public boolean settsPintado=false;
    public boolean playPintado=false;
    
    
    public MENU m;
    public PLAYING p;
 
    UI(){
//        T1= new Thread(this);
        setSize(ANCHO, ALTO);
        setBackground(new Color(0x123456));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        myPanel=new JPanel ();
        initMainPanel();
        add(myPanel);
       
        
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
                MENU m = new MENU();
                
              while(continua){ 
                  Thread.sleep(30);
                switch(StatesApp.gameState){
              
            case MENU:
               
                if(!menuPintado){
                    m = new MENU();
                m.setSize(ANCHO, ALTO);
                //m.setBackground(Color.blue);
                
                myPanel.removeAll();
                myPanel.add(m);
                myPanel.revalidate();
                myPanel.repaint();
                 
                System.out.println("Menu painted");
                menuPintado=true;
                playPintado=false;
                
            }
                System.out.println("NUMBER: "+ m.getNumero());
                publish(StatesApp.gameState);
                System.out.println("MENU holi PUBLISHED");
        
                break;
            case PLAYING:
                
                if(!playPintado){
                p = new PLAYING();
                p.setSize(ANCHO, ALTO);
                p.setBackground(Color.yellow);
                
                myPanel.removeAll();
                myPanel.add(p);
                myPanel.revalidate();
                myPanel.repaint();
                System.out.println("PLAYIN painted");
                playPintado=true;
                menuPintado=false;
                }
                 publish(StatesApp.gameState);
                System.out.println("PLAYING holi PUBLISHED");
               // System.out.println("");
                break;
            case SETTINGS:
                
                if(!settsPintado){
                JPanel o = new JPanel();
                o.setSize(ANCHO, ALTO);
                o.setBackground(Color.red);
                
                myPanel.removeAll();
                myPanel.add(o);
                myPanel.revalidate();
                myPanel.repaint();
                System.out.println("SETTS painted");
                settsPintado=true;
                menuPintado=false;
               
                }
               // publish(StatesApp.gameState);
                System.out.println("SETTINGS");
                
                break;
            
                    
            
                }
               
              }
                

                return null;
            }

            @Override
            protected void process(List<StatesApp> chunks) {
                 StatesApp value= chunks.get(chunks.size()-1);
                
                System.out.println(".process(): "  + value);
                    // StatesApp.gameState= StatesApp.MENU;
                 
                
            }
            
           
        };
        worker.execute();
    }

    
}

