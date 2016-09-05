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
 * @author User
 */
public class Pulpo extends Pez {
    private ImageView imagen_pulpo;
    
    /**
    * Constructor de la clase Tiburon
    */
    public Pulpo(int puntos, double velocidad,double x, double y, String palabra){
       super(puntos,velocidad,x,y,palabra);
       this.imagen_pulpo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/pulpo.png"), 250, 250, true, true));
       this.set_image(this.imagen_pulpo);
       
    }
    
    /**
     * El Método getImagenTiburon retorna la imagen característica del tiburon
     * @return imagen tiburón tipo ImageView
     */
    public ImageView getImagenPulpo(){
    return this.imagen_pulpo;}
    
    
}
