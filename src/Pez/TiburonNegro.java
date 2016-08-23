/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Mayken
 */
public class TiburonNegro extends Pez{
    private int num_palabras;
    private ImageView imagen_tiburonNegro;
    
    public TiburonNegro(int puntos, double velocidad,double x, double y, String palabra){
    super(puntos,velocidad,x,y, palabra);
    this.imagen_tiburonNegro=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/tiburon_negro.png"),250,100,true,true));
    this.num_palabras=(int)Math.random()*3+2;}
    
    public ImageView getImagenTiburonNegro(){
    return this.imagen_tiburonNegro;}
    
    public int num_Palabras(){
        return this.num_palabras;}

    
}
