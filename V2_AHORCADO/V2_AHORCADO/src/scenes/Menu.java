/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.StatesApp;
import static main.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class Menu extends JPanel implements ActionListener{
    
  

     private JButton btnClasssic, btnSetts, btnQuit, btnHistory, btnStore;
     private int numero;
     private JPanel imagePan;
     
     private static final int ANCHO=400;
    private static final int ALTO=680;
    
    public Menu(){
        System.err.println("CONSTRUCTOR : MENU");
        
        setLayout(null);
        setBackground(new Color(0xa61f22));
        initButtons();
        addButtons();
       
    
        setVisible(true);
        
    }

    

    private void initButtons() {

        btnClasssic = new JButton();
        btnClasssic.setBounds(70,130,250,73);
        btnClasssic.setIcon(getIconBUtton(1));
        btnClasssic.setBackground(null);
        btnClasssic.setBorderPainted(false);
        
        btnHistory=new JButton();
        btnHistory.setBounds(70,220,250,73);
        btnHistory.setIcon(getIconBUtton(2));
        btnHistory.setBackground(null);
        btnHistory.setBorderPainted(false);
        
        btnStore=new JButton();
        btnStore.setBounds(70,310,250,73);
        btnStore.setIcon(getIconBUtton(3));
        btnStore.setBackground(null);
        btnStore.setBorderPainted(false);
        
        btnSetts=new JButton();
        btnSetts.setBounds(70,400,250,73);
        btnSetts.setIcon(getIconBUtton(4));
        btnSetts.setBackground(null);
        btnSetts.setBorderPainted(false);
        
        btnQuit=new JButton();
        btnQuit.setBounds(70,490,250,73);
        btnQuit.setIcon(getIconBUtton(5));
        btnQuit.setBackground(null);
        btnQuit.setBorderPainted(false);
        
       

        btnClasssic.addActionListener(this);
        btnSetts.addActionListener(this);
        btnQuit.addActionListener(this);
        btnHistory.addActionListener(this);
        btnStore.addActionListener(this);
    }

    private void addButtons() {
        this.add(btnClasssic);
        this.add(btnSetts);
        this.add(btnQuit);
        this.add(btnHistory);
        this.add(btnStore);
        

    }
    
     public BufferedImage loadSpreadSheet(File path){
                 BufferedImage ig= null;
                //InputStream is = Playing.class.getClassLoader().getResourceAsStream("./src/resources/spriteABC.png");
                try {
                    ig = ImageIO.read(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                return ig;
            }

    
    private ImageIcon getIconBUtton(int n){
             ImageIcon im ;
             File path;
             BufferedImage buff;
             
             switch (n){
                case 1:
                    
                    path= new File("./src/resources/jugar.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    
                    
                    break;
                                       
                 case 2:
                    path= new File("./src/resources/historia.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;       
             
                                         
                       case 3:
                    path= new File("./src/resources/tienda.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;       
             
                       case 4:
                          path= new File("./src/resources/archivo.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                       break;
                       
                       
                       
                       
                       case 5:
                    path= new File("./src/resources/quitar.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;       
                    
                    default:
                          path= new File("./src/resources/RAYA_AHORCADO.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                       break;
                    
            }
            
            
             return im;
             
         }
    
    
    
    
    
    
    
    
     
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object origen = ae.getSource();
         if(origen == this.btnClasssic){
             numero=1;
           StatesApp.gameState=PLAYING;
           //StatesApp.playingState=DONE;
           System.out.println("action PLAYING (from MENU)");
            
        } else if(origen == this.btnSetts){
            numero=2;
            StatesApp.gameState=SETTINGS;
            System.out.println("actiion SETTINGS (from MENU)");
            System.out.println("state: "+ StatesApp.gameState);

            
        }else if(origen == this.btnQuit){
            System.exit(0);
        }
        
    }
   
    
    
    
    
    
}
