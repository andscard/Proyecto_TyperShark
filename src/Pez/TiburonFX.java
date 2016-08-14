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
 * @author User
 */
public class TiburonFX {
    private ImageView imagen_tiburon;
    private Tiburon tiburon;
   
    public TiburonFX(){
    this.imagen_tiburon=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/shark.png"), 200, 150, true, true));  
    }
    
    public ImageView getImagenTiburon(){
    return this.imagen_tiburon;}
    
}
