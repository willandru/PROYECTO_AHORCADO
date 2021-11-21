/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import baseDatos.Categoria;
import baseDatos.Datos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import main.MainAPP;

import main.StatesApp;
import static main.StatesApp.*;

/**
 *
 * @author kaliw
 */
public class Playing extends JPanel implements ActionListener, Runnable{
    
    
    public JButton goMenu, btnHELP, options;
    public int number=1;
    public JPanel p1,p2,p3,p4,p5,p6;
    private static final int WIDTHP=400;
    private static final int HEIGHTP=680;
    
    private static final int NUM_BOTTONS=27;
    
    private JButton []teclado= new JButton[NUM_BOTTONS];
    private String randomWord;  
    private JPanel panelCategory;
    private JTextField[] rayas;
    private JLabel[] labelRayas;
    private ImageIcon imageABC;
    private    ImageIcon imageRaya;
    
     private  Datos datosJUGAR = MainAPP.getInstance3();  
    
    private int letraAlAzar;
    
    private int numVidas=3;
    
    private boolean ayudaLeftt=true;
    
    private String palabra;
    
    private boolean [] letrasLLenadas;
    
    private int  numeroLetrasRandom=0;
    
    private int indiceDeLetra;
    
    private Thread gameThread;
    
   // private boolean DONE=false;
    
    
    public Playing(){
        setLayout(null);
        setBackground(new Color(0x22a666));
        initPanels();
        initButtons();
        
        addButtons();
        addPanels();
       
        gameThread= new Thread(this);
       //*****
        p1.add(p5);
        p1.add(p6);
        p1.add(panelCategory);
        p1.revalidate();
        p1.repaint();
       ///****
       
       
       //********
        p3.setLayout(null);
      
        initTeclado();
        addTeclado();
        
        
        
        
        
        
        
        gameThread.start();
        
        
            //EL USUARIO SELECIONA UNA TECLA segun la categoria
            
            // siempre SE JUEGA CON randomWord()
            
            
        
        
      
        setVisible(true);  
    }
    
    public String randomWord(Vector<Categoria> catsJugando){
        String palabraRandom;
        Categoria catRandom;
        int numCatsJugando= catsJugando.size();
        int categoriaRandom = (int) (Math.random()*numCatsJugando-1+0);
        
        catRandom= catsJugando.get(categoriaRandom);
        int numPalabras = catRandom.getNumPalabras();
        
        int numPalabraRandom = (int) (Math.random()*numPalabras-1+0);
        
        palabraRandom= catRandom.getPalabra(numPalabraRandom);
        
        System.out.println(palabraRandom);
        return palabraRandom;
    }
    
    private String drawRandomWord(){
        
       String word=null;
        Vector <Categoria> cateToPlay=null;
        int numeroLetras=0;
        
        switch(StatesApp.fileState){
            
            case WAIT:
               cateToPlay= datosJUGAR.getVecCategoriasCUSTOM();
                word=  randomWord(cateToPlay);
              
                numeroLetras=word.length();
                addJtextandJLabel(numeroLetras);
                
                
                
                break;
             
            case DEFAULT_FILE:
                 cateToPlay= datosJUGAR.getVecCategoriasDEFAULTS();
                word=  randomWord(cateToPlay);
                
                numeroLetras=word.length();
                addJtextandJLabel(numeroLetras);
                
                break;
            
        }
        
        System.out.println("RANDOM:: " +word);
       return word;
    }
    
    private void addJtextandJLabel(int n){
        rayas= new JTextField[n];  
        labelRayas= new JLabel[n];
        
        
        int columna=1;
        int fila=1;
         imageRaya= new ImageIcon("./src/resources/RAYA_AHORCADO2.png");
         
   
              
         
         
        for (int i=0; i<n; i++){
            
         
           
            
            rayas[i]= new JTextField();
            
            labelRayas[i]= new JLabel(imageRaya);
            labelRayas[i].setBounds(20*columna, fila * 50 +35, 30 , 3);
            rayas[i].setBounds(20*columna, fila*50, 30, 30);
            rayas[i].setText(" ");
            rayas[i].setEditable(false);
            rayas[i].setBackground(new Color (0,0,0,0));
            columna+=2;
            //fotoCol++;
            
            
            p2.add(labelRayas[i]);
            p2.add(rayas[i]);
            if(i== 8){
                columna=1;
                fila=2;
                //fotoCol=0;
                //fotoFil=1;
            }
            
        }
        
    }
    
