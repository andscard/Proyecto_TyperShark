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
import javafx.scene.input.KeyEvent;
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
    private Stage stage1,stage2,stage3;
    private Stage stage_menu;
    private Scene scene1;
    private Scene scene2;
    private Buceador buceador;
    
    
    public MenuPrincipal(){
    panel= new Pane();
    formulario=new Formulario();
    top=new TopJugadores();
    ayuda= new Ayuda();
    formulario.getBoton().setOnAction(new ClickHandler());
    scene1 = new Scene(this.getMenuPrincipal());
    scene2= new Scene (formulario.getFormulario());
    buceador=new Buceador("Anonimo");
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
    bt_salir.setOnAction(new ClickHandler5());
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo9.jpg")));
    panel.getChildren().addAll(fondo,vbox,bt_salir);
    }
    
     public VBox createVbox(){
     vbox = new VBox(15);
     Ellipse elipse=new Ellipse(100,25);
     
     
     
     Button b1 = new Button("NUEVO JUEGO");
     Button b2 = new Button("REANUDAR JUEGO");
     Button b3 = new Button("AYUDA");
     Button b4 = new Button("TOP-SCORES");
     
     this.formatoBotones(b1, elipse,new ClickHandler1());
     this.formatoBotones(b2, elipse,new ClickHandler2());
     this.formatoBotones(b3, elipse,new ClickHandler3());
     this.formatoBotones(b4, elipse,new ClickHandler4());

     vbox.relocate(160, 215);
     vbox.getChildren().addAll(b1,b2,b3,b4);
     
        return vbox;
    }
    public void formatoBotones(Button boton,Ellipse elipse,EventHandler<ActionEvent> click){
     boton.setPrefSize(150, 50);
     boton.setShape(elipse);
     boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
     boton.setStyle("-fx-base: #b6e7c9;");
     boton.setOnAction(click);
    }
     
    /**
     * 
     * @return 
     */
    public Pane getMenuPrincipal(){
        return this.panel;}
    
    public Stage getStageMenu(){
      
      stage_menu.setTitle("Typer Shark");
      stage_menu.getIcons().add(new Image("/Imagenes/tiburon.png"));
      stage_menu.setResizable(true);
      stage_menu.setScene(scene1);
    
    return this.stage_menu;}
    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
        
        formulario.setNombre(formulario.getTexto().getText());
        if (formulario.getTexto().getText().isEmpty()){
            formulario.setNombre("Anonimo");
        }
            //stage.close();
        mar=new Mar(formulario.getNombre()); 
        
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        mar.start();
        mar.getButtonRegresar().setOnAction(new ClickHandler6());
       
        }
     }
    
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
        stage_menu.setScene(scene2);
        }
    }
    
     private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
         String []info=buceador.leerArchivoPartidas();
         mar=new Mar(info[0]);
         boolean arma;
         if (info[4]=="OFF"){arma=false;
         }else{arma=true;}
        mar.getBuceador().setInfoJugador(info[0],Integer.parseInt(info[1]),Integer.parseInt(info[2]),Double.parseDouble(info[3]),
                arma,Integer.parseInt(info[5]));
       
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        mar.start();
        mar.getButtonRegresar().setOnAction(new ClickHandler6());
         
        }
     }
    
     private class ClickHandler3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage2.show();
        }
    }
    
    private class ClickHandler4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
          //  top.escribirArchivoTop(new Buceador("Mayken"));
            top.listaTopJugadores();
            top.llenarListView();
            top.llenarListJugadoresNiveles();
            stage3.show();
        }
    }
    
    
    private class ClickHandler5 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            System.exit(0);
        }
    }
    
     private class ClickHandler6 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
            stage_menu.setScene(scene1);
        }
     }
}
