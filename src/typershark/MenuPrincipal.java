/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Formulario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class MenuPrincipal {
    private Pane panel;
    private ImageView fondo;
    private VBox vbox;
    private Mar mar;
    private Formulario formulario;
    private Ayuda ayuda;
    Stage stage1,stage2;
    Stage stage_menu;
    
    public MenuPrincipal(){
    panel= new Pane();
    mar=new Mar();
    formulario=new Formulario();
    ayuda= new Ayuda();
    stage1= formulario.crearStage();
    stage2= ayuda.crearStage();
    stage_menu=new Stage();
    vbox = this.createVbox();
    Button bt_salir = new Button(" SALIR ");
    bt_salir.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
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
     Button b2 = new Button("AYUDA");
     b2.setPrefSize(150, 50);
     b2.setShape(elipse);
     b2.setOnAction(new ClickHandler2());
     Button b3 = new Button("TOP-SCORES");
     b3.setPrefSize(150, 50);
     b3.setShape(elipse);
     
     vbox.relocate(160, 215);
     vbox.getChildren().addAll(b1,b2,b3);
     
        return vbox;
    }
     
    
    public Pane getMenuPrincipal(){
        return this.panel;}
    
    public Stage getStageMenu(){
      Scene scene1 = new Scene(this.getMenuPrincipal());
      stage_menu.setTitle("Typer Shark");
      stage_menu.getIcons().add(new Image("/Imagenes/tiburon.png"));
      stage_menu.setResizable(true);
      stage_menu.setScene(scene1);
    
    return this.stage_menu;}
    
    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            Platform.exit();
        }
    }
    
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
        stage1.show();
        
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        }
    }
    
    private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage2.show();
        }
    }
    
    
}
