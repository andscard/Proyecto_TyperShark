/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Clase TiburonNegro, es una subclase de la clase Pez
 * Contiene una imagen representativa del tiburón y el método que permite verla
 * @author Mayken Salavarría
 * @author Andrea Cárdenas
 * 
 * @version 2.0.0
 */
public class TiburonNegro extends Pez{
    //private int num_palabras;
    private ImageView imagen_tiburonNegro;
    
    
     /**
     * Constructor de la Clase Tiburon, asigna puntos, velocidad, su posicion
     * en la coordenada x, su posicion en la coordenada y  su palabra.
     * @param puntos tipo de dato entero
     * @param velocidad tipo de dato double
     * @param x tipo de dato double
     * @param y tipo de dato double
     * @param palabra tipo ArrayList String
     */
    public TiburonNegro(int puntos, double velocidad,double x,double y, ArrayList<String>palabras){
    super(puntos,velocidad,x,y, palabras);
    this.imagen_tiburonNegro=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/tiburon_negro.png"),250,100,true,true));
    this.set_image(this.imagen_tiburonNegro);}
    
    /**
     * El método getImagenTiburonNegro() retorna la imagen caracteristica de un Tiburon Negro
     * @return imagen_tiburonNegro tipo ImageView
     */
    public ImageView getImagenTiburonNegro(){
    return this.imagen_tiburonNegro;}
    
  
    
}
