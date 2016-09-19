/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pez;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**La clase Pulpo, hija de la clase Pez almacena la función de devolver
 * la imagen de un pulpo.
 *
 * @author Andrea Cárdenas Sumba
 * @author Mayken Salavarría Tutivén
 * 
 * versión 1.0.0
 */
public class Pulpo extends Pez {
    private ImageView imagen_pulpo;
   
    /**
     * Constructor de la Clase Pulpo, asigna puntos, velocidad, su posicion
     * en la coordenada x, su posicion en la coordenada y  su palabra.
     * @param puntos tipo de dato entero
     * @param velocidad tipo de dato double
     * @param x tipo de dato double
     * @param y tipo de dato double
     * @param palabra tipo ArrayList String
     */
    public Pulpo(int puntos, double velocidad,double x, double y, ArrayList<String> palabra){
      
       super(puntos,velocidad,x,y,palabra);
     //  ArrayList<String> palabra_pulpo=new ArrayList();
     //  palabra_pulpo.add(palabra);
     //  this.addAListaPalabras(palabra);
       this.imagen_pulpo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/pulpo.png"), 250, 250, true, true));
       this.set_image(this.imagen_pulpo);
       
    }
    
    /**
     * El Método getImagenPulpo retorna la imagen característica de un pulpo.
     * @return imagen_pulpo tipo ImageView
     */
    public ImageView getImagenPulpo(){
    return this.imagen_pulpo;}
    
    
}
