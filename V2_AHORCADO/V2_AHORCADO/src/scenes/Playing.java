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
    public JPanel p1,p2,p3,p4,p5,p6, panelImagenAhorcado;

    private static final int WIDTHP=400;
    private static final int HEIGHTP=680;
    
    private static final int NUM_BOTTONS=27;
    
    private JButton []teclado= new JButton[NUM_BOTTONS];
    //private String randomWord;  
    private JPanel panelCategory;
    private JTextField[] letraText;
    private JLabel[] labelRayas;
    private ImageIcon imageABC;

    private    ImageIcon imageRaya;
    
     private  Datos datosJUGAR = MainAPP.getInstance3();  
    
    private int letraAlAzar;
    
    private int numVidas=6;
    
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
    
    private boolean b1,b2,b3,b4,b5,b6 = false;
    
    
    public Playing(){
       
        System.err.println("CONSTRUCTOR PLAYING");
        
        
        pathAhorcado= new File("./src/resources/ahorcado.jpg");  
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
        p1.add(p5);
        p1.add(p6);
        p2.add(panelCategory);
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
            fileA = new File("./src/resources/ahorcado.jpg");
            buffA= loadSpreadSheet(fileA);
            iconA= getIconAHORCADO(2, 1, buffA);
            
            imageAhorcado = new ImageIcon[6];
                imageAhorcado[0] = getIconAHORCADO(0, 0, buffA);
                imageAhorcado[1] = getIconAHORCADO(1, 0, buffA);
                imageAhorcado[2] = getIconAHORCADO(2, 0, buffA);         
                imageAhorcado[3] = getIconAHORCADO(0, 1, buffA);
                imageAhorcado[4] = getIconAHORCADO(1, 1, buffA);
                imageAhorcado[5] = getIconAHORCADO(2, 1, buffA);
            
      
    }
    
    
           private void initPanels(){
            

            p1= new JPanel();
            p2= new JPanel();
            p3= new JPanel();
            p4= new JPanel();
            p5= new JPanel();
            p6= new JPanel();

            panelCategory= new JPanel();
            panelCategory.setBounds(250, 0, 140,35);
            panelCategory.setBackground(Color.gray);


            p1.setBounds(0, 0, WIDTHP, 250);
            p1.setBackground(Color.black);
           
            p2.setBounds(0, 250, WIDTHP, 150);
            p2.setBackground(Color.white);
            
            
            
            p3.setBounds(0, 400, WIDTHP, 200);
            p3.setBackground(Color.darkGray);
            p4.setBounds(0, 600, WIDTHP, 100);
            p4.setBackground(Color.yellow);
            p5.setBounds(140,0, 50, 40);
            p5.setBackground(Color.blue);
            p6.setBounds(320,50, 80, 35);
            p6.setBackground(Color.blue);
            
            
            
            
            
            initA();
            
             p1.setLayout(null);
            
           

        }
           private void initPanelAhorcado(int n){
               
            labelA= new JLabel(imageAhorcado[n]);
            panelImagenAhorcado= new JPanel();    
            panelImagenAhorcado.setBounds(35, 47, 220, 150);
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
    
        private ImageIcon getIconAHORCADO(int x, int y, BufferedImage bf){
            
            ImageIcon im;
            
            BufferedImage subImage;
            
            subImage= bf.getSubimage(x*190, y*210, 220, 150);
            
            im= new ImageIcon(subImage);
            
            return im;
            
        }
         private ImageIcon getIconDEFAULT(int fotoCol, int fotoFil, BufferedImage ig) {

                ImageIcon img;
                BufferedImage sub;
                sub=ig.getSubimage(fotoCol*32, fotoFil*30, 30, 30);
                img = new ImageIcon(sub);
                return img;


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

             pathD= new File("./src/resources/spriteABC.png");
            // pathB= new File("./src/resources/spriteABC.png");
             BufferedImage buffImg = loadSpreadSheet(pathD);


            for(int i=0; i<27; i++){
                 imageABC= getIconDEFAULT(fotoCol, fotoFil, buffImg);

                teclado[i]= new JButton();
                teclado[i].addActionListener(this);
                teclado[i].setSize(35, 35); 
                digit= (char) letra;
                num= String.valueOf(digit);
                teclado[i].setIcon(imageABC);
                teclado[i].setText(num);
               
                  teclado[i].setFont(new Font("Sans Serif", Font.PLAIN, 0));
                letra++;
                fotoCol++;

                if(fotoCol==10 || fotoCol == 19){
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
            
            labelRayas[i].setBounds(20*columna, fila * 50 +35, 30 , 3);
             letraText[i].setBounds(20*columna, fila*50, 30, 30);
            
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
        
        
        System.out.println("--------RAYAS Y CAJAS DIBUJADAS ---------");
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
        boolean itsDone=itsDone();
        
        while(gameThread != null){
        
        if(StatesApp.playingState==DONE){
            
            palabra=drawRandomWord();
            p2.revalidate();
            p2.repaint();
            numeroLetrasRandom= numeroLetras;
            setVariablesOfWord();
            StatesApp.playingState=NOT_DONE;
            System.err.println("   TABLERO PINTADO -----");
        }

        if(itsDone){
            StatesApp.playingState=DONE;
            System.out.println("THE WORD HAS BEEN COMPLETED #2");
           
        }
        
            System.out.println("STATE : "+ StatesApp.playingState);
            System.out.println("running on PLAYING");
            
            
            
            switch(numVidas){
                
                case 6:
                    if(!b6){
                        initPanelAhorcado(0);
                        b6=true;
                    }
                    
                    break;
                case 5:
                   
                    if(!b5){
                         p1.remove(panelImagenAhorcado);
                initPanelAhorcado(1);
                        b5=true;
                    }
                    break;
                case 4:
                    
                    if(!b4){
                        p1.remove(panelImagenAhorcado);
                initPanelAhorcado(2);
                        b4=true;
                    }
                    break;
                case 3:
                    
                    if(!b3){
                        p1.remove(panelImagenAhorcado);
                initPanelAhorcado(3);
                        b3=true;
                    }
                    break;
                case 2:
                    
                    if(!b2){
                       p1.remove(panelImagenAhorcado);
                initPanelAhorcado(4);
                        b2=true;
                    }
                    break;
                case 1:
                    
                    if(!b1){
                        p1.remove(panelImagenAhorcado);
                        initPanelAhorcado(5);
                        b1=true;
                    }
                    break;
                
                
                
            }
            
    }

        
        // *******
            // STARTS HERE
        //********
         
    }

  @Override
    public void actionPerformed(ActionEvent ae) {
            Object origen = ae.getSource();
                if(origen == this.goMenu){
                    number=0;
                    gameThread=null;
                    
                  StatesApp.gameState=MENU;
                 
                  System.out.println("action MENU,  (from PLAYING)");

               }else if(origen == this.btnHELP){
                   p1.setBackground(new Color(0x911111));
                   //TODO_ ----> ayuda: revelar una letra al azar
                   
                   // NECESITO TENER; REVISAR LA PALABRA, TOMAR UNA LETRA AL AZAR, LLENAR EL CAMPO,CORREPSONDIENTE.
                   // BOOLEAN para dar 1 sola oportunidad (o 2,3)
                   if (ayudaLeftt && StatesApp.playingState== NOT_DONE){
                        ayudarConLetra();
                        
                   }
                      
                   System.out.println("action HELP (from PLAYING)");
               }
                else if(origen == this.options){
                   p1.setBackground(new Color(0x91a211));
               }
                for(int i=0; i<NUM_BOTTONS; i++){
                    if(origen == teclado[i]){
                   String txt=null;
                   txt = teclado[i].getText();
                   boolean pasa= verificarLetra(txt);
                   if(pasa){
                        addLetterToText(txt,indiceDeLetra);
                   }
                   else{
                       numVidas--;
                       
                     
                  

                       
                       System.err.println("NUm vidas:"+ numVidas);
                       if(numVidas==0){
                           StatesApp.gameState=MENU;
                       }
                   }
                        System.out.println("LETRA OPRIMIDA: "+ txt);
                        System.out.println("action TECLADO (from PLAYING)");
               }

                }
                
    }
    

    
    
    
    
}
