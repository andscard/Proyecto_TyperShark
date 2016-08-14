/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author User
 */
public class BuceadorFX {
     private ImageView imagen_buceador;
    private Buceador buceador;
    
    public BuceadorFX(String nombre){
    this.imagen_buceador=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/buceador.png"),80,120,true,true));
    this.buceador=new Buceador(nombre);
    }
    
    public ImageView getImagenBuceador(){
    return this.imagen_buceador;}
    
    
}
