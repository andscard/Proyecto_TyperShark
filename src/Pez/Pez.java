/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import Utils.ArreglosPalabras;
import Utils.Palabra;
import Utils.Posicion;
import Utils.Subject;
import java.util.ArrayList;
import java.util.Iterator;
import Utils.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * La Clase Pez almacena funciones útiles como obtener y modificar puntos (Valor de cada pez), 
 * velocidad,estado del pez,posicion.
 * @author Mayken Salavarría Tutivén
 * @author Andrea Cárdenas Sumba
 * 
 * @version 2.0.0
 * 
 */
public class Pez extends Thread implements Subject{
    
    private int puntos;
    private double velocidad;
    private Estado estado;
    private ArrayList observers = new ArrayList();
   
    /**
     * Este método permite añadir a un observador
     * @param o tipo Observer
     */
    @Override
    public void addObserver( Observer o ) {
            observers.add( o );
      }
    /**
     * Este método permite eliminar un Observador
     * @param o 
     */
      @Override
      public void removeObserver( Observer o ) {
            observers.remove( o );
      }
      
      
      /**
       * El método  notifyObservers_pezllegafinal() , le notifica 
       * al observador que el pez ha pasado su zona límite.
       */
      public void notifyObservers_pezllegafinal() {
            // loop through and notify each observer
            Iterator i = observers.iterator();
            while( i.hasNext() ) {
                  Observer o = ( Observer ) i.next();
                  o.update( this , "pez_llega");
            }
      }
      
      /**
       * El método  notifyObservers_pezmuere(), le notifica 
       * al observador que el pez ha sido eliminado, y por ende debe 
       * aumentar puntos.
       */
    public void notifyObservers_pezmuere() {
            // loop through and notify each observer
            Iterator i = observers.iterator();
            while( i.hasNext() ) {
                  Observer o = ( Observer ) i.next();
                  o.update( this , "pez_muere");
            }
      }
    
   

    

   

   
    public enum Estado{VIVO,MUERTO};
    private Pane pane;
    private HBox  pane_palabra;
    private ImageView imagen;
    private Posicion posicion;
    public Palabra palabra;
    public ArrayList<String> lista_words;
    private boolean stop=false;
    
    /**
    * Constructor de la clase Pez asigna la cantidad de puntos, velocidad
    * posicion en x y y y una palabra.
    * @param puntos tipo entero
    * @param velocidad  tipo double
    * @param x  tipo double
    * @param y  tipo double
    * @param palabra  tipo ArrayList<String>
    */
    
    public Pez( int puntos, double velocidad,double x, double y, ArrayList<String> lista_words) {
        this.lista_words=lista_words;
        this.palabra= new Palabra(lista_words);
        this.pane_palabra= this.palabra.panelPalabra();
        this.posicion=new Posicion(x,y);        
        this.puntos = puntos;
        this.velocidad = velocidad;
        this.estado=Estado.VIVO;
        this.pane= new Pane();
        
      
        pane_palabra.relocate(50, 35);
        this.pane.setLayoutX(posicion.getPos_x());
        this.pane.setLayoutY(posicion.getPos_y());
        
    }

    /**
     * El método getPane_palabra(), nos permite obtener el panel de la 
     * palabra del pez.
     * @return the pane_palabra
     */
    public HBox getPane_palabra() {
        return pane_palabra;
    }
   
    
    /**
     * El método set_image recibe como parámetro una Imagen de un tipo de pez, está será
     * ubicada en el panel junto con la palabra respectiva.
     * @param imagen tipo ImageView
     */
    public void set_image(ImageView imagen){
    this.imagen=imagen;
    this.imagen.toBack();
    this.pane.getChildren().addAll(this.imagen, this.getPane_palabra());
    this.getPane_palabra().toFront();
    this.pane.autosize();
        
    }
    
    /**
     * El método getPuntos retorna los puntos(valor)
     * asignado a cada pez
     * @return puntos tipo entero.
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * El método setPuntos(int puntos) permite cambiar el valor del puntaje 
     * del pez
     * @param puntos tipo entero 
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    /**
     * El método addAListaPalabras(String word) permite añadir una palabra
     * a la lista de palabras que contiene el pez.
     * @param word 
     */
    public void addAListaPalabras(String word){
    this.lista_words.add(word);
    }
    
    /**
     * El método setListaPalabras permite cambiar la lista de palabras que posea el pez
     * @param lista_words  ArrayList tipo String 
     */
    public void setListaPalabras(ArrayList <String> lista_words){
        this.lista_words=lista_words;
    } 
    
    
    
    /**
     *  El método setEstadoVida(), cambia el estado de VIVO A MUERTO
     * 
     */
    public void setEstadoVida(){
    this.estado=Estado.MUERTO;}
    
    /**
     * El método getEstado(), nos retorna el estado de vida del Pez 
     * VIVA O MUERTO
     * @return estado tipo Estado
     */
    public Estado getEstado(){
    return this.estado;}

    /**
     * El método getVelocidad() retorna la velocidad (pixeles a moverse)
     * de cada pez
     * @return velocidad tipo double.
     */
    public double getVelocidad() {
        return velocidad;
    }

    
    /**
     * El método setVelocidad(double velocidad), modifica la velocidad del pez
     * cuando un caracter ha sido mal escrito o cuando existe un cambio de nivel.
     * @param velocidad tipo de dato entero
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    /**
     * El método getPosicion(), nos permite conocer la posicion actual de un Pez.
     * @return posicion tipo Posicion 
     */
    public Posicion getPosicion (){
        return this.posicion;}
    
    /**
     * El método setPosicion(Posicion pos), permite  cammbiar la posición del
     * Pes
     * @param pos tipo Posicion
     */
    public void setPosicion(Posicion pos){
        this.posicion=pos;}
    
    /**
     * El método getPane nos devuelve el panel de un pez.
     * @return pane tipo Pane
     */    
    
     public Pane getPane(){
            return this.pane;
    }
     
     /**
      * El método run() permite transladar el panel del pez, cuando
      * el pez pasa su zona límite este debe desaparecer.
     */
      
     @Override
    public void run(){
        
            while(!stop){
                
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                       
                        
                            pane.setTranslateX(pane.getTranslateX()-velocidad );
                            System.out.println(pane.getTranslateX());
                            
                            
                                                        
                            if (pane.getTranslateX()<=-720){
                                posicion.setPos_x(-720);
                                stop=true;
                                pane.setVisible(false);
                                palabra.setEstado(-1);
                                
                                notifyObservers_pezllegafinal();
                         
                            }
                            
                            if(estado==Estado.MUERTO){
                                pane.setVisible(false);
                                stop=true;
                            }
                        
                    }
                    
                });
                try {
                    Pez.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pez.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
      
    }
    
    

}
