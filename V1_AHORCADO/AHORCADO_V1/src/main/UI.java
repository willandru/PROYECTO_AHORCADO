/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import screens.Menu;
import screens.Settings;

/**
 *
 * @author kaliw
 */
public class UI extends JFrame implements Runnable{ //IMPLEMENTS RUNNABLE
    private static UI instance;
    private static final int WIDTH_SCREEN = 400;
    private static final int HEIGHT_SCREEN = 700;
    private JPanel mainPanel;
    private Menu menu=new Menu();
    private Settings setts= new Settings();
    
    
    private Thread uiThread=null;
    public UI(){
        
        
        uiThread= new Thread(this);
        mainPanel=new JPanel();
        mainPanel.setSize(WIDTH_SCREEN,HEIGHT_SCREEN);
        mainPanel.setBackground(Color.red);
        
       
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.black);
      
        uiThread.start();
        

        
        setVisible(true);
    }

    public static UI getInstance() {
        
        if (instance == null) {
            instance = new UI();
        }
        return instance;
    }
    private void showPanel(JPanel p){
            
        p.setSize(WIDTH_SCREEN, HEIGHT_SCREEN);
        p.setLocation(0,0);
         mainPanel.removeAll();
         mainPanel.add(p);
         mainPanel.revalidate();
         mainPanel.repaint();
         
              
    }
    

    @Override
    public void run() {

        while(uiThread!=null)
            try{
                Thread.sleep(10);
                
                switch(StatesApp.gameState){
            case MENU:
                  Menu menu=new Menu();
                  showPanel(menu);
                  add(mainPanel);
                  menu.setVisible(true);
                  
        
                System.out.println("MENU");
                break;
            case PLAYIN:
                System.out.println("PLAYING");
                break;
            case SETTINGS:
                System.out.println("SETTINGS");
                Settings setts= new Settings();
                showPanel(setts);
                  add(mainPanel);
                  setts.setVisible(true);
                
                
                this.add(setts);
                this.setVisible(true);
                break;
            
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            uiThread=null;
        
    }
    
    
}
