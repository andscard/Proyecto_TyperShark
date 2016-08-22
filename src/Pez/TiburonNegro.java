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
    private ImageView imagen_tiburonNegro;
    
    public TiburonNegro(){
    super(25,50,(int)Math.random()*3+2);
    this.imagen_tiburonNegro=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/tiburon_negro.png"),250,100,true,true));}
    
    public ImageView getImagenTiburonNegro(){
    return this.imagen_tiburonNegro;}

    
}
