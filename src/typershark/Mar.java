/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Buceador;
import Pez.Pez;
import Pez.Tiburon;
import Pez.TiburonNegro;
import Utils.Palabra;
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
    //private Tiburon tiburon;
    private Pane pan1, pan2,pan3,pan4,pan5;
    private Pez[] tiburon;
    private Pez[] tiburones_negro;
    private Pez[] piraña;
    private Palabra palabra;
    private Buceador buceador;
    private VBox vbox1;
    private ToolBar barra;
    private Pane panel_peces_buceador;

    // private 
     
    public Mar(String name){
    panel_mar=new BorderPane();
    buceador= new Buceador(name);
    barra=this.getToolBar();
    panel_peces_buceador=this.setPanelPeces();
    panel_mar.setTop(barra);
    panel_mar.setCenter(panel_peces_buceador);
    }
    
    public Pane setPanelPeces(){
    this.panel_peces_buceador=new Pane();
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/mar.jpg"),900,600,false,false));
    //music= new MediaPlayer(new Media(getClass().getResource("burbujas.mp3").toExternalForm()));
    //music.setAutoPlay(true);
    panel_peces_buceador.getChildren().addAll(fondo,buceador.getImagenBuceador());
    //this.tiburon
    
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
        Label metros = new Label("0");
        Label arma = new Label("OFF");
        this.barra.getItems().addAll(coin, lb_puntaje, puntaje, new Separator(), heart, lb_vidas, vidas, new Separator(), lb_metros, metros, new Separator(), bomba, lb_arma, arma);
        //this.barra.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        return this.barra;
    }

    public BorderPane getMar() {
        return this.panel_mar;
    }

    public void arregloDeTiburones() {
        for (int i = 0; i < 5; i++) {

            this.tiburon[i] = new Tiburon(10, 10, i + 20, i + 20, palabra.getPalabras().get(i));
            this.tiburon[i].start();
        }

    }

    public void arregloDeTiburonesNegros() {
        for (int i = 0; i < 5; i++) {

            this.tiburones_negro[i] = new TiburonNegro(10, 10, i + 20, i + 20, palabra.getPalabras().get(i));
            this.tiburones_negro[i].start();

        }

    }

    public void arregloDePiraña() {
        for (int i = 0; i < palabra.getLetras().size(); i++) {

            this.piraña[i] = new TiburonNegro(10, 10, i + 20, i + 20, palabra.getLetras().get(i));
            this.piraña[i].start();
        }

    }

}
