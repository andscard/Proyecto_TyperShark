/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Mayken
 */
public class Palabra{
    String palabra;
     Label []label;
     
     
    public Palabra(String palabra) {
        this.palabra = palabra;
        this.llenarArregloLabels();
        
    }
     
    
    public int  getPalabra() {
        return palabra.length();
    }

    
    public Label[] getLabel() {
        return label;
    }
   

    
    
        
    public void llenarArregloLabels(){
         label= new Label[this.palabra.length()];
         String pal;         
         for( int i=0;i<palabra.length();i++){
             pal=String.valueOf(palabra.charAt(i));
              label[i]=new Label(pal);  
              label[i].setFont(new Font("Arial", 20));
              label[i].setTextFill(Color.BLUE);
             
            }
    }
    
    public void cambiarColorLetras( int posicion ){
                 label[posicion].setTextFill(Color.GREEN);
          
    }
    
    
    
    public HBox arregloLabels(){
         HBox palabra = new HBox();
         palabra.getChildren().addAll(label);
                 
         
         return palabra;
    }
        
         
    
  
    
}