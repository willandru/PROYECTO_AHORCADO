/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Playing extends JPanel implements ActionListener{
    public JButton goMenu, noSound, options;
    public int number=1;
    public JPanel p1,p2,p3,p4,p5,p6;
    private static final int WIDTHP=400;
    private static final int HEIGHTP=680;
    private JButton []teclado= new JButton[27];
    
    public Playing(){
        setLayout(null);
        setBackground(new Color(0x22a666));
        initPanels();
        initButtons();
        
       addButtons();
       addPanels();
       
       //*****
       p1.add(p5);
        p1.add(p6);
        
        p1.revalidate();
        p1.repaint();
       ///****
      p3.setLayout(null);
       
        initTeclado();
        addTeclado();
        
        setVisible(true);  
    }
    
    
    private void initTeclado(){
        for(int i=0; i<27; i++){
            teclado[i]= new JButton();
            teclado[i].setSize(30, 30); 
            
        }
    }
    
    private void addTeclado(){
         int columna=15;
            int fila=40;
        for(int i=0; i<27; i++){
           
            
            if(i<10){
                 teclado[i].setLocation(columna, fila);
                 columna+=35;
                 
                 if (i==9){
                     columna=35;
                     fila= 90;
                 }
            }
            else if(i<20 && i>=10){
                teclado[i].setLocation(columna, fila);
                 columna+=35;
                 if (i==19){
                     columna=65;
                     fila= 140;
                 }
              
            }else{
                //****
                //***
                
                teclado[i].setLocation(columna, fila);
                 columna+=35;
            }
            
           
            
        }
        for(int i=0; i<27; i++){
        
            p3.add(teclado[i]);
        }
        
    }
    
    private void initPanels(){
        p1= new JPanel();
        p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        p5= new JPanel();
        p6= new JPanel();
    
        
        p1.setBounds(0, 0, WIDTHP, 250);
        p1.setBackground(Color.red);
        p2.setBounds(0, 250, WIDTHP, 150);
        p2.setBackground(Color.blue);
        p3.setBounds(0, 400, WIDTHP, 200);
        p3.setBackground(Color.darkGray);
        p4.setBounds(0, 600, WIDTHP, 100);
        p4.setBackground(Color.yellow);
        p5.setBounds(140,0, 120, 40);
        p5.setBackground(Color.black);
        p6.setBounds(320,50, 80, 35);
        p6.setBackground(Color.black);
        
        p1.setLayout(null);
        
        
        
    }
    
    private void addPanels(){
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
    }

    private void addButtons() {
        p4.add(goMenu);
        p4.add(noSound);
        p4.add(options);
        }

    private void initButtons() {
        
        goMenu = new JButton("HOME");
        noSound= new JButton("SOUND");
        options= new JButton("OPTIONS");
        

        goMenu.setBounds(70,35,60,30);
        goMenu.addActionListener(this);
        goMenu.setBackground(new Color(222,22,123));
        goMenu.setBorder(null);
        
        noSound.setBounds(170,35,60,30);
        noSound.addActionListener(this);
        noSound.setBackground(new Color(111,222,111));
        noSound.setBorder(null);
        
        options.setBounds(170,35,60,30);
        options.addActionListener(this);
        options.setBackground(new Color(111,2,231));
        options.setBorder(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Object origen = ae.getSource();
                if(origen == this.goMenu){
                    number=0;
                  StatesApp.gameState=MENU;
                  System.out.println("GO TO menu");

               }else if(origen == this.noSound){
                   p1.setBackground(new Color(0x911111));
               }
                else if(origen == this.options){
                   p1.setBackground(new Color(0x91a211));
               }
    }

    public int getNumber() {
            return number;
    }
    
    
    
}
