/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author kaliw
 */
public class SplashScreen extends JFrame implements Runnable{
    
    static SplashScreen instance;
     private static final int WIDTH_SPLASH = 700;
    private static final int HEIGTH_SPLASH = 300;
    static UI uiInst;
    private Thread thread1=null; 
    private JPanel panel;
    
    public SplashScreen(){
        thread1 = new Thread(this);
        //thread1.setDaemon(true);
        setSize(WIDTH_SPLASH, HEIGTH_SPLASH);
        setLocationRelativeTo(null);
        setUndecorated(true);
        initPanels();
        add(panel);
        setVisible(true);
       
        thread1.start();
        //setUndecorated(true);

    }
    

    public static SplashScreen getInstance() {
        
        if (instance == null) {
            instance = new SplashScreen();
        }
        return instance;
    }
    
    @Override
    public void run() {

         while(thread1 !=null){
            try{
                Thread.sleep(2600);
                this.dispose();
                uiInst.getInstance();
            }catch (Exception e){
                e.printStackTrace();
            }
            thread1=null;
        }
    }

    private void initPanels() {

        panel= new JPanel();
        panel.setBounds(0, 0, WIDTH_SPLASH, HEIGTH_SPLASH);
        panel.setBackground(Color.cyan);
    }
    
}