    private ImageIcon getIcon(int fotoCol, int fotoFil, BufferedImage ig) {
         
        ImageIcon img;
        BufferedImage sub;
        
        sub=ig.getSubimage(fotoCol*33, fotoFil*30, 30, 30);
        img = new ImageIcon(sub);
        return img;
    

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
    
    private void initTeclado(){
        char digit;
        String num;
        int letra=65;
        
        
        int fotoCol=0;
        int fotoFil=0;
        File path;
        
         path= new File("./src/resources/spriteABC.png");
         BufferedImage buffImg = loadSpreadSheet(path);
        
        
        for(int i=0; i<27; i++){
             imageABC= getIcon(fotoCol, fotoFil, buffImg);
            
            teclado[i]= new JButton();
            teclado[i].addActionListener(this);
            teclado[i].setSize(35, 35); 
            digit= (char) letra;
            num= String.valueOf(digit);
           // teclado[i].setIcon(imageABC);
           teclado[i].setText(num);
              teclado[i].setFont(new Font("Sans Serif", Font.PLAIN, 5));
            letra++;
            fotoCol++;
           
            if(fotoCol==9 || fotoCol == 19){
                fotoCol=0;
                fotoFil++;
            }
             
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
    
    public void initP2(){
        
         p2= new JPanel();
         p2.setLayout(null);
         p2.setBounds(0, 250, WIDTHP, 150);
        p2.setBackground(Color.white);
        this.add(p2);
    }
    
    private void initPanels(){
        p1= new JPanel();
        //p2= new JPanel();
        p3= new JPanel();
        p4= new JPanel();
        p5= new JPanel();
        p6= new JPanel();
        
        panelCategory= new JPanel();
        panelCategory.setBounds(250, 200, 140,50);
        panelCategory.setBackground(Color.black);
        
        
        p1.setBounds(0, 0, WIDTHP, 250);
        p1.setBackground(Color.red);
        //p2.setBounds(0, 250, WIDTHP, 150);
        //p2.setBackground(Color.white);
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
        //this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
    }

    private void addButtons() {
        p4.add(goMenu);
        p4.add(btnHELP);
        p4.add(options);
        }

    private void initButtons() {
        
        goMenu = new JButton("HOME");
        btnHELP= new JButton("AYUDA");
        options= new JButton("OPTIONS");
        

        goMenu.setBounds(70,35,60,30);
        goMenu.addActionListener(this);
        goMenu.setBackground(new Color(222,22,123));
        goMenu.setBorder(null);
        
        btnHELP.setBounds(170,35,60,30);
        btnHELP.addActionListener(this);
        btnHELP.setBackground(new Color(111,222,111));
        btnHELP.setBorder(null);
        
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

               }else if(origen == this.btnHELP){
                   p1.setBackground(new Color(0x911111));
                   //TODO_ ----> ayuda: revelar una letra al azar
                   
                   // NECESITO TENER; REVISAR LA PALABRA, TOMAR UNA LETRA AL AZAR, LLENAR EL CAMPO,CORREPSONDIENTE.
                   // BOOLEAN para dar 1 sola oportunidad (o 2,3)
                   if (ayudaLeftt && StatesApp.playingState== NOT_DONE){
                        ayudarConLetra();
                        
                   }
                      
                   
               }
                else if(origen == this.options){
                   p1.setBackground(new Color(0x91a211));
               }
                for(int i=0; i<NUM_BOTTONS; i++){
                    if(origen == teclado[i]){
                   String txt=null;
                   txt = teclado[i].getText();
                   boolean pasa=verificarLetra(txt);
                   if(pasa){
                        addLetterToText(txt,indiceDeLetra);
                   }
                    
                       
                        System.out.println("CUCHAUUU " + txt);
               }
                }
                
    }
    
    public boolean itsDone(boolean[] array){
        for (boolean b : array) {
        if (!b) {
           return false;
        }
    }
    return true;
    }
    
    public boolean verificarLetra(String txt){
        
        boolean go= false;
        
         for(int i=0; i<numeroLetrasRandom; i++){
             
             System.out.println("scene::: "+ String.valueOf(palabra.charAt(i))+ " :: "+ txt);
                if (String.valueOf(palabra.charAt(i)).equals(txt) ){
                     go= true;
                     System.out.println("BIIITCHHH");
                     indiceDeLetra=i;
                    
                }
            }
        
        return go;
    }

    public int getNumber() {
            return number;
    }

    private void ayudarConLetra() {
        
        boolean go=false;
       
        letraAlAzar=(int) (Math.random()*numeroLetrasRandom+0);
        
       while(!go){
            if(!letrasLLenadas[letraAlAzar]){
            String l= String.valueOf(palabra.charAt(letraAlAzar));
            addLetterToText(l,letraAlAzar);
            go=true;
        }else{
                 letraAlAzar=(int) (Math.random()*numeroLetrasRandom+0);
            }
    }
        
        
        
                
                
                // TOCA MIRAR SI LA LETRA SE REPITE O NO Y PONERLA EN DONDE CORRESPONDA
                
                //TOCA SABER QUE LETRAS YA SE PUSIERON Y QUE LETRAS NO SE HAN PUESTO
        
      
    }

    private void  addLetterToText(String l, int indice){
         for(int i=0; i<numeroLetrasRandom; i++){
             System.out.println("p: "+ l);
               System.out.println("d: "+ palabra.charAt(i));
               System.out.println("d: "+ palabra.charAt(indice));
             
                if (palabra.charAt(i) ==  palabra.charAt(indice) ){
                    
                    rayas[i].setText(l);
                    letrasLLenadas[i]=true;
                    
                }
            }
        
    }
    private void setVariablesOfWord() {
        letrasLLenadas= new boolean[numeroLetrasRandom];
        
        for (int i=0; i<numeroLetrasRandom; i++){
            letrasLLenadas[i]= false;
        }
    }

    @Override
    public void run() {
        boolean itsDone=false;
        
        while(gameThread != null){
        
        if(StatesApp.playingState==DONE){
            initP2();
            palabra=drawRandomWord();
            p2.revalidate();
            p2.repaint();
            numeroLetrasRandom= palabra.length();
            setVariablesOfWord();
            
        }
        StatesApp.playingState=NOT_DONE;
       
        if(itsDone){
            StatesApp.playingState=DONE;
           
        }
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Playing.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(StatesApp.playingState);
    }
        
       
        
        // *******
            // STARTS HERE
        //********
         
    }

  

    
    
    
    
}
