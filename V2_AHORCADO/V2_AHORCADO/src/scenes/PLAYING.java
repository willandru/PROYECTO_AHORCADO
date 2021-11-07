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
public class PLAYING extends JPanel implements ActionListener{
    public JButton goMenu, tryB;
    public int number=1;
    
    public PLAYING(){
        setLayout(null);
        setBackground(new Color(0x22a666));
        initButtons();
        addButtons();
        setVisible(true);  
    }

    private void addButtons() {
        this.add(goMenu);
        this.add(tryB);
        }

    private void initButtons() {
        
        goMenu = new JButton("GO MENU");
        
        
        try {
    Image img = ImageIO.read(getClass().getResource("/resources/btn1.png"));
    goMenu.setIcon(new ImageIcon(img));
  } catch (Exception ex) {
    System.out.println(ex);
  }
        
        goMenu.setBounds(250,0,139,72);
        goMenu.addActionListener(this);
        goMenu.setBackground(new Color(0,0,0,0));
        goMenu.setBorder(null);
        
        tryB = new JButton("TRY ME");
        tryB.setBounds(0,0,124,40);
        tryB.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            Object origen = ae.getSource();
                if(origen == this.goMenu){
                    number=0;
                  StatesApp.gameState=MENU;
                  System.out.println("GO TO menu");

               }else if(origen == this.tryB){
                   setBackground(new Color(0x911111));
               }
    }

    public int getNumber() {
            return number;
    }
    
    
    
}
