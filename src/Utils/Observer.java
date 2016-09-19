/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Pez.Pez;

/**
 * En el juego TyperShark el mar y el buceador deben estar pendientes
 * de los cambios que sucedan en el transcurso del juego.
 * La interface Observer fue implementada para que conocer y analizar
 * el comportamiento de estos sujetos observados.
 * @author Sheyla Cárdenas Sumba
 * @author Mayken Salavarría Tutivén
 * 
 * @version 2.0.0
 * 
 */

public interface Observer {
    
    /**
     * El método update recibe a un sujeto observado y el evento a analizar.
     * @param o tipo Subject
     * @param evento tipo String
     */
     public void update( Subject o , String evento );

     
    
}
