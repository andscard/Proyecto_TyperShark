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
    //    boton.setOnAction(new ClickHandler());
        vbox.getChildren().addAll(label,text,boton);
        //panel.setStyle("-fx-background-color: #A9D0F5;");
        fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo1.jpg"),900,600,true,true));
        panel.getChildren().addAll(fondo,vbox);
    }
    
    public Pane getFormulario(){
    return this.panel;}
    
    public String getNombre(){
    return this.nombre;}
    
    public void setNombre(String nombre){
        this.nombre=nombre;}
    
    
    public TextField getTexto() {
        return text;
    }

    public void setTexto(TextField text) {
        this.text = text;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Button getBoton() {
        return boton;
    }

    public void setBoton( Button boton) {
        this.boton = boton;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public ImageView getFondo() {
        return fondo;
    }

    public void setFondo(ImageView fondo) {
        this.fondo = fondo;
    }
   
    
    
  
    
}
