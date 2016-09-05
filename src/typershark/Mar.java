/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Buceador;
import Pez.Pez;
import Pez.Piraña;
import Pez.Pulpo;
import Pez.Tiburon;
import Pez.TiburonNegro;
import Utils.ArreglosPalabras;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Mar {
    private MediaPlayer music;
    private BorderPane panel_mar;
    private ImageView fondo;
    private ToolBar barra;
    private Pane panel_peces_buceador;
    private ArreglosPalabras arreglo_palabras;
    private int nivel;
    //private Pez tiburon_prueba;
    private Pez[] tiburon;
    private Pez[] tiburones_negro;
    private Pez[] piraña;
    private Pez pulpo;
    private Buceador buceador;
     
     
    public Mar(String name){
        panel_mar=new BorderPane();
        buceador= new Buceador(name);
        barra=this.getToolBar();
        arreglo_palabras= new ArreglosPalabras();
        nivel=2;
        this.tiburon= new Tiburon[nivel];
        this.tiburones_negro= new TiburonNegro[nivel];
        this.piraña= new Piraña[nivel];
        
        panel_peces_buceador=this.setPanelPeces();
        panel_mar.setTop(barra);
        panel_mar.setCenter(panel_peces_buceador);
        
        
        this.disminuirVidas();
    System.out.println(this.buceador.getVidas());
    }
    
    public Pane setPanelPeces(){
    panel_peces_buceador=new Pane();
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/mar.jpg"),900,600,false,false));
    
    panel_peces_buceador.getChildren().addAll(fondo, buceador.getPane());
    buceador.start();
    this.ubicarPecesMar(panel_peces_buceador);
    //music= new MediaPlayer(new Media(getClass().getResource("burbujas.mp3").toExternalForm()));
    //music.setAutoPlay(true);

    return panel_peces_buceador;
    }

    public ToolBar getToolBar() {
        this.barra = new ToolBar();
        ImageView coin = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/coin.gif"), 25, 25, true, true));
        ImageView heart = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/corazon.png"), 25, 25, true, true));
        ImageView bomba = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/bomba.png"), 25, 25, true, true));

        Label lb_puntaje = new Label("PUNTAJE: ");
        lb_puntaje.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb_puntaje.setTextFill(Color.DARKBLUE);
        Label lb_vidas = new Label("VIDAS: ");
        lb_vidas.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb_vidas.setTextFill(Color.DARKBLUE);
        Label lb_metros = new Label("METROS: ");
        lb_metros.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb_metros.setTextFill(Color.DARKBLUE);
        Label lb_arma = new Label("ARMA ESPECIAL: ");
        lb_arma.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb_arma.setTextFill(Color.DARKBLUE);

        Label puntaje = new Label(String.valueOf(this.buceador.getPuntaje()));
        Label vidas = new Label(String.valueOf(this.buceador.getVidas()));
        Label metros = new Label(String.valueOf(this.buceador.getMetros()));
        Label arma = new Label("OFF");
        this.barra.getItems().addAll(coin, lb_puntaje, puntaje, new Separator(), heart, lb_vidas, vidas, new Separator(), lb_metros, metros, new Separator(), bomba, lb_arma, arma);
        //this.barra.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        return this.barra;
    }

    public BorderPane getMar() {
        return this.panel_mar;
    }

    public void arregloDeTiburones() {
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(nivel);
        
        for (int i = 0; i < palabras_tiburones.size(); i++) {    
            this.tiburon[i] = new Tiburon(10, 2, 730, 20+cont ,palabras_tiburones.get(i) );
            this.tiburon[i].start();
    
        cont= cont+90;
        }

    }

    public void arregloDeTiburonesNegros() {
        for (int i = 0; i < this.nivel; i++) {
            ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(nivel);
            this.tiburones_negro[i] = new TiburonNegro(10, 10, i + 20, i + 20, arreglo_palabras.getPalabras().get(i));
           

                this.tiburones_negro[i].start();
        }
    }

    
    public void arregloDePirañas() {
        int cont=0;
        ArrayList<String> palabras_pirañas= arreglo_palabras.arregloLetrasPirañas(nivel);
        
        for (int i = 0; i < palabras_pirañas.size(); i++) {
                this.piraña[i] = new Piraña(5, 3, 740, cont + 20, palabras_pirañas.get(i));
                this.piraña[i].start();
                cont=cont+70;           
        }
    }
    
    public void pulpo (){
        int cont=0;
        String palabra=arreglo_palabras.palabraPulpo();
        this.pulpo= new Pulpo(25,2.5,650,cont+20,palabra);
        this.pulpo.start();
        cont++;
    }
    
    
    public void ubicarPecesMar(Pane mar){
        this.arregloDeTiburones();
        this.arregloDePirañas();
        this.pulpo();
        
        for (int i=0; i< nivel;i++){
             mar.getChildren().addAll(this.tiburon[i].getPane());
            //mar.getChildren().addAll(this.tiburon[i].getPane(),this.piraña[i].getPane(),this.pulpo.getPane());
        }
    }
    
    
    public void disminuirVidas(){
    for (Pez t: tiburon){
        if(t.getPoscion().getPos_x()==-720){
            this.buceador.setVidas(-1);
        }
     }
    }
        
        
    
    
    


}
