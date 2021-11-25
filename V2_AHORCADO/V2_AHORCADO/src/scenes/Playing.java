/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import baseDatos.Categoria;
import baseDatos.Datos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JComponent;
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
    
    
    public JButton goHome, giveLetter, changeWord, giveWord;
    public int number=1;
    public JPanel p1,p2,p3,p4,p5,p6, panelImagenAhorcado, panelDatos;

    private static final int WIDTHP=400;
    private static final int HEIGHTP=680;
    
    private static final int NUM_BOTTONS=26;
    
    private JButton []teclado= new JButton[NUM_BOTTONS];
    
    private ImageIcon [] tecladoBlue= new ImageIcon[NUM_BOTTONS];
    private ImageIcon [] tecladoRed= new ImageIcon[NUM_BOTTONS];
    
    //private String randomWord;  
    private JPanel panelCategory;
    private JTextField[] letraText;
    private JLabel[] labelRayas;
    
    private ImageIcon imageABC;
    private ImageIcon imageBlue;
    private ImageIcon imageRed;

    private    ImageIcon imageRaya;
    
     private  Datos datosJUGAR = MainAPP.getInstance3();  
    
    private int letraAlAzar;
    
    private int numVidas=7;
    
    private boolean ayudaLeftt=true;
    
    private String palabra;
    
    private boolean [] letrasLLenadas;
    
    private int  numeroLetrasRandom=0;
    
    private int indiceDeLetra;
    
    private Thread gameThread;
    
    
    
    // *********** 
    
    private JTextField textCategory;    
    private  Vector <Categoria> cateToPlay=null;
    private int numeroLetras;
    
    
   // private boolean DONE=false;
    
    
    private File pathAhorcado;
    private BufferedImage buffImgAhor;
    
    
    private File fileA;
    private BufferedImage buffA;
    private JLabel labelA;
    private ImageIcon iconA;
    //private JPanel panelA;
    private Thread threadA;
    
    private JLabel[] imgLabelAhorcado;
    private ImageIcon[] imageAhorcado;
    
    private ImageIcon i1, i2, i3, i4, i5, i6;
    
    private boolean b1,b2,b3,b4,b5,b6, b7 = false;
    
    
    private JLabel labelNivel, labelVIdas, labelCategoria, labelIntentos;
    
    private JPanel panelIntentos, panelLabels;
    
    private JLabel labelIconVida;
    
    String namCateg= " ";
    
    private int nivel=1;
    
    private boolean wasHelp, nextLevel=false;
    
    public Playing(){
       
        System.err.println("CONSTRUCTOR PLAYING");
        
        
        pathAhorcado= new File("./src/resources/Recurso 2.png");  
        buffImgAhor = loadSpreadSheet(pathAhorcado);
        //initImages();
        
        
        //intPanelAhorcado();
        
       // addImageAhorcado(0);
        
        
        setLayout(null);
        setBackground(new Color(0x22a666));
        initPanels();
        
       // initPanelAhorcado();
        initA();
        
        initButtons();
        
        addButtons();
        addPanels();
       
        gameThread= new Thread(this);
       //*****
       // p4.add(p5);
        //p4.add(p6);
        panelDatos.setLayout(null);
        panelDatos.add(panelCategory);
        panelDatos.add(p5);
        p1.revalidate();
        p1.repaint();
       ///****
       
       
       //********
        p3.setLayout(null);
      
        initTeclado();
        addTeclado();
        
       
    
         p2.setLayout(null);
         //drawRandomWord();
        
        p2.revalidate();
        p2.repaint();
        
        
        
        
        gameThread.start();
        
        
            //EL USUARIO SELECIONA UNA TECLA segun la categoria
            
            // siempre SE JUEGA CON randomWord()
            
            
        
        
      
        setVisible(true);  
    }
    
    
    
    private void initA(){
            fileA = new File("./src/resources/Recurso 2.png");
            buffA= loadSpreadSheet(fileA);
            iconA= getIconAHORCADO(2, 1, buffA);
            
            imageAhorcado = new ImageIcon[7];
                imageAhorcado[0] = getIconAHORCADO(0, 0, buffA);
                imageAhorcado[1] = getIconAHORCADO(1, 0, buffA);
                imageAhorcado[2] = getIconAHORCADO(2, 0, buffA);         
                imageAhorcado[3] = getIconAHORCADO(0, 1, buffA);
                imageAhorcado[4] = getIconAHORCADO(1, 1, buffA);
                imageAhorcado[5] = getIconAHORCADO(2, 1, buffA);
                 imageAhorcado[6] = getIconAHORCADO(3, 1, buffA);
      
    }
    
    
           private void initPanels(){
            

            p1= new JPanel();
            p2= new JPanel();
            p3= new JPanel();
            p4= new JPanel();
            p5= new JPanel();
            p6= new JPanel();
            panelDatos= new JPanel();
            
            panelDatos.setBounds(0, 250, WIDTHP, 40);
            panelDatos.setBackground(Color.white);
            
            
            
            panelIntentos = new JPanel();
            panelIntentos.setBounds(300, 0, 70, 30);
            panelIntentos.setBackground(Color.red);
            
            
            panelLabels =  new JPanel();
            panelLabels.setBounds(0,565,WIDTHP, 30);
            panelLabels.setLayout(null);
                    
            
            
            
            panelCategory= new JPanel();
            panelCategory.setBounds(130, 0, 140,35);
            panelCategory.setBackground(Color.white);


            p1.setBounds(0, 0, WIDTHP, 250);
            p1.setBackground(Color.black);
           
            p2.setBounds(0, 290, WIDTHP, 110);
            p2.setBackground(Color.white);
            
            
            
            p3.setBounds(0, 400, WIDTHP, 165);
            p3.setBackground(Color.white);
            p4.setBounds(0, 595, WIDTHP, 55);
            p4.setBackground(Color.white);
            p5.setBounds(0,0, 70, 40);
            p5.setBackground(new Color(111,222,111));
            p6.setBounds(15,0, 50, 50);
            p6.setBackground(Color.blue);
            p6.setLayout(null);
            
            
            p4.setLayout(null);
            
            
            
            initA();
            
             p1.setLayout(null);
             
             
             
             labelVIdas= new JLabel(String.valueOf(numVidas));
             labelVIdas.setBounds(35, 0, 50, 30);
             
             
            labelCategoria= new JLabel();
            
           

        }
           private void initPanelAhorcado(int n){
               
            labelA= new JLabel(imageAhorcado[n]);
            panelImagenAhorcado= new JPanel();    
            panelImagenAhorcado.setBounds(0, 0,  WIDTHP, 250);
            panelImagenAhorcado.setBackground(Color.white);
            panelImagenAhorcado.add(labelA);
            p1.add(panelImagenAhorcado);
            p1.revalidate();
            p1.repaint();
            
            
           }
          private void initImages(){
              int n=6;
              imgLabelAhorcado = new JLabel[n];
              
               imageAhorcado[0]= getIconAHORCADO(0, 0, buffImgAhor);   
               imageAhorcado[1]= getIconAHORCADO(0, 1, buffImgAhor);   
                imageAhorcado[2]= getIconAHORCADO(0, 2, buffImgAhor);   
                 imageAhorcado[3]= getIconAHORCADO(1, 0, buffImgAhor);   
                  imageAhorcado[4]= getIconAHORCADO(1, 1, buffImgAhor);   
                   imageAhorcado[5]= getIconAHORCADO(1, 2, buffImgAhor);   
                   
              for(int i=0; i<n; i++){
              imgLabelAhorcado[i]= new JLabel(imageAhorcado[i]);
          }     
          }
           
           private void addImageAhorcado(int n){
             panelImagenAhorcado.add(imgLabelAhorcado[n]);
             p1.add(panelImagenAhorcado);
           }

        private void addPanels(){
            this.add(p1);
            this.add(p2);
            this.add(p3);
            this.add(p4);
            this.add(panelDatos);
            
            this.add(panelLabels);
            
            panelDatos.add(panelIntentos);
            
            panelLabels.add(labelVIdas);
            
            panelCategory.add(labelCategoria);
           //this.add(p5);
            //this.add(p6);
            
             
        }

        private void addButtons() {
            p4.add(goHome);
            p4.add(giveLetter);
            p4.add(changeWord);
            p4.add(giveWord);
            p6.add(labelIconVida);
            p4.add(p6);
            
            }

        private void initButtons() {
          
            int col= (WIDTHP/5);
            
            int size =50;

            goHome = new JButton();
            giveLetter= new JButton();
            changeWord= new JButton();
            giveWord = new JButton();
            
            giveWord.setBounds(col*2+15,0,size,size);
            giveWord.addActionListener(this);
            giveWord.setBackground(new Color(222,150,123));
            giveWord.setBorder(null);

            goHome.setBounds(col*4+15,0,size,size);
            goHome.addActionListener(this);
            goHome.setBackground(new Color(222,22,123));
            goHome.setBorder(null);

            giveLetter.setBounds(col*1+15,0,size,size);
            giveLetter.addActionListener(this);
            giveLetter.setBackground(new Color(111,222,111));
            giveLetter.setBorder(null);

            changeWord.setBounds(col*3+15,0,size,size);
            changeWord.addActionListener(this);
            changeWord.setBackground(new Color(121,222,223));
            changeWord.setBorder(null);
            
            
           
                ImageIcon icon= getIconButton(5);
                 goHome.setIcon(icon);
                 ImageIcon iconVida= getIconButton(1);
              
                 labelIconVida= new JLabel(iconVida);
                 
                 labelIconVida.setBounds(0, 0, 50, 50);
           
                 
                 
            

        }
    
        private ImageIcon getIconAHORCADO(int x, int y, BufferedImage bf){
            
            ImageIcon im;
            
            BufferedImage subImage;
            
            subImage= bf.getSubimage(x*WIDTHP, y*250,  WIDTHP, 250);
            
            im= new ImageIcon(subImage);
            
            return im;
            
        }
         private ImageIcon getIconDEFAULT(int fotoCol, int fotoFil, BufferedImage ig) {

                ImageIcon img;
                BufferedImage sub;
                sub=ig.getSubimage(fotoCol*35, fotoFil*35, 35, 35);
                img = new ImageIcon(sub);
                return img;
            }
         
         
         private ImageIcon getIconButton(int n){
             
             ImageIcon im ;
             File path;
             BufferedImage buff;
            
             
            // pathB= new File("./src/resources/spriteABC.png");
            switch (n){
                case 1:
                    
                    path= new File("./src/resources/Recurso 3.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    
                    
                    break;
                                       
                 case 2:
                    path= new File("./src/resources/Ss1.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;       
                    
                    
                    
                   case 3:
                    path= new File("./src/resources/ahorcado.jpg");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;    
                    
                    
                    
                  case 4:
                    path= new File("./src/resources/RAYA_AHORCADO2.png");
              buff= loadSpreadSheet(path);
             im= new ImageIcon(buff);
                    break;
                    
                    
                    
                     case 5:
                    path= new File("./src/resources/Recurso 5.png");
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
            private ImageIcon getIconBLACK(int fotoCol, int fotoFil, BufferedImage ig) {

                ImageIcon img;
                BufferedImage sub;
                sub=ig.getSubimage(fotoCol*32, fotoFil*30, 30, 30);
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
            File pathD;
            File pathB;
            File pathR;

             pathD= new File("./src/resources/TecBlack.png");
            // pathB= new File("./src/resources/spriteABC.png");
             BufferedImage buffImg = loadSpreadSheet(pathD);


              pathB= new File("./src/resources/tecBlue.png");
            // pathB= new File("./src/resources/spriteABC.png");
             BufferedImage buffImgBlue = loadSpreadSheet(pathB);
             
             
              pathR= new File("./src/resources/tecRed.png");
            // pathB= new File("./src/resources/spriteABC.png");
             BufferedImage buffImgRed = loadSpreadSheet(pathR);
             
             
            for(int i=0; i<NUM_BOTTONS; i++){
                
                 imageBlue= getIconDEFAULT(fotoCol, fotoFil, buffImgBlue);
                 imageRed= getIconDEFAULT(fotoCol, fotoFil, buffImgRed);
                 
                
                 
                teclado[i]= new JButton();
                teclado[i].addActionListener(this);
                teclado[i].setSize(35, 35); 
                 teclado[i].setBorderPainted(false); 
                  //teclado[i].setOpaque(false);
                teclado[i].setContentAreaFilled(false);
                //button.setBorderPainted(false);
                 
                tecladoBlue[i]= imageBlue;
                 tecladoRed[i]= imageRed;
               
                
                digit= (char) letra;
                num= String.valueOf(digit);
                
                 imageABC= getIconDEFAULT(fotoCol, fotoFil, buffImg);
                teclado[i].setIcon(imageABC);
                
                teclado[i].setText(num);
                teclado[i].setFont(new Font("Sans Serif", Font.PLAIN, 0));
                  
                  
                letra++;
                fotoCol++;
                if(fotoCol==10 || fotoCol == 19){
                    fotoCol=0;
                    fotoFil++;
                }
                
                addIcon(fotoCol, fotoFil, buffImg);

            }
        }
        
        private void addIcon(int fotoCol, int fotoFil,BufferedImage buffImg){
            
        }

        private void addTeclado(){
             int columna=15;
                int fila=5;
            for(int i=0; i<NUM_BOTTONS; i++){


                if(i<10){
                     teclado[i].setLocation(columna, fila);
                     columna+=35;

                     if (i==9){
                         columna=35;
                         fila= 46;
                     }
                }
                else if(i<20 && i>=10){
                    teclado[i].setLocation(columna, fila);
                     columna+=35;
                     if (i==19){
                         columna=55;
                         fila= 90;
                     }

                }else{
                    //****
                    //***

                    teclado[i].setLocation(columna, fila);
                     columna+=35;
                }



            }
            for(int i=0; i<NUM_BOTTONS; i++){

                p3.add(teclado[i]);
            }

        }

    public String randomWord(Vector<Categoria> catsJugando){
        String palabraRandom;
        Categoria catRandom;
        int numCatsJugando= catsJugando.size();
        
        System.out.println("NUMERO DE CATEGORIAS: "+ numCatsJugando);
        
        int categoriaRandom = (int) (Math.random()*(numCatsJugando)+0);
        System.out.println("NUMERO DE ALETORIO: "+ categoriaRandom);
        catRandom= catsJugando.get(categoriaRandom);
        int numPalabras = catRandom.getNumPalabras();
        
        int numPalabraRandom = (int) (Math.random()*(numPalabras-1)+0);
        
        palabraRandom= catRandom.getPalabra(numPalabraRandom);
        
        namCateg=catRandom.getNameCategory();
        
        System.out.println(catRandom.getNameCategory());
        System.out.println(palabraRandom);
        return palabraRandom;
    }
    
    private String drawRandomWord(){
        
        System.out.println("DRAW_RANDOM_WORD()-->PLAYING");
        
       String word=null;
        //wathhh
        numeroLetras=0;
        
        switch(StatesApp.fileState){
            
            case WAIT:
                 System.out.println("IM IDIOT WAIT");
                cateToPlay= new Vector<Categoria>();
                cateToPlay= datosJUGAR.getVecCategoriasCUSTOM();
                System.out.println("CATEGORIA PARA JUGAR:" + cateToPlay.toString());
                word=  randomWord(cateToPlay);
                System.out.println("PALABRA PARA JUGAR:" + word);
                numeroLetras=word.length();
                System.out.println("LETRAS:" + numeroLetras);
                addJtextandJLabel(numeroLetras);
                break;
                
            case DEFAULT_FILE:
                 System.out.println("IM IDIOT BT DEFAULT");
                cateToPlay= new Vector<Categoria>();
                cateToPlay= datosJUGAR.getVecCategoriasDEFAULTS();
                System.out.println("CATEGORIA PARA JUGAR:" + cateToPlay.toString());
                word=  randomWord(cateToPlay);  
                System.out.println("PALABRA PARA JUGAR:" + word);
                numeroLetras=word.length();
                addJtextandJLabel(numeroLetras);
                break;
            
                
               
        }
        
        System.out.println("RANDOM:DIBUJADA:SALIENDO metodo DRAW_RANDOM_WORD()-->PLAYING" +word);
       return word;
    }
    
    private void removeJTextandJLabel(){
        for (int i=0; i<numeroLetras; i++){
            
              p2.remove(labelRayas[i]);
            p2.remove(letraText[i]);
            p2.revalidate();
            p2.repaint();
        }
        
        
    }
    
    
        private void addJtextandJLabel(int n){
        letraText= new JTextField[n];  
        labelRayas= new JLabel[n];
        
        
        int columna=1;
        int fila=1;
        
        
         imageRaya= new ImageIcon("./src/resources/RAYA_AHORCADO2.png"); 
// TODO
         System.out.println("IMAGE LOADED:)"+ imageRaya);
         System.out.println("----PINTANDO LAS RAYAS -----");
         System.out.println("NUMERO LETRAS: "+ n);

        for (int i=0; i<n; i++){

            letraText[i]= new JTextField();
            labelRayas[i]= new JLabel(imageRaya);
            
            labelRayas[i].setBounds(20*columna, fila * 10 +35, 30 , 3);
             letraText[i].setBounds(20*columna, fila*10, 30, 30);
            
            letraText[i].setText(" ");
            letraText[i].setEditable(false);
            letraText[i].setBackground(new Color (0,0,0,0));
            columna+=2;
            //fotoCol++;

            
            p2.add(labelRayas[i]);
            p2.add(letraText[i]);
            System.out.println(" Cantindad RAYAS DIBUJADAS Y AGREAGADSA: "+ n);
            
            if(i== 8){
                columna=1;
                fila=2;
            }
            
        }
        
        labelCategoria.setText(namCateg);
        System.out.println("--------RAYAS Y CAJAS DIBUJADAS ---------");
    }
    private void ayudarConPalabra(){
        for (int i=0; i< numeroLetrasRandom; i++){
            if(!letrasLLenadas[i]){
            String l= String.valueOf(palabra.charAt(i));
            addLetterToText(l,i);
        }
        }
        
    }
           
    private void ayudarConLetra( ) {
        
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
            
            if(itsDone()){
                System.out.println("THE WORD HAS BEEN COMPLETED");
                break;
            }
    }    
                
                // TOCA MIRAR SI LA LETRA SE REPITE O NO Y PONERLA EN DONDE CORRESPONDA
                
                //TOCA SABER QUE LETRAS YA SE PUSIERON Y QUE LETRAS NO SE HAN PUESTO

    }

    private void  addLetterToText(String l, int indice){
         for(int i=0; i<numeroLetrasRandom; i++){
                if (palabra.charAt(i) ==  palabra.charAt(indice) ){              
                    letraText[i].setText(l);
                    letrasLLenadas[i]=true;  
                }
            }
        System.out.println("LETRA : '"+l+ "' AGREGADA");
    } 
    
    public boolean itsDone(){
       if(letrasLLenadas != null){
            for (boolean b : letrasLLenadas) {
        if (!b) {
           return false;
        }
    }
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verificarLetra(String txt ){
        
        boolean letraValida= false;
        
         for(int i=0; i<numeroLetrasRandom; i++){
             
             System.out.println("VERIFICANDO LETRA EN LA PALABRA ");
                if (String.valueOf(palabra.charAt(i)).equals(txt) ){
                     letraValida= true;          
                     indiceDeLetra=i;
                    
                    
                }
                
               
            }
        
        return letraValida;
    }
     
    private void setVariablesOfWord() {
        letrasLLenadas= new boolean[numeroLetrasRandom];
        
        for (int i=0; i<numeroLetrasRandom; i++){
            letrasLLenadas[i]= false;
        }
    }
   
    public int getNumber() {
            return number;
    }

    
    @Override
    public void run() {
        boolean itsDone;
       Container  glassPane= (Container) getRootPane();
        while(gameThread != null){
            itsDone=itsDone();
        
        if(StatesApp.playingState==DONE){
            
            palabra=drawRandomWord();
            p2.revalidate();
            p2.repaint();
            numeroLetrasRandom= numeroLetras;
            setVariablesOfWord();
            StatesApp.playingState=NOT_DONE;
            System.err.println("   TABLERO PINTADO -----");
            
        }else if(StatesApp.playingState== NOT_DONE){
            
            nextLevel=false;
        }
        else if(StatesApp.playingState==LOST){
            
            System.out.println("U ARE LOSER");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Playing.class.getName()).log(Level.SEVERE, null, ex);
            }
             StatesApp.gameState=MENU;
             StatesApp.playingState=NOT_DONE;
        } else if(StatesApp.playingState==NEW_LEVEL){
            System.out.println("U ARE A WINNER");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Playing.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0; i<NUM_BOTTONS; i++){

                p3.remove(teclado[i]);
            }
                initTeclado();
                addTeclado();
        
            glassPane.setVisible(false);
            
            
            nextLevel=true;
            
            removeJTextandJLabel();
                   StatesApp.playingState=DONE;
            
        }

        if(itsDone && !nextLevel){
            StatesApp.playingState=DONE;
            System.out.println("THE WORD HAS BEEN COMPLETED #2");
            if(!wasHelp){
                setGlass();
                           nivel++;
                          
                           glassPane= (Container) getRootPane().getGlassPane();
                           
                           JButton b= new JButton("GANASTE");
                           b.setBounds(150,300,100,100);
                           glassPane.add(b);
                           
                            glassPane.setVisible(true);
                            StatesApp.playingState=NEW_LEVEL;
                           
            }
           
        }
        
            System.out.println("STATE : "+ StatesApp.playingState);
            System.out.println("running on PLAYING");
            
          
            
            switch(numVidas){
                
                case 7:
                    if(!b7){
                        initPanelAhorcado(0);
                        b7=true;
                    }
                    
                    break;
                case 6:
                   
                    if(!b6){
                         p1.remove(panelImagenAhorcado);
                initPanelAhorcado(1);
                        b6=true;
                    }
                    break;
                case 5:
                    
                    if(!b5){
                        p1.remove(panelImagenAhorcado);
                initPanelAhorcado(2);
                        b5=true;
                    }
                    break;
                case 4:
                    
                    if(!b4){
                        p1.remove(panelImagenAhorcado);
                initPanelAhorcado(3);
                        b4=true;
                    }
                    break;
                case 3:
                    
                    if(!b3){
                       p1.remove(panelImagenAhorcado);
                initPanelAhorcado(4);
                        b3=true;
                    }
                    break;
                case 2:
                    
                    if(!b2){
                        p1.remove(panelImagenAhorcado);
                        initPanelAhorcado(5);
                        b2=true;
                    }
                    break;
                
                case 1: 
                    
                    if(!b1){
                        p1.remove(panelImagenAhorcado);
                        initPanelAhorcado(6);
                        b1=true;
                    }
                
                
                
            }
            
            
           
    }

        
        // *******
            // STARTS HERE
        //********
         
    }

  @Override
    public void actionPerformed(ActionEvent ae) {
            Object origen = ae.getSource();
                if(origen == this.goHome){
                    number=0;
                    gameThread=null;
                    
                  StatesApp.gameState=MENU;
                 
                  System.out.println("action MENU,  (from PLAYING)");

               }else if(origen == this.giveLetter){
                   p1.setBackground(new Color(0x911111));
                   //TODO_ ----> ayuda: revelar una letra al azar
                   
                   // NECESITO TENER; REVISAR LA PALABRA, TOMAR UNA LETRA AL AZAR, LLENAR EL CAMPO,CORREPSONDIENTE.
                   // BOOLEAN para dar 1 sola oportunidad (o 2,3)
                   if (ayudaLeftt && StatesApp.playingState== NOT_DONE){
                        ayudarConLetra();                 
                   }
                      
                   System.out.println("action HELP (from PLAYING)");
               }else if(origen == this.giveWord){
                   
                   if (ayudaLeftt && StatesApp.playingState== NOT_DONE){
                            wasHelp=true;
                            ayudarConPalabra();  
                            System.out.println("AYODAR PALABRA");
                            
                           
                   }
               }
               
               
                else if(origen == this.changeWord){
                   p1.setBackground(new Color(0x91a211));
                   removeJTextandJLabel();
                   StatesApp.playingState=DONE;
               }
                for(int i=0; i<NUM_BOTTONS; i++){
                    if(origen == teclado[i]){
                   String txt=null;
                   String label=null;
                   txt = teclado[i].getText();
                   boolean pasa= verificarLetra(txt);
                   if(String.valueOf(teclado[i].getText()).equals("*")){
                       break;
                   }
                   else if(pasa){
                        addLetterToText(txt,indiceDeLetra);
                        teclado[i].setText("*");
                        teclado[i].setIcon(tecladoBlue[i]);
                   }
                   else{
                       numVidas--;
                       teclado[i].setText("*");
                       teclado[i].setIcon(tecladoRed[i]);
                       label=String.valueOf(numVidas);
                       labelVIdas.setText(label);
                   
                  

                       
                       System.err.println("NUm vidas:"+ numVidas);
                       if(numVidas==0){
                           
                           setGlass();
                           
                          
                           Container glassPane= (Container) getRootPane().getGlassPane();
                           
                           JButton b= new JButton("PERDISTE");
                           b.setBounds(150,300,100,100);
                           glassPane.add(b);
                           
                           
                           JLabel J = new JLabel(getIconButton(1));
                           J.setBounds(100,100,50,50);
                           glassPane.add(J);
                           
                           JTextField T= new JTextField(palabra);
                           T.setBounds(150,550,100,100);
                           Color c= new Color (0,0,0,0);
                           T.setBorder(null);
                           T.setBackground(c);
                           glassPane.add(T);
                           
                                   glassPane.setVisible(true);
                                   System.out.println("VISIBLEE");
                           
                        
                                    StatesApp.playingState=LOST;
                           
                           
                           
                           
                       }
                   }
                        System.out.println("LETRA OPRIMIDA: "+ txt);
                        System.out.println("action TECLADO (from PLAYING)");
               }

                }
                
    }
    
private void setGlass(){
     getRootPane().setGlassPane(new JComponent() {
                               @Override
                               protected void paintComponent(Graphics g) {
                                   System.out.println("KKKKKKKKK");
                                   g.setColor(new Color (0,0,0,150));
                                   g.fillRect(0, 0, WIDTHP, HEIGHTP);
                                   super.paintComponent(g);
                                   
                                   
                                   
                               }
                           
                          
                               
                               
                           });
}
    
    
    
    
}
