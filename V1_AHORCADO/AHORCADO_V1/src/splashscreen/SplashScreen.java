/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author kaliw
 */
public class SplashScreen extends JFrame implements Runnable{
    
    JPanel panellIzq;
    JPanel panellDer;
    JLabel imageA;
    JLabel imageB;
    JProgressBar bar;
    static SplashScreen instance;
    private static final int WIDTH_SPLASH = 600;
    private static final int HEIGTH_SPLASH = 600;
    Thread thread1 = new Thread(this);

    public static SplashScreen getInstance() {
        
        if (instance == null) {
            instance = new SplashScreen();
        }
        return instance;
    }
    
    public SplashScreen(){
        
        thread1.setDaemon(true);
        setSize(WIDTH_SPLASH, HEIGTH_SPLASH);
        setLocationRelativeTo(null);
        initPanels();
        thread1.start();
        //setUndecorated(true);
        
        
    
    }

    private void initPanels() {
        panellIzq = new JPanel();
        panellIzq.setSize(WIDTH_SPLASH / 2, HEIGTH_SPLASH);
        panellIzq.setBackground(Color.darkGray);
        
        panellDer = new JPanel();
        panellDer.setSize(WIDTH_SPLASH / 2, HEIGTH_SPLASH);
        panellDer.setBackground(Color.black);
        
        ImageIcon img1;
        img1 = new ImageIcon("/images/pic.gif");
        imageA= new JLabel(img1);   
        imageA.setBounds(0, HEIGTH_SPLASH/4,256,256);
        
        bar = new javax.swing.JProgressBar();
        bar.setBounds(0,HEIGTH_SPLASH-30, WIDTH,30);
        
        
        this.getContentPane().add(panellIzq);
        this.getContentPane().add(panellDer);
        this.add(imageA);
        this.getContentPane().add(bar);
    }



    @Override
    public void run() {
         int x=0;
         try {
             setVisible(true);
             //this.setVisible(true);
                     while(x<=100){
                         
                         bar.setValue(x);
                         //porcentaje.setText(x+"%");
                         //porcentaje2.setText(cad+x+"%");
                         x+=25;
                         //cad+=".";
                         Thread.sleep(5000);
                     }
                     dispose();
                     
                 } catch (Exception e) {
                     System.out.println("Exception "+ e.getMessage());
                 }

    }
}
