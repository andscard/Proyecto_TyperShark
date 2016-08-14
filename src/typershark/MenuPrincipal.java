/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author User
 */
public class MenuPrincipal {
    private Pane panel;
    private ImageView fondo;
    private VBox vbox;
    private Integer cambio=null;
    
    public MenuPrincipal(){
    panel= new Pane();
    vbox = this.createVbox();
    Button bt_salir = new Button("SALIR");
    bt_salir.relocate(600, 425);
    bt_salir.setOnAction(new ClickHandler());
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo9.jpg")));
    panel.getChildren().addAll(fondo,vbox,bt_salir);
    }
    
     public VBox createVbox(){
     vbox = new VBox(20);
     Ellipse elipse=new Ellipse(100,25);
     Button b1 = new Button("JUGAR");
     b1.setPrefSize(150, 50);
     b1.setShape(elipse);
     b1.setOnAction(new ClickHandler1());
     Button b2 = new Button("INSTRUCCIONES");
     b2.setPrefSize(150, 50);
     b2.setShape(elipse);
     Button b3 = new Button("TOP-SCORES");
     b3.setPrefSize(150, 50);
     b3.setShape(elipse);
     
    
     //vbox.setPadding(new Insets(15));
     //vbox.setPrefWidth(100);
     vbox.relocate(160, 215);
     vbox.getChildren().addAll(b1,b2,b3);
     //b1.setOnAction(new ClickHandler1()); 
     //b2.setOnAction(new ClickHandler2()); 
     
        return vbox;
    }
     
    public Integer getCambio(){
        return this.cambio;}
    
    public Pane getMenuPrincipal(){
        return this.panel;}
    
    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            Platform.exit();
        }
    }
    
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
          cambio=new Integer(1);  
          System.out.println(cambio);
        }
    }
    
}
