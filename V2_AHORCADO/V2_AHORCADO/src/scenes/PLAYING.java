/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import scenes.StatesApp;
import static scenes.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class PLAYING extends JPanel implements ActionListener{
    public JButton goMenu;
    public int number;
    
    public PLAYING(){
       
       
        setBackground(new Color(0x137756));
        initButtons();
        addButtons();
        setVisible(true);
        
    }

    private void addButtons() {
        this.add(goMenu);
    }

    private void initButtons() {
        goMenu = new JButton();
        goMenu.setBounds(130,300,124,40);
        goMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
Object origen = ae.getSource();
         if(origen == this.goMenu){
             number=0;
           StatesApp.gameState=MENU;
           System.out.println("GO TO menu");
            
        }
    }

    public int getNumber() {
        return number;
    }
    
    
    
}
