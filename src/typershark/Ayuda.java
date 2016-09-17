/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Ayuda {
    private Pane panel;
    private Stage stage;
    private Button boton;
    private ImageView fondo;

    public Ayuda(){
        this.stage= new Stage();
        this.panel=new Pane();
        this.boton=new Button(" SALIR ");
        boton.setTranslateX(780);
        boton.setTranslateY(550);
        boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        boton.setOnAction(new ClickHandler());
        fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoayuda4.jpg"),900.30,891.20,true,true));
        panel.getChildren().addAll(fondo,boton);
    }
    
    public Pane getAyuda(){
    return this.panel;}
    
    public Stage crearStage(){
        Scene scene1 = new Scene(this.getAyuda());
        stage.setTitle("TyperShark Help");
        stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
     return this.stage;}
    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage.close();
        }
    }
    
}
