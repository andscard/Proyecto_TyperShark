/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import Utils.Posicion;

/**
 *
 * @author Mayken
 */
public class Buceador {
     private String nombre;
    private int vidas;
    private int puntaje;
    private boolean arma_especial;
    private Posicion posicion;
    
    public Buceador(String nombre){
    this.nombre=nombre;
    this.vidas=3;
    this.puntaje=0;
    this.arma_especial=false;
    posicion=new Posicion(0,10);
    }
   
}
