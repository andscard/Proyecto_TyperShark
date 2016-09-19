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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    
    private ArrayList <Buceador> top_buceadores_puntajes;
    private ArrayList <Buceador> todos_los_jugadores;
    private Stage stage;
    private Stage stage_mensaje;
    private Scene scene_opciones;
    private Scene scene_top10;
    private Scene scene_escoger_niveles;
    private Scene scene_niveles;
    private TextField texto;
    private File file;
    private int nivel;
    private int nivel_maximo;
    private ArrayList<Integer> niveles;
    
    
    public TopJugadores (){
    //this.panel=new Pane();
    this.file= new File ("TopJugadores.txt");
    this.stage= new Stage();
    this.niveles= new ArrayList<Integer>();
    this.listaJugadores();
    this.top_buceadores_puntajes= this.listaTop10Puntajes();
   this.texto = new TextField();    
   this.scene_opciones=this.escenaOcpionesTop();
   this.scene_top10=escenaTopPuntaje();
   this.scene_escoger_niveles= escenaTopEscribirNivel();
   this.nivel_maximo=this.niveles.get(this.niveles.size()-1);
   System.out.println("NIVEL MAXIMO"+nivel_maximo);
   
    //panel.getChildren().addAll(fondo,lista,boton);
    
    }
    

    public Button crearButton(){
     
      Button  boton=new Button(" SALIR ");
        boton.setTranslateX(690);
        boton.setTranslateY(490);
        boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        boton.setStyle("-fx-base: #FA5858;");
        boton.setTextFill(Color.WHITE);
        boton.setOnAction(new ClickHandler());
    return boton;
    }
    
    //Devuelve una ArrayList de Buceadores ordenados por puntajes
    public  ArrayList<Buceador> listaJugadores(){
    try {  
    
    ArrayList<Buceador> lista_jugadores =new  ArrayList<Buceador>();
    Scanner scanner = new Scanner(this.file);
    Buceador b1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                b1=new Buceador(info[0]);
                b1.setNivel(Integer.parseInt(info[5]));
                this.niveles.add(Integer.parseInt(info[5]));
                b1.setPuntaje(Integer.parseInt(info[1]));
                lista_jugadores.add(b1);
            }
           Collections.sort(lista_jugadores);
           Collections.sort(niveles);
            return lista_jugadores;
        } catch (IOException ex) {
            System.out.println("El archivo no existe");
            return null;
        }
    }
    
    //Devuelve un ArrayList 10 buceadores ordenados por puntajes
    public ArrayList<Buceador> listaTop10Puntajes(){
    ArrayList<Buceador> lista_jugadores=this.listaJugadores();
    ArrayList<Buceador> top_10= new ArrayList<Buceador>();
    Buceador b;
        if (lista_jugadores.size()<10){
            for (int i=0; i<lista_jugadores.size();i++){
               b= lista_jugadores.get(i);
             
                top_10.add(lista_jugadores.get(i));
            }
        }else{
            for (int i=0; i<10;i++){
                top_10.add(lista_jugadores.get(i));
            }
        }
       return  top_10;
             /* for (int i=0; i<lista_jugadores.size();i++){
            this.top_buceadores_puntajes.add(lista_jugadores.get(i));
            }*/
        
        }
       
    //Devuelve un ArrayList 10 buceadores ordenados por nivel
    public ArrayList<Buceador> listaTop10Nivel(int nivel){
    ArrayList<Buceador> lista_jugadores=this.listaJugadores();
    ArrayList<Buceador> buceadores_nivel= new ArrayList<Buceador>();
    ArrayList<Buceador> top_10= new ArrayList<Buceador>();
    Buceador buceador;
    
    
    for (int i =0; i<lista_jugadores.size();i++){
            buceador=lista_jugadores.get(i);
            if (buceador.getNivel()==nivel){
            buceadores_nivel.add(buceador);
            }
    }
    
    if (buceadores_nivel.size()<10){
            for (int i=0; i<buceadores_nivel.size();i++){
            top_10.add(buceadores_nivel.get(i));
            }
        }else{
            for (int i=0; i<10;i++){
                top_10.add(buceadores_nivel.get(i));
            }
        }
       return  top_10;
      } 
    
    
    public void llenarListViewTopPuntaje(ListView<String> lista,ObservableList<String> nombres){
    int n=this.top_buceadores_puntajes.size();
    //nombres.add("JUGADOR    PUNTAJE");
    
    for (int i=0; i<n;i++){
       
        nombres.add(top_buceadores_puntajes.get(i).infoJugador2());
        lista.setItems(nombres);
        lista.setStyle("-fx-text-fill: black;"+
    "fx-font: Courier New;"+
    "-fx-font-weight: semibold;"+
    "-fx-font-size: 16;");
        //lista.setMaxHeight(1000);
        //lista.setMaxWidth(700);
        lista.setPrefWidth(230);
        lista.setPrefHeight(335);
        lista.setTranslateX(200);
        lista.setTranslateY(75);
        //lista.backgroundProperty();}
    }
    }
   
    public void llenarListViewTopNiveles(ListView<String> lista,ObservableList<String> nombres, ArrayList<Buceador>buceadores_niveles){
    int n=buceadores_niveles.size();
      
    for (int i=0; i<n;i++){
       
        nombres.add(buceadores_niveles.get(i).infoJugador2());
        lista.setItems(nombres);
        lista.setStyle("-fx-text-fill: black;"+
    "fx-font: Courier New;"+
    "-fx-font-weight: semibold;"+
    "-fx-font-size: 16;");
        //lista.setMaxHeight(1000);
        //lista.setMaxWidth(700);
        lista.setPrefWidth(230);
        lista.setPrefHeight(335);
        lista.setTranslateX(200);
        lista.setTranslateY(75);}
    }
    
    
    //Devuelve una ventana que contiene un mensaje indicando al usuario que para el nivel que ha escrito
    //no existe top10 , además también le indica hasta que nivel existe top10
    public Stage mensajeNivelNoExiste(){  
    Stage stage=new Stage();
    VBox vbox=new VBox(15);
    vbox.setPadding(new Insets(15));
    Label lb_mensaje=new Label("No existe TOP 1O para el nivel ingresado");
    Label lb_advertencia=new Label("                Existe TOP 10 hasta el nivel "+this.nivel_maximo);
    Button bt_aceptar= new Button(" ACEPTAR ");
    bt_aceptar.setOnAction(new ClickHandler4());
    bt_aceptar.setTranslateX(100);
    lb_mensaje.setFont(Font.font("Myriad Pro", FontWeight.SEMI_BOLD, 16));
    lb_mensaje.setTextFill(Color.DARKBLUE);
    vbox.getChildren().addAll(lb_mensaje,bt_aceptar,lb_advertencia);
    Scene scene= new Scene(vbox);
    stage.setTitle("Typer Shark");
    stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
    stage.setScene(scene);
    
    return stage;
    }
    
    
  /* public Pane getTopJugadores(){
   return this.panel;}
*/   
    public Stage crearStage(){
        //Scene scene1 = new Scene(this.getTopJugadores());
        stage.setTitle("TyperShark Help");
        stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
        stage.setScene(this.scene_opciones);
        stage.setResizable(true);
        stage.initModality(Modality.APPLICATION_MODAL);
     return this.stage;}
    
    
    
    //Devuelve una escena con dos botones: 
    //Boton 1: TOP10 POR NIVELES
    //Boton 2: TOP10 por PUNTAJES
    public Scene escenaOcpionesTop(){
    Scene scene;
    Pane panel=new Pane();
    VBox vbox= new VBox(25);
    Button boton=this.crearButton();
    
    ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoTop.jpg"),800,540,false,false));
    Button bt_top_niveles=new Button (" TOP10: Niveles ");
    Button bt_top_10=new Button ("TOP10: Puntajes ");
    
    bt_top_niveles.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
    bt_top_niveles.setPrefSize(175, 50);
    bt_top_niveles.setStyle("-fx-base: #b6e7c9;");
    bt_top_niveles.setTextFill(Color.BLACK);
        
    bt_top_10.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
    bt_top_10.setPrefSize(175, 50);
    bt_top_10.setStyle("-fx-base: #b6e7c9;");
    bt_top_10.setTextFill(Color.BLACK);
    
    bt_top_niveles.setOnAction(new ClickHandler1());
    bt_top_10.setOnAction(new ClickHandler2());
    vbox.getChildren().addAll(bt_top_niveles,bt_top_10);
    vbox.setTranslateX(300);
    vbox.setTranslateY(200);
    panel.getChildren().addAll(fondo,vbox,boton);
    
    scene=new Scene(panel);
   return scene;
    }
    
    
    //Devuelve una escena con el TOP10 de jugadores ordenados por puntajes 
    public Scene escenaTopPuntaje(){
    Scene scene;
    Pane panel=new Pane();
    Button boton=this.crearButton();
    ListView<String> lista=new ListView<String>();
    ObservableList<String> nombres=FXCollections.observableArrayList ();
    ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoTop.jpg"),800,540,false,false));
    this.llenarListViewTopPuntaje(lista, nombres);
    //boton.setOnAction(new ClickHandler());
    panel.getChildren().addAll(fondo,boton,lista);
    
    scene=new Scene(panel);
   return scene;
    }
    
    
    //Devuelve una escena en la el usuario puede indicar el nivel del TOP10 que desea ver
    public Scene escenaTopEscribirNivel(){
    Scene scene;
    Pane panel=new Pane();
    Button boton=this.crearButton();
    HBox hbox= new HBox(10);
    VBox vbox= new VBox(20);
    Label lb_nivel= new Label("NIVEL: ");
    lb_nivel.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
    lb_nivel.setTextFill(Color.BLACK);
    //TextField texto = new TextField();
    hbox.getChildren().addAll(lb_nivel,texto);
    Button bt_aceptar= new Button(" ACEPTAR ");
    bt_aceptar.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
    bt_aceptar.setTranslateX(90);
    bt_aceptar.setTextFill(Color.BLACK);
    bt_aceptar.setOnAction(new ClickHandler3());
    vbox.getChildren().addAll(hbox,bt_aceptar);
    vbox.setTranslateX(270);
    vbox.setTranslateY(230);
    
    ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoTop.jpg"),800,540,false,false));
   
    //boton.setOnAction(new ClickHandler());
    panel.getChildren().addAll(fondo,boton,vbox);
    
    scene=new Scene(panel);
   return scene;
    }
    
    
    //Devuelve una escena donde se muestra el TO10 de jugadores del nivel que le indicó el usuario
    public Scene escenaMostrarTopNivel( ArrayList<Buceador>buceadores_niveles){
    Scene scene;
    Pane panel=new Pane();
    Button boton=this.crearButton();
    ListView<String> lista=new ListView<String>();
    ObservableList<String> nombres=FXCollections.observableArrayList ();
    ImageView fondo = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondoTop.jpg"),800,540,false,false));
    this.llenarListViewTopNiveles(lista, nombres,buceadores_niveles);
  
    panel.getChildren().addAll(fondo,boton,lista);
    
    scene=new Scene(panel);
   return scene;
    }
    
    
    
    //Cierra la ventana del top_jugadores, la implemente el boton SALIR de las 3 escena
    //Asegura que la ventanda de los top siempre quede con la escena de las opciones
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
            stage.close();
            stage.setScene(scene_opciones);
        }
    }
    
    //Cambia la escena de la ventana de los Top Jugadores 
    //Escena: Escoger el nivel del top10 que se desea ver
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage.setScene(scene_escoger_niveles);
        }
    }
    
    //Cambia la escena de la ventana de los Top Jugadores 
    //Escena: TopJugadores por puntajes
    private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage.setScene(scene_top10);
        }
    }
    
    
    //Cambia de ecena de la ventana de los Top Jugadorees
    //Escena: TopJugadores por niveles
    private class ClickHandler3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            nivel=Integer.parseInt(texto.getText());
             if (Integer.parseInt(texto.getText())>nivel_maximo){
             stage_mensaje=mensajeNivelNoExiste();
             stage_mensaje.showAndWait();
             return;}
             
            texto.clear();
            ArrayList <Buceador> buceadores_niveles=listaTop10Nivel(nivel);
            scene_niveles= escenaMostrarTopNivel(buceadores_niveles);
            stage.setScene(scene_niveles);
        }
    }
    
    
    
    //Cierra la ventana emergente que se abre cuando el usaruio escribe un numero
    //mayor al nivel_max que existe de top10
    //La utiliza el botón ACEPTAR del mensaje nivel no existe
    private class ClickHandler4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage_mensaje.close();
        }
    }
}


