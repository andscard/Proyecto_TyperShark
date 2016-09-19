/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 * La Clase Posicion almacena funciones útiles como:  conocer, actualizar una 
 * posicion
 * 
 * @author Mayken Salavarría Tutivén
 * @author Andrea Cárdenas Sumba
 * 
 * @version 2.0.0
 * 
 */

public class Posicion {
     private double pos_x;
    private double pos_y;
   /**
    * Constructor de la clase Posicion, asigna posiciones en la coordenada X
    * y la coordenada Y
    * @param x tipo double
    * @param y tipo double
    */ 
    public Posicion(double x, double y){
    this.pos_x=x;
    this.pos_y=y;}

    /**
     * EL método getPos_x() retorna la posicion en la coordenada X.
     * @return pos_x tipo double
     */
    public double getPos_x() {
        return pos_x;
    }

    
    /**
     * El método getPos_x() permite actualizar la posicion en la coordenada X.
     * 
     */
    public void setPos_x(double pos_x) {
        this.pos_x = pos_x;
    }

    
    /**
     * El método getPos_y() retorna la posicion en la coordenada Y.
     * @return pos_y tipo double
     */
    public double getPos_y() {
        return pos_y;
    }

     /**
     * El método getPos_y() permite actualizar la posicion en la coordenada Y.
     * 
     */
    public void setPos_y(double pos_y) {
        this.pos_y = pos_y;
    }
    
}
