/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;


import static javafx.application.Application.launch;
import javafx.application.Platform;
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
import typershark.MenuPrincipal;

/**
 *
 * @author User
 */
public class Formulario {
    private Pane panel;
    private Stage stage;
    private TextField text;
    private Label label;
    private Button boton;
    private VBox vbox;
    private ImageView fondo;
    private String nombre;

    public Formulario(){
        this.stage= new Stage();
        this.panel=new Pane();
        this.label= new Label("Usuario:");
        this.text= new TextField();
        this.boton=new Button(" GUARDAR ");
        this.vbox= new VBox(15);
        vbox.setPadding(new Insets(15,48,25,55));
        label.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        boton.setTranslateX(20);
        boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        boton.setOnAction(new ClickHandler());
        vbox.getChildren().addAll(label,text,boton);
        //panel.setStyle("-fx-background-color: #A9D0F5;");
        fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo1.jpg"),280,190,true,true));
        panel.getChildren().addAll(fondo,vbox);
    }
    
    public Pane getFormulario(){
    return this.panel;}
    
    public String getNombre(){
    return this.nombre;}
    
    public Stage crearStage(){
        Scene scene1 = new Scene(this.getFormulario());
        stage.setTitle("TyperShark Login");
        stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
        stage.setScene(scene1);
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
     return this.stage;}

    

    
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            nombre=text.getText();
            stage.close();
        }
    }
    
   
    
    
  
    
}
