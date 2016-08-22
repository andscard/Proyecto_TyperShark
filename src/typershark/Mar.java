/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Buceador;
import Pez.Tiburon;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Mar {
     private BorderPane panel_mar;
     private ImageView fondo;
     private Tiburon tiburon;
     private Buceador buceador;
     private VBox vbox1;
     private Pane panel_peces_buceador;

     
    // private 
     
    public Mar(){
    panel_mar=new BorderPane();
    tiburon=new Tiburon();
    buceador= new Buceador("");
    panel_peces_buceador=this.setPanelPeces();
    panel_mar.setCenter(panel_peces_buceador);
    panel_mar.setRight(vbox1);
    
        }
    
    public Pane setPanelPeces(){
    this.panel_peces_buceador=new Pane();
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/mar.jpg"))); 
    panel_peces_buceador.getChildren().addAll(fondo,this.tiburon.getImagenTiburon(),buceador.getImagenBuceador());
    //this.tiburon
    
        return panel_peces_buceador;
    }
    
    
    public BorderPane getMar(){
    return this.panel_mar;}
   
}
