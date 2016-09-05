/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Clase Tiburón, es una sulclase de la clase Pez
 * Contiene una imagen representativa del tiburón y el método que permite verla
 * @author Mayken Salvarría
 * @author Andrea Cárdenas
 */
public class Tiburon extends Pez {
    private ImageView imagen_tiburon;
    
    /**
    * Constructor de la clase Tiburon
    */
    public Tiburon(int puntos, double velocidad,double x, double y, String palabra){
       super(puntos,velocidad,x,y,palabra);
       this.imagen_tiburon=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/shark.png"), 170, 170, true, true));
       this.set_image(this.imagen_tiburon);
    }
    
    /**
     * El Método getImagenTiburon retorna la imagen característica del tiburon
     * @return imagen tiburón tipo ImageView
     */
    public ImageView getImagenTiburon(){
    return this.imagen_tiburon;}
    
}
