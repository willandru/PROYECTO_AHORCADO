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
        setBackground(new Color(0x936722));
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
        goMenu.setBounds(276,0,124,40);
        goMenu.addActionListener(this);
        
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
