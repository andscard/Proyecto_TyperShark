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
 * La Clase Pez alamacena funciones útiles como obtner y modificar puntos (Valor de cada pez), 
 * velocidas,estado del pez,posicion
 * @author Mayken Salavarría
 * @author Andrea Cárdenas
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
    private boolean stop=false;
    
    /**
    * Constructor de la clase Pez asigna la cantidad de puntos, velocidad
    * posicion en x y y y una palabra.
    * @param puntos tipo entero
    * @param velocidad  tipo double
    * @param x  tipo double
    * @param y  tipo double
    * @param palabra  tipo String
    */
    public Pez( int puntos, double velocidad,double x, double y, String palabra) {
        this.palabra= new Palabra(palabra);
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    /**
     * El método set_image recibe como parámetro una Imagen, está será
     * ubicada en el panel junto con la palabra respectiva del pez
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

    /**
     * El método getVelocidad retorna la velocidad (pixeles a moverse)
     * de cada pez
     * @return veloidad tipo decimal.
     */
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    /*
    public void setLabel(String word){
    this.label.setText(word);}
    */
    public Posicion getPoscion (){
        return this.posicion;}
    
     public Pane getPane(){
            return this.pane;
    }
    
    
    @Override
    public void run(){
        
            while(!stop){
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                       
                            pane.setTranslateX(pane.getTranslateX()-velocidad );
                            System.out.println(pane.getTranslateX());
                            
                            if (pane.getTranslateX()==-720){
                                posicion.setPos_x(-720);
                                stop=true;
                                pane.setVisible(false);
                                
                            }
                            
                            if(estado==Estado.MUERTO){
                            stop=true;}
                        
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
