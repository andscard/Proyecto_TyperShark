/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Mayken
 */
public class Piraña extends Pez{
     private ImageView imagen_piraña;
     
    public Piraña(){
     super(5,100,1);
    this.imagen_piraña=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/piraña.PNG"),80,120,true,true));}
    
    public ImageView getImagenPiraña(){
    return this.imagen_piraña;}
}
