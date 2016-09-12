/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import Utils.ArreglosPalabras;
import Utils.Palabra;
import Utils.Posicion;
import java.util.ArrayList;
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
public class Pez extends Thread{
    
    private int puntos;
    private double velocidad;
    private Estado estado;
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
     * El método set_image recibe como parámetro una Imagen de un tipo de pez, está será
     * ubicada en el panel junto con la palabra respectiva.
     * @param imagen tipo ImageView
     */
    public void set_image(ImageView imagen){
    this.imagen=imagen;
    this.imagen.toBack();
    this.pane.getChildren().addAll(this.imagen,this.pane_palabra);
    this.pane_palabra.toFront();
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

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public void addAListaPalabras(String word){
    this.lista_words.add(word);
    }
    
    public void setListaPalabras(ArrayList <String> lista_words){
        this.lista_words=lista_words;
    } 
    
    
    
    /**
     *  El método setEstado, cambia el estado de VIVO A MUERTO
     * 
     */
    public void setEstado(){
    this.estado=Estado.MUERTO;}
    
    public Estado getEstado(){
    return this.estado;}

    /**
     * El método getVelocidad retorna la velocidad (pixeles a moverse)
     * de cada pez
     * @return velocidad tipo decimal.
     */
    public double getVelocidad() {
        return velocidad;
    }

    
    /**
     * El método setVelocidad, modifica la velocidad del pez cuando un caracter
     * ha sido mal escrito o cuando existe un cambio de nivel.
     * @param velocidad tipo de dato entero
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
    /**
     * El método getPosicion nos permite conocer la posicion actual de un Pez.
     * @return posicion tipo Posicion 
     */
    public Posicion getPoscion (){
        return this.posicion;}
    
    
    /**
     * El método getPane nos devuelve el panel de un pez.
     * @return pane tipo Pane
     */    
    
     public Pane getPane(){
            return this.pane;
    }
     
   /**
     public boolean pezDentroDelMar() {
        boolean en_el_mar;
        if (pane.getTranslateX() <= -740) {
            posicion.setPos_x(-740);
            pane.setVisible(false);
            return en_el_mar=false;
        }else{
            return en_el_mar=true;
        }
     }
    
    **/
     
     /**
    @Override
    public void run(){
        
            while(!stop){
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                       
                            pane.setTranslateX(pane.getTranslateX()-velocidad );
                            System.out.println(pane.getTranslateX());

                           
                           // if(pezDentroDelMar()==false){    
                           // stop=true;

                            
                            if (pane.getTranslateX()==-720){
                                posicion.setPos_x(-720);
                                stop=true;
                                pane.setVisible(false);
                                
                            }
                            
                            
                            if(estado==Estado.MUERTO){
                               pane.setVisible(false);
                                stop=true;}
                        
                  // }
                    
               
                try {
                    Pez.sleep(200);
                    } catch (InterruptedException ex) {
                    Logger.getLogger(Pez.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }
                    
                });
                        }
    }
    
    **/
     
     
     
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
                                pane.setVisible(false);}
                        
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