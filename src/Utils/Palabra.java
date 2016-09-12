/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Mayken
 */
    
public class Palabra  {
    private int num_palabras;
    private ArrayList<String> palabras;
    private String palabra;
    private Label []label_letras;
    private  int posicion;
    private int estado;
   
    
    /**
     * Constructor de la clase Palabra
     * @param palabra 
     */
    
     public Palabra(ArrayList<String>palabras) {
        this.palabras = palabras;
        this.num_palabras= palabras.size();
        this.palabra = palabras.get(0);
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
  
    
    public void setPalabra(String nueva_palabra) {
         this.palabra=nueva_palabra;
    }
  
    public void cargarPalabra(int num_palabra) {
           this.setPalabra(this.palabras.get(num_palabra));
    }
  
   
    /**
     * El método getLongitudPalabra() permite conocer la longitud de la palabra
     * del Pez
     * @return longitud de la palbra tipo de dato dato
     */
    public int  getLongitudPalabra() {
        return palabra.length();
    }

    /**
     * Ek método getLabel(), permite obtener un arreglo tipo Label de 
     * del caracter o de cada una de las letras que forman la palabra del pez.  
     * @return label_letras tipo de dato Label
     */
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

    /**
     * @return the num_palabras
     */
    public int getNum_palabras() {
        return num_palabras;
    }

    /**
     * @param num_palabras the num_palabras to set
     */
    public void setNum_palabras(int num_palabras) {
        this.num_palabras = num_palabras;
    }

       
         


   
}
  
                      
    
    
  
    
