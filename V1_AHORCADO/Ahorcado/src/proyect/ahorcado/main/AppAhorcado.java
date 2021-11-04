/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect.ahorcado.main;

import proyecto.ahorcado.view.UxAhorcado;

/**
 *
 * @author kaliw
 */
public class AppAhorcado {
    static UxAhorcado ux;
    
    public static void main(String[] args) {
        ux= UxAhorcado.getInstance();
        
    }
    
}
