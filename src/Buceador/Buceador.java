/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import Pez.Pez;
import Utils.Observer;
import Utils.Posicion;
import Utils.Subject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * 
 * @author Mayken
 */
public class Buceador extends Thread implements Comparable<Buceador>, Observer {
    private String nombre;
    private int vidas;
    private int puntaje;
    private double metros;
    private int nivel;
    private boolean arma_especial;
    private Posicion posicion;
    private ImageView imagen_buceador;
    private Pane pane;
    private boolean stop=false;
    private Label vidas_string;
    private Label puntaje_string;
    private Label metros_string;
    private Label arma_string;
    private Label nivel_string;
    private ToolBar barra;
    
    
    
    public Buceador(String nombre){
    this.pane= new Pane();    
    this.nombre=nombre;
    this.vidas=3;
    this.puntaje=0;
    this.nivel=1;
    this.arma_especial=false;
    this.posicion=new Posicion(0,10);
    this.metros=0;
    this.vidas_string=new Label();
    this.puntaje_string=new Label();
    this.metros_string=new Label();
    this.arma_string=new Label();
    this.nivel_string=new Label();
    this.imagen_buceador=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/buceador.png"),90,130,true,true));
    this.pane.getChildren().addAll(imagen_buceador);
    this.pane.setLayoutX(posicion.getPos_x());
    this.pane.setLayoutY(posicion.getPos_y());
    this.barra=this.crearToolBar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = this.vidas+vidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntos) {
        this.puntaje = this.puntaje+puntos;
    }

    public boolean armaEspecialOn() {
        return arma_especial;
    }

    public void setArma_especial(boolean arma_especial) {
        this.arma_especial = arma_especial;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public double getMetros() {
        return metros;
    }
    
    public int getNivel(){
        return nivel;}
    
    public void setNivel(int nivel){
    this.nivel=nivel;}
    
     public Pane getPane(){
            return this.pane;
    }
    
    public ImageView getImagenBuceador(){
    return this.imagen_buceador;}
    
    public String estadoArma(){
    String estado;
        if (this.arma_especial==false){
            estado="OFF";
        }else{
            estado="ON";
        }
    
    return estado;
    }
    
    public void cambiarEstadoArmaEspecial(){
        if (puntaje % 300 == 0) {
            this.arma_especial = true;
        } else {
            this.arma_especial = false;
        }
    }
    /*public boolean haCambiadoDeNivel(){
    boolean cambio;
    
    }*/
    public void cambiarNivel(){
        if (puntaje>300 && puntaje<350) {
        this.nivel=nivel+1;}  
    }
    
    
    public String infoJugador(){
  
    String info=this.nombre+" "+this.puntaje+" "+this.vidas+" "+this.metros+" "+this.estadoArma();
    return info;
    }
    
    public void formatoLabelsBarra(Label lb){
        lb.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb.setTextFill(Color.DARKBLUE);
    }
    
    public ToolBar getToolBar(){
    return this.barra;} 
    
    public ToolBar crearToolBar() {
        ToolBar barra = new ToolBar();
        ImageView coin = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/coin.gif"), 25, 25, true, true));
        ImageView heart = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/corazon.png"), 25, 25, true, true));
        ImageView bomba = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/bomba.png"), 25, 25, true, true));

        Label lb_puntaje = new Label("PUNTAJE: ");
        Label lb_vidas = new Label("VIDAS: ");
        Label lb_metros = new Label("METROS: ");
        Label lb_arma = new Label("ARMA ESPECIAL: ");
        Label lb_nivel = new Label("NIVEL: ");
        
        this.formatoLabelsBarra(lb_puntaje);
        this.formatoLabelsBarra(lb_vidas);
        this.formatoLabelsBarra(lb_metros);
        this.formatoLabelsBarra(lb_arma);
        this.formatoLabelsBarra(lb_nivel);
       
       
        Button bt_guardar= new Button("GUARDAR");
        bt_guardar.setOnAction(new ClickHandler());
        
        
        barra.getItems().addAll(coin, lb_puntaje, puntaje_string, new Separator(), heart, lb_vidas, vidas_string, new Separator(), 
                lb_metros, metros_string, new Separator(), bomba, lb_arma, arma_string,new Separator(),lb_nivel,nivel_string,new Separator(),bt_guardar);
      
      
        return barra;
    }
    

    @Override
    public int compareTo(Buceador b1) {
    if (this.puntaje<b1.puntaje){
        return 1;
    }else if(this.puntaje>b1.puntaje){
        return -1;
    }else{
        return 0;}   
    }

    @Override
    public void update(Subject o, String evento) {
        
        Pez p=(Pez)o;
        System.out.println(p.getClass());
        if (evento.equals("pez_llega")){
        this.vidas-=1;
            System.out.println("Perdio una vida");
        }
        
    }

   
    
     private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            try{
        File file=new File ("Partidas.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
         
        bw.write(infoJugador());
        bw.newLine();
        bw.flush();
        bw.close();
            
        }catch(IOException ex){
         System.out.println("No se pudo escribir en el archivo Partidas.txt");}
            
        
    
        }
    }
    
    @Override
    public void run(){
        while(!stop){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                pane.setTranslateY(pane.getTranslateY()+5);
                    
                  System.out.println("METROS:"+pane.getTranslateY());
                  metros+=1;
                  //setMetros(metros);
                  System.out.println(metros);
                  String mensaje_arma="Presione ENTER";
                    puntaje_string.setText(String.valueOf(puntaje));
                    vidas_string.setText(String.valueOf(vidas));
                    metros_string.setText(String.valueOf(metros));
                    nivel_string.setText(String.valueOf(nivel));
                    if (armaEspecialOn()==true){
                        arma_string.setText(estadoArma()+" "+mensaje_arma);
                    }else{
                        arma_string.setText(estadoArma());
                    }
                    
                    
                   if (pane.getTranslateY()==465){
                        pane.setTranslateY(5);
                   }    
                                
                    if (vidas==0){
                     stop=true;
                    }            
                               
                }
                
                
               

               });
           try {
               Buceador.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    
    
    
    Event a;
    public class ManejaVidas implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
       
           System.out.print(event.getTarget().toString());
        }
    
    }
    
   
}
