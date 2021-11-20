/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.util.Vector;

/**
 *
 * @author kaliw
 */
public class Categoria {
    
    
    Vector <String>  palabras;
    
    private String nameCategory;
    
    public Categoria(String name){
      this.palabras= new Vector<>();
      this.nameCategory= name;
      
    }
    
     public Categoria(){
      
    }
    
    public void addPalabra(String dato){
        palabras.add(dato);
    }
    
    public void printWords(){
        System.out.println(palabras);
    }

    public String getNameCategory() {
        return nameCategory;
    }
    
    public int getNumPalabras(){
        return palabras.size();
        
    }

    public Vector<String> getPalabras() {
        return palabras;
    }
    
    public String getPalabra(int indice){
        return palabras.get(indice);
    }
    
    
}
