/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.BuceadorFX;
import Pez.TiburonFX;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author User
 */
public class MarFX {
     private BorderPane panel_mar;
     private ImageView fondo;
     private TiburonFX tiburon;
     private BuceadorFX buceador;
     private VBox vbox1;
     private Pane panel_peces_buceador;

     
    // private 
     
    public MarFX(){
    panel_mar=new BorderPane();
    tiburon=new TiburonFX();
    buceador= new BuceadorFX("");
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
    
    
    public BorderPane getMarFX(){
    return this.panel_mar;}
}
