/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import Utils.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Mayken
 */
public class Buceador implements Comparable<Buceador> {
    private String nombre;
    private int vidas;
    private int puntaje;
    private boolean arma_especial;
    private Posicion posicion;
    private ImageView imagen_buceador;
    
    public Buceador(String nombre){
    this.nombre=nombre;
    this.vidas=3;
    this.puntaje=0;
    this.arma_especial=false;
    this.posicion=new Posicion(0,10);
    this.imagen_buceador=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/buceador.png"),80,120,true,true));
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
    
    
   
}
