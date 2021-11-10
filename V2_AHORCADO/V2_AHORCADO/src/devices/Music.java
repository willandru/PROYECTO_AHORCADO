/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author kaliw
 */
public class Music implements Runnable{
    static Music instance;
    private File file;
    private Thread thread1=null; 
    
    public Music() {
        
        thread1 = new Thread(this);
       
        
        thread1.start();
        
        
    }

    public static Music getInstance() {
        
        if (instance == null) {
            instance = new Music();
        }
        return instance;
    }
    
 

    @Override
    public void run()   {
        file= new File("/home/kaliw/GITHUB/PROYECTO_AHORCADO/V2_AHORCADO/V2_AHORCADO/src/resources/audio.wav");
        //Scanner sc = new Scanner(System.in);
        
        
        try {
            AudioInputStream audioSteram;
            audioSteram = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
             clip.open(audioSteram);
             clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (LineUnavailableException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       // String respones = sc.next();
    }
    
}
