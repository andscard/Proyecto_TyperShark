/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Mayken
 */
public class Piraña extends Pez{
     private ImageView imagen_piraña;
     
    public Piraña(int puntos, double velocidad,double x, double y, String palabra){
     super(puntos,velocidad,x,y,palabra);
    this.imagen_piraña=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/piraña.PNG"),100,140,true,true));
    this.set_image(this.imagen_piraña);}
    
    public ImageView getImagenPiraña(){
    return this.imagen_piraña;}
}
