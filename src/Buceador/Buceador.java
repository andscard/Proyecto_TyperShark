/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import Pez.Pez;
import Pez.Piraña;
import Pez.Pulpo;
import Utils.Observer;
import Utils.Posicion;
import Utils.Subject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
 * La clase Buceador almacena 
 * @author Sheyla Cárdenas Sumba
 * @author Mayken Salavarria Tutivén
 */

public class Buceador extends Thread implements Comparable<Buceador>, Observer, Subject {
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
    private final int puntaje_arma_especial=300;
    private final double profundidad_mar=45;
    private int pirañas_picadas;
    private ArrayList observers = new ArrayList();
    
    
   
    
    /**
     * Constructor de la clase Buceador asigna el nombre del jugador, asigna 
     * tres vidas al buceador, puntaje inicial, nivel, arma_especial,posicion
     * del jugador, sea crean los labels que conformar la barra de herramientas.
     * @param nombre tipo String, nombre del jugador
     */
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
    
    this.pirañas_picadas=0;
    }

    
 /**
  * El método getNombre() retorna el nombre del jugador actual.
  * @return nombre tipo String, nombre del jugador
  */
    public String getNombre() {
        return nombre;
    }

    /**
     * El método setNombre(String nombre) permite cambiar el nombre del buceador.
     * @param nombre tipo String, nombre del nuevo Jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * El método getVidas() retorna las vidas que tiene el jugador
     * @return vidas tipo entero
     */
    public int getVidas() {
        return vidas;
    }

    /**
     * El método setVidas(int vidas) permite cambiar las vidas que posea el 
     * buceador
     * @param vidas  tipo entero
     */
    public void setVidas(int vidas) {
        this.vidas = this.vidas+vidas;
    }

    /**
     * El método getPuntaje() permite conocer el puntaje del buceador
     * @return puntaje tipo entero
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * El método setPuntaje(int puntos) cambia el puntaje del buceador
     * @param puntos tipo entero
     */
    public void setPuntaje(int puntos) {
        this.puntaje = this.puntaje+puntos;
    }

    /**
     * El método getEstadoArmaEspecial() permite conocer si el buceador posee
     * o no la arma especial
     * @return arma_especia tipo booleno
     */
    public boolean getEstadoArmaEspecial() {
        return arma_especial;
    }
    
    /**
     * El método BuceadorAlive() permite conocer si el buceador está vivo
     * es decir que tiene vidas disponibles
     * @return dato tipo booleano
     */
    public boolean isBuceadorAlive(){
    if (this.vidas>0){
    return true;}
    else{
    return false;}
    }

    /**
     * El método setEstadoArmaEspecial(boolean arma_especial) cambia el 
     * estado actual de la arma especial
     * @param arma_especial tipo booleano
     */
    public void setEstadoArmaEspecial(boolean arma_especial) {
        this.arma_especial = arma_especial;
    }

    /**
     * El método getPosicion() permite conocer la posición actual del buceador
     * @return posicion tipo Posicion
     */
    public Posicion getPosicion() {
        return posicion;
    }
    
    /**
     * El método getPuntajeArmaEspecial() retorna el valor del arma especial
     * @return puntaje del arma especial, dato tipo entero 
     */
    public int getPuntajeArmaEspecial(){
        return this.puntaje_arma_especial;}
    
    /**
     * El método setPosicion(Posicion posicion) permite cambiar la posicion
     * actual del buceador.
     * @param posicion tipo Posicion
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    /**
     * El método getMetros() retorna el número de metros que ha avanzado el 
     * buceador
     * @return metros, tipo double, metros avanzados
     */
    public double getMetros() {
        return metros;
    }
    
    /**
     * El método getNivel() permite conocer el nivel actual del buceador.
     * @return 
     */
    public int getNivel(){
        return nivel;}
   
    /**
     * EL método setNivel(int nivel) permite aumentar el nivel
     * @param nivel 
     */
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
    

    public void llegaFondoDelMar() {
        if (this.metros == this.profundidad_mar) {
            nivel=nivel+1;
            ganarVidasExtras();
            jugadoresPorNiveles();
            this.metros=0;
            pane.setTranslateY(5);
            this.notifyObservers_buceador_llega_fondo();
          
        }
    }
    
    /**
     * El método ganarVidasExtras() permite aumentar una vida al
     * buceador, si este se encuentra en un nivel multiplo 
     * de tres
     */
    public void ganarVidasExtras(){
        if (nivel%3==0){
            vidas=vidas+1;}
    }
     
    
    public String infoJugador(){
  
    String info=this.nombre+" "+this.puntaje+" "+this.vidas+" "+this.metros+" "+this.estadoArma();
    return info;
    }
    
    
    public String infoJugador2(){
    int level= this.nivel-1;
    String info=this.nombre+" "+level+" "+this.puntaje;
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
        //System.out.println(p.getClass());
        switch (evento) {
            case "pez_llega":
               
                if(!p.getClass().equals(Piraña.class)){
                this.vidas-=1;
                
                }else{
                    this.pirañas_picadas+=1;
                if(this.pirañas_picadas==3){
                this.vidas-=1;
                this.pirañas_picadas=0;
                }
                }
                 if(this.vidas<0){this.vidas=0;}
                System.out.println("Perdio una vida");
                
                break;
            case "pez_muere":
                
                if (p.getClass().equals(Pulpo.class)){
                    setEstadoArmaEspecial(true);
                }
                
                this.puntaje+=p.getPuntos();
                System.out.println("Aumento "+p.getPuntos());
                break;
        }
        
    }
    ////// funciones del observador/////
     @Override
    public void addObserver( Observer o ) {
            observers.add( o );
      }
      @Override
      public void removeObserver( Observer o ) {
            observers.remove( o );
      }
/////// funcion que notifica a los observadores///
      public void notifyObservers_buceador_llega_fondo() {
            // loop through and notify each observer
            Iterator i = observers.iterator();
            while( i.hasNext() ) {
                  Observer o = ( Observer ) i.next();
                  o.update( this , "buceador_llega");
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
                pane.setTranslateY(pane.getTranslateY()+10);
                    
                  System.out.println("METROS:"+pane.getTranslateY());
                  metros+=1;
                  //setMetros(metros);
                  System.out.println(metros);
                  
                  if (puntaje>=puntaje_arma_especial){
                    setEstadoArmaEspecial(true);
                  }
                  if (puntaje<0){ puntaje=0;}
                  
                  
                   
                  String mensaje_arma="(Presione ENTER)";
                    puntaje_string.setText(String.valueOf(puntaje));
                    vidas_string.setText(String.valueOf(vidas));
                    metros_string.setText(String.valueOf(metros));
                    nivel_string.setText(String.valueOf(nivel));
                    if (getEstadoArmaEspecial()==true){
                        arma_string.setText(estadoArma()+" "+mensaje_arma);
                        arma_string.setTextFill(Color.ORANGERED);
                    }else{
                        arma_string.setText(estadoArma());
                    }
                    
                    llegaFondoDelMar();
                    
                    
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
    
    
    
    
     public void jugadoresPorNiveles() {
         try{
        File file=new File ("JugadoresPorNiveles.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
        bw.write(infoJugador2());
        bw.newLine();
        bw.flush();
        bw.close();
           
        }catch(IOException ex){
         System.out.println("No se pudo escribir en el archivo JugadoresPorNiveles.txt");}
            
        
    
        }
    
   
}
