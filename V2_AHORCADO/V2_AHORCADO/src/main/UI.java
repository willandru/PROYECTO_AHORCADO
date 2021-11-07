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
import scenes.MENU;

/**
 *
 * @author kaliw
 */
public class UI extends JFrame {
    
    private JPanel myPanel;
    private static final int ANCHO=400;
    private static final int ALTO=680;
    
    private Thread T1=null;
    UI(){
//        T1= new Thread(this);
        setSize(ANCHO, ALTO);
        setBackground(new Color(0x123456));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        myPanel=new JPanel ();
        initMainPanel();
        add(myPanel);
        // T1.start();
        start();
        setVisible(true);
    }

    private void initMainPanel() {
        
        myPanel.setSize(ANCHO, ALTO);
        myPanel.setBackground(new Color(0x987297));
        myPanel.setLayout(null);
    }
    
   
    private void start(){
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                
                System.out.println("BEGIN WORKER");
                MENU m = new MENU();
                
              while(StatesApp.gameState != StatesApp.QUIT){ 
                  Thread.sleep(20);
                switch(StatesApp.gameState){
              
            case MENU:
               
                m.setSize(ANCHO, ALTO);
                m.setBackground(Color.blue);
                
                myPanel.removeAll();
                myPanel.add(m);
                myPanel.revalidate();
                myPanel.repaint();
                 
                System.out.println("NUMBER: "+ m.getNumero());
                publish(m.getNumero());
                System.out.println("MENU PUBLISHED");
                 Thread.sleep(8000);
                break;
            case PLAYIN:
                JPanel n = new JPanel();
                n.setSize(ANCHO, ALTO);
                n.setBackground(Color.yellow);
                
                myPanel.removeAll();
                myPanel.add(n);
                myPanel.revalidate();
                myPanel.repaint();
                
                 //publish(StatesApp.gameState);
                System.out.println("PLAYING");
                break;
            case SETTINGS:
                JPanel o = new JPanel();
                o.setSize(ANCHO, ALTO);
                o.setBackground(Color.red);
                
                myPanel.removeAll();
                myPanel.add(o);
                myPanel.revalidate();
                myPanel.repaint();
                
               // publish(StatesApp.gameState);
                System.out.println("SETTINGS");
                
                break;
            
                    
            
                }
               
              }
                

                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                 Integer value= chunks.get(chunks.size()-1);
                
                 if(value==1){
                     StatesApp.gameState= StatesApp.PLAYIN;
                 }else if(value == 2){
                     StatesApp.gameState= StatesApp.SETTINGS;
                 }
                
            }
            
           
        };
        worker.execute();
    }

    
}

