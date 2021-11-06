/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Graphics;
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
public class Settings extends JPanel implements ActionListener{
private JButton btn;
    public Settings(){
        System.out.println("CONFIGS");
        setLayout(null);
        initButn();
        addButn();
    }

    private void initButn() {
        btn= new JButton();
        btn.setBounds(130,300,124,40);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object origen = ae.getSource();
         if(origen == this.btn){
           StatesApp.gameState= PLAYIN;
            
        }
    }

    private void addButn() {
        this.add(btn);
    }
    
}
