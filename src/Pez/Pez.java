/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import Utils.Palabra;

/**
 *
 * @author Mayken
 */
public class Pez {
    private String []lista_palabra;   
    private Palabra palabra;
    private int puntos;
    private double velocidad;
    private final Estado estado;
    private enum Estado{VIVO,MUERTO};

    public Pez( int puntos, double velocidad, int n) {
        this.lista_palabra = new String[n];
        this.palabra = new Palabra();
        this.puntos = puntos;
        this.velocidad = velocidad;
        this.estado=Estado.VIVO;
    }

    public String[] getLista_palabra() {
        return lista_palabra;
    }

    public void setLista_palabra(String[] lista_palabra) {
        this.lista_palabra = lista_palabra;
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
    
    
    
    
}
