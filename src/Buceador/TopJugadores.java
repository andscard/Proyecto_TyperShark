/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import typershark.Ayuda;

/**
 * Clase TopJugadores 
 * @author User
 */
public class TopJugadores {
    private ListView<String> lista;
    private ArrayList <Buceador> top_buceadores;
    private Pane panel;
    private Stage stage;
    private Button boton;
    private ImageView fondo;
    private ObservableList<String> nombres;
    
    public TopJugadores (){
    this.panel=new Pane();
    this.stage= new Stage();
    this.lista=new ListView<String>();
   // lista.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
    this.nombres =FXCollections.observableArrayList ();
    this.top_buceadores= new ArrayList<Buceador>(10);
    this.boton=new Button(" SALIR ");
        boton.setTranslateX(700);
        boton.setTranslateY(490);
        boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        boton.setOnAction(new ClickHandler());
        lista.setPrefWidth(150);
        lista.setPrefHeight(230);
        lista.setTranslateX(350);
        lista.setTranslateY(100);
        lista.backgroundProperty();
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoTop.jpg"),800,540,false,false));
    panel.getChildren().addAll(fondo,lista,boton);
    
    }
    

       
    public void escribirArchivoTop(Buceador buceador ){
    try{
        File file=new File ("TopJugadores.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
         
        bw.write(buceador.infoJugadorPuntaje());
        bw.newLine();
        bw.flush();
        bw.close();
            
    }catch(IOException ex){
        System.out.println("No se pudo escribir en el archivo TopJugadores.txt");}
    }
            
    public  ArrayList<Buceador> listaJugadores(){
    try {  
    File file=new File ("TopJugadores.txt");
    ArrayList<Buceador> lista_jugadores =new  ArrayList<Buceador>();
    Scanner scanner = new Scanner(file);
    Buceador b1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                b1=new Buceador(info[0]);
                b1.setPuntaje(Integer.parseInt(info[1]));
                lista_jugadores.add(b1);
            }
            Collections.sort(lista_jugadores);
            return lista_jugadores;
        } catch (IOException ex) {
            System.out.println("El archivo no existe");
            return null;
        }
    }
    
    public void listaTopJugadores(){
        ArrayList<Buceador> lista_jugadores=this.listaJugadores();
        
        if (lista_jugadores.size()<10){
            for (int i=0; i<lista_jugadores.size();i++){
            this.top_buceadores.add(lista_jugadores.get(i));
            }
        }else{
            for (int i=0; i<10;i++){
                this.top_buceadores.add(lista_jugadores.get(i));
            }
        }
    }
    
    public void llenarListView(){
    int n=this.top_buceadores.size();
        for (int i=0; i<n;i++){
        nombres.add(top_buceadores.get(i).infoJugadorPuntaje());
        this.lista.setItems(nombres);
        lista.setStyle("-fx-text-fill: black;"+
    "-fx-font: Courier New;"+
    "-fx-font-family: Courier New;"+
    "-fx-font-weight: bold;"+
    "-fx-font-size: 18;");}
    }
   
   public Pane getTopJugadores(){
   return this.panel;}
   
    public Stage crearStage(){
        Scene scene1 = new Scene(this.getTopJugadores());
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
