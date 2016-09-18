/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**La clase Piraña, hija de la clase Pez almacena la función de devolver
 * la imagen de una piraña.
 *
 * @author Andrea Cárdenas Sumba
 * @author Mayken Salavarría Tutivén
 * 
 * versión 2.0.0
 */
public class Piraña extends Pez{
     private ImageView imagen_piraña;
     
  /**
   * Constructor de la clase Piraña, asigna el numero de puntos, la velocidad,
   * su posicion en la coordenada x, en la coordenada y una letra.
   * @param puntos tipo de dato entero
   * @param velocidad tipo de dato double
   * @param x tipo de dato double
   * @param y tipo de dato double
   * @param palabra tipo ArrayList String
   */
    public Piraña(int puntos, double velocidad,double x, double y, ArrayList<String> palabra){
     super(puntos,velocidad,x,y,palabra);
    this.imagen_piraña=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/piraña2.png"),100,140,true,true));
    this.set_image(this.imagen_piraña);}
    
    /**
     * El método getImagenPiraña retorna la imagen característica de una piraña.
     * @return imagen_piraña tipo ImageView
     */
    public ImageView getImagenPiraña(){
    return this.imagen_piraña;}
}
