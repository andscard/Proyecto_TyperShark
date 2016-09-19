/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 * En el juego TyperShark el mar y el buceador deben estar pendientes
 * de los cambios que sucedan en el transcurso del juego.
 * La interface Subject fue implementada para conocer que sujetos deberan
 * ser observados durante el juego, ya que de ellos depende la finalización 
 * del mismo.
 * @author Sheyla Cárdenas Sumba
 * @author Mayken Salavarría Tutivén
 * 
 * @version 2.0.0
 * 
 */

public interface Subject {
    /**
     * El método addObserver permiter añadir un observador
     * @param o tipo Observer
     */
   public void addObserver( Observer o );
    /**
     * El método removeObserver permiter eliminar un observador
     * 
     */
      public void removeObserver( Observer o );   
}
