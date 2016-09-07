/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Buceador;
import Buceador.Formulario;
import Buceador.TopJugadores;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
    private Pane panel_formulario;
    private ImageView fondo;
    private VBox vbox;
    private Mar mar;
    private Formulario formulario;
    private Ayuda ayuda;
    private TopJugadores top;
    Stage stage1,stage2,stage3;
    Stage stage_menu;
    
    public MenuPrincipal(){
    panel= new Pane();
    formulario=new Formulario();
    formulario.getBoton().setOnAction(new ClickHandler4());
    
    top=new TopJugadores();
    ayuda= new Ayuda();
    
    //stage1= formulario.crearStage();
    stage2= ayuda.crearStage();
    stage3= top.crearStage();
    stage_menu=new Stage();
    vbox = this.createVbox();
    Button bt_salir = new Button(" SALIR ");
    bt_salir.setFont(Font.font("Amble CN", FontWeight.EXTRA_BOLD, 16));
    bt_salir.setStyle("-fx-base: #FA5858;");
    bt_salir.setTextFill(Color.WHITE);
    bt_salir.setPrefSize(150, 50);
    bt_salir.setShape(new Ellipse(100,25));
    bt_salir.relocate(540, 420);
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
     b1.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
     b1.setStyle("-fx-base: #b6e7c9;");
     b1.setOnAction(new ClickHandler1());
     
     Button b2 = new Button("AYUDA");
     b2.setPrefSize(150, 50);
     b2.setShape(elipse);
     b2.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
     b2.setStyle("-fx-base: #b6e7c9;");
     b2.setOnAction(new ClickHandler2());
     
     
     Button b3 = new Button("TOP-SCORES");
     b3.setPrefSize(150, 50);
     b3.setShape(elipse);
     b3.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
     b3.setStyle("-fx-base: #b6e7c9;");
     b3.setOnAction(new ClickHandler3());
     
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
        
        Scene scene2 = new Scene (formulario.getFormulario());
        stage_menu.setScene(scene2);
        
        }
        
       
    }
    
    private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage2.show();
        }
    }
    
    private class ClickHandler3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            top.escribirArchivoTop(new Buceador("Mayken"));
            top.listaTopJugadores();
            top.llenarListView();
            stage3.show();
        }
    }
    
    
     private class ClickHandler4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            formulario.setNombre(formulario.getTexto().getText());
            //stage.close();
        mar=new Mar(formulario.getNombre());   
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        //mar.start();
            
        }
     }
}
