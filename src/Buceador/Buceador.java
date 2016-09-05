/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import Utils.Posicion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Mayken
 */
public class Buceador extends Thread implements Comparable<Buceador> {
     private String nombre;
    private int vidas;
    private int puntaje;
    private double metros;
    private boolean arma_especial;
    private Posicion posicion;
    private ImageView imagen_buceador;
    private Pane pane;
    
    
    public Buceador(String nombre){
    this.pane= new Pane();    
    this.nombre=nombre;
    this.vidas=3;
    this.puntaje=0;
    this.arma_especial=false;
    this.posicion=new Posicion(0,10);
    this.metros=0;
    this.imagen_buceador=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/buceador.png"),80,120,true,true));
    this.pane.getChildren().addAll(imagen_buceador);
    this.pane.setLayoutX(posicion.getPos_x());
    this.pane.setLayoutY(posicion.getPos_y());
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = this.vidas+vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntos) {
        this.puntaje = this.puntaje+puntos;
    }

    public boolean isArma_especial() {
        return arma_especial;
    }

    public void setArma_especial(boolean arma_especial) {
        this.arma_especial = arma_especial;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public double getMetros() {
        return metros;
    }
    
    
     public Pane getPane(){
            return this.pane;
    }
    
    public ImageView getImagenBuceador(){
    return this.imagen_buceador;}
    
    public String infoJugadorPuntaje(){
  
    String info=this.nombre+" "+this.puntaje;
    return info;
    }
    
    

    @Override
    public int compareTo(Buceador b1) {
    if (this.puntaje<b1.puntaje){
        return 1;
    }else if(this.puntaje>b1.puntaje){
        return -1;
    }else{
        return 0;}   
    }
    
    
    @Override
    public void run(){
        while(true){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    pane.setTranslateY(pane.getTranslateY()+5);
                    
                  System.out.println(pane.getTranslateY());
                  metros+=1;
                  System.out.println(metros);
                }

               });
           try {
               Buceador.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    
    
    
    
    
    
   
}
