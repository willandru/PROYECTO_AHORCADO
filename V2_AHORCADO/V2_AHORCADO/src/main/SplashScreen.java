/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kaliw
 */
public class SplashScreen extends JFrame implements Runnable{
    
    static SplashScreen instance;
    private static final int WIDTH_SPLASH = 634;
    private static final int HEIGTH_SPLASH = 312;
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
                Thread.sleep(6000);
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
        //panel.setBackground(Color.cyan);
        
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("/home/kaliw/GITHUB/PROYECTO_AHORCADO/V2_AHORCADO/V2_AHORCADO/src/resources/Ss1.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);
            panel.add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
