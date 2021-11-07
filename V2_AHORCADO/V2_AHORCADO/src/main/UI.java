/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import scenes.MENU;

/**
 *
 * @author kaliw
 */
public class UI extends JFrame {
    
    private JPanel myPanel;
    private static final int ANCHO=400;
    private static final int ALTO=680;
    
    UI(){
        setSize(ANCHO, ALTO);
        setBackground(new Color(0x123456));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        myPanel=new JPanel ();
        initMainPanel();
        add(myPanel);
        start();
        setVisible(true);
    }

    private void initMainPanel() {
        
        myPanel.setSize(ANCHO, ALTO);
        myPanel.setBackground(new Color(0x987297));
        myPanel.setLayout(null);
    }
    
    
    
    
    private void start(){
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                
                
                JPanel n = new JPanel();
                n.setSize(ANCHO, ALTO);
                n.setBackground(Color.yellow);
                
                myPanel.removeAll();
                 myPanel.add(n);
                myPanel.revalidate();
                myPanel.repaint();
                
                Thread.sleep(1000);
                  
                MENU m = new MENU();
                m.setSize(ANCHO, ALTO);
                m.setBackground(Color.blue);
                
                myPanel.removeAll();
                 myPanel.add(m);
                myPanel.revalidate();
                myPanel.repaint();
                
                Thread.sleep(1000);
                  
                JPanel o = new JPanel();
                o.setSize(ANCHO, ALTO);
                o.setBackground(Color.red);
                
                myPanel.removeAll();
                 myPanel.add(o);
                myPanel.revalidate();
                myPanel.repaint();
                
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                
            }
            
           
        };
        worker.execute();
    }
    
}
