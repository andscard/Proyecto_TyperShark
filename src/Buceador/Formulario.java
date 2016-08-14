/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Formulario extends Application{
    private Pane panel;
    private TextField text;
    private Label label;
    private Button boton;
    private VBox vbox;
    private String nombre;

    public Formulario(){
        this.panel=new Pane();
        this.label= new Label(" Usuario:");
        this.text= new TextField();
        this.boton=new Button(" GUARDAR ");
        this.vbox= new VBox(15);
        vbox.setPadding(new Insets(25));
        vbox.getChildren().addAll(label,text,boton);
        panel.getChildren().add(vbox);}
    
    private Pane getFormulario(){
    return this.panel;}
    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
        }
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene1 = new Scene(this.getFormulario());
        primaryStage.setResizable(true);
        primaryStage.setTitle("TyperShark Login");
        primaryStage.setScene(scene1);
        primaryStage.show();
        
    }
    
    
 public static void main(String[] args) {
        launch(args);
    }    
    
}
