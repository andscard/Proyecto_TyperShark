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
    
public class Palabra  {
    private String palabra;
    private Label []label_letras;
    private  int posicion;
    private int estado;
   
    
    /**
     * Constructor de la clase Palabra
     * @param palabra 
     */
    
     public Palabra(String palabra) {
        this.palabra = palabra;
        this.posicion=0;
        this.estado=0;
        this.llenarArregoLetras();
        
        
    }
   
    
     public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
  
    
    public String getPalabra() {
        return palabra;
    }
  

    
       public int  getLongitudPalabra() {
        return palabra.length();
    }

    public Label[] getLabel() {
        return label_letras;
    }
    
    
    
    public void llenarArregoLetras(){
         label_letras= new Label[this.palabra.length()];
         String pal;         
         for( int i=0;i<palabra.length();i++){
             pal=String.valueOf(palabra.charAt(i));
              label_letras[i]=new Label(pal);  
              label_letras[i].setFont(new Font("Arial", 20));
              label_letras[i].setTextFill(Color.YELLOW);
             
            }
    }
    
    public void cambiarColorLetras( int posicion ){
                 label_letras[posicion].setTextFill(Color.RED);
          
    }

    
    public HBox panelPalabra(){
         HBox palabras = new HBox();
         palabras.getChildren().addAll(label_letras);
         
         return palabras;
    }

    /**
     * @return posicion retorna un tipo de dato entero, indica la posicion 
     * de la letra a escribir por teclado. 
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @param posicion_actual tipo de dato entero, indica la nueva posicion
     * de la letra a presionar.
     */
    public void setPosicion(int posicion_actual) {
        this.posicion = posicion_actual;
    }

   
         


   
}
  
                      
    
    
  
    
