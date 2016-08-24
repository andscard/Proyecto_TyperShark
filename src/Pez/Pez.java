/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import Utils.Palabra;
import Utils.Posicion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mayken
 */
public class Pez extends Thread{
    
    private int puntos;
    private double velocidad;
    private Estado estado;
    private enum Estado{VIVO,MUERTO};
    private Pane pane;
    private Label label;
    private Posicion posicion;
    private String palabra;
    
    
    public Pez( int puntos, double velocidad,double x, double y, String palabra) {
        this.palabra=palabra;
        this.posicion=new Posicion(x,y);        
        this.puntos = puntos;
        this.velocidad = velocidad;
        this.estado=Estado.VIVO;
        this.pane= new Pane();
        label=new Label(palabra);
        pane.getChildren().addAll(label);
        this.pane.setLayoutX(posicion.getPos_x());
        this.pane.setLayoutY(posicion.getPos_y());
        
    }


    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }
    
     public Pane getPane(){
            return this.pane;
    }
    
    
    @Override
    public void run(){
        while(true){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    pane.setTranslateX(pane.getTranslateX()-2 );
                }

               });
           try {
               Tiburon.sleep(200);
           } catch (InterruptedException ex) {
               Logger.getLogger(Pez.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    
    
    
    
    
    
}
