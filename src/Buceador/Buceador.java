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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * La clase Buceador almacena funciones útiles como obtener nombre del jugador,
 * setear el estado de vidas, conocer ,aumentar o disminuir el puntaje, activar 
 * o desactivar el arma especial, conocer la posicion del buceador, 
 * ubicar su imagen respectiva en el panel,  y detener su hilo.
 * 
 * @author Sheyla Cárdenas Sumba
 * @author Mayken Salavarria Tutivén
 * @version 2.0.0
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
    private File archivo_partidas;
    //private Button bt_pausa;
    //private Button bt_continuar;
    
    
   
    
    /**
     * Constructor de la clase Buceador asigna el nombre del jugador, asigna 
     * tres vidas al buceador, puntaje inicial, nivel, arma_especial,posicion
     * del jugador,metros que desciende, sea crean las etiquetas, 
     * botones que conformar la barra de herramientas.
     * @param nombre tipo String, nombre del jugador
     */
    public Buceador(String nombre){
    this.pane= new Pane();    
    this.archivo_partidas=new File ("Partidas.txt");
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
     * El método setStopBuceador(boolean stop) permite cambiar el hilo
     * del buceador (detener o seguir).
     * @param stop tipo booleano
     * 
     */

    public void setStopBuceador(boolean stop){
    this.stop=stop;}
    
    public Stage mensajeGuardarPartida(){
    Stage stage=new Stage();
    VBox vbox=new VBox(15);
    vbox.setPadding(new Insets(15));
    Label mensaje_guardar=new Label("!Su partida se ha guardada con éxito!");;
    Button bt_aceptar= new Button(" ACEPTAR ");
    bt_aceptar.setOnAction(new ClickHandler0());
    bt_aceptar.setTranslateX(70);
    mensaje_guardar.setFont(Font.font("Myriad Pro", FontWeight.SEMI_BOLD, 16));
    mensaje_guardar.setTextFill(Color.DARKBLUE);
    vbox.getChildren().addAll(mensaje_guardar,bt_aceptar);
    Scene scene= new Scene(vbox);
    stage.setTitle("Typer Shark");
    stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
    stage.setScene(scene);
    
    return stage;
    }

    /**
     * El método getVidas() retorna el número de vidas del buceador.
     * @return vidas  tipo de dato entero 
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
        this.vidas = vidas;
    }

    /**
     * El método getPuntaje() permite conocer el puntaje del buceador
     * @return puntaje tipo entero
     */
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * El método  setPuntaje(int puntaje) cambia el puntaje actual del buceador
     * @param puntaje tipo de dato entero
     */
    public void setPuntaje(int puntaje){
        this.puntaje=puntaje;}
    
    
    /**
     * El método cambiarPuntaje(int puntos) permite aumentar el puntaje del 
     * buceador, el puntaje se acumulada de acuerdo al valor del pez
     * eliminado.
     * @param puntos tipo de dato entero
     */
    public void cambiarPuntaje(int puntos) {
        this.puntaje = this.puntaje+puntos;
    }

    /**
     * El método getEstadoArmaEspecial() permite conocer si el buceador posee
     * o no la arma especial.
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
    if (this.vidas!=0){
    return true;}
    else{
    return false;}
    }

    /**
     * El método setEstadoArmaEspecial(boolean arma_especial) cambia el 
     * estado actual del arma especial.
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
     * El método setMetros(double metros) se actualiza según los metros
     * que ha avanzado el buceador.
     * @param metros tipo de dato double
     */
    public void setMetros(double metros){
    this.metros=metros;}
    
    
    /**
     * El método getNivel() permite conocer el nivel actual del buceador.
     *  @return  nivel tipo de dato entero
     */
    
    public int getNivel(){
        return nivel;}
   
    /**
     * EL método setNivel(int nivel) permite aumentar el nivel
     * @param nivel 
     */
    public void setNivel(int nivel){
    this.nivel=nivel;}
    
    /**
     * El método getPane() permite retornar el panel del buceador.
     * @return pane tipo Pane
     */
     public Pane getPane(){
            return this.pane;
    }
    
     /**
      * El método getImagenBuceador() retorna la imagen del buceador.
      * @return imagen_buceador tipo ImageView. 
      */
    public ImageView getImagenBuceador(){
    return this.imagen_buceador;}
    
    /**
     * El método estadoArma() permite conocer si el buceador posee arma especial.
     * Si retorna "OFF" significa que el buceador no dispone de arma especial.
     * Si retorna "ON" significa que el buceador dispone de arma espacial, y esta
     * esta lista para ser utilizada.
     * @return estado tipo de dato String
     */
    public String estadoArma(){
    String estado;
        if (this.arma_especial==false){
            estado="OFF";
        }else{
            estado="ON";
        }
    
    return estado;
    }
    
    /**
     * El método llegaFondoDelMar() permite actualizar la toolBar: se observa el
     * cambio de nivel, el buceador gana vidas extras si el nivel es multiplo 
     * de 3, además de guardar en un archivo la situación actual del buceador, 
     * se notifica al observador Mar,que el buceador ha llegado al final 
     * esto significa un cambio de nivel por ende los peces aumentarán su
     * velocidad.
     */
    public void llegaFondoDelMar() {
        if (this.metros == this.profundidad_mar) {
            this.notifyObservers_buceador_llega_fondo();
            //nivel=nivel+1;
            ganarVidasExtras();
            jugadoresPorNiveles();
            this.metros=0;
            pane.setTranslateY(5);
            
          
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
     
    /**
     * El método infoJugador() obtiene la información actual del
     * buceador nombre, puntaje, vidas, metros, estado del Arma Especial
     * y nivel.
     * @return información tipo de String
     */
    public String infoJugador(){
  
    String info=this.nombre+" "+this.puntaje+" "+this.vidas+" "+this.metros+" "+this.estadoArma()+" "+this.nivel;
    return info;
    }
    
    /**
     * El método setInfoJugador(String nombre,int puntaje,int vidas, double metros, boolean arma, int nivel)
     * permite setear la información actual del jugador.
     * @param nombre tipo String
     * @param puntaje tipo entero
     * @param vidas tipo entero
     * @param metros tipo double
     * @param arma tipo booleano
     * @param nivel  tipo entero
     */
    public void setInfoJugador(String nombre,int puntaje,int vidas, double metros, boolean arma, int nivel){
        this.setNombre(nombre);
        this.setPuntaje(puntaje);
        this.setVidas(vidas);
        this.setMetros(metros);
        this.setEstadoArmaEspecial(arma);
        this.setNivel(nivel);
    }
    
    /**
     *  El método formatoLabelsBarra(Label lb) ajusta el tipo de fuente
     * y setea el color del texto que posee el Label.
     * @param lb tipo Label 
     */
    public void formatoLabelsBarra(Label lb){
        lb.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb.setTextFill(Color.DARKBLUE);
    }
    
    /**
     * El método getToolBar() retorna la barra de herramientas del buceador.
     * @return  barra tipo ToolBar
     */
    public ToolBar getToolBar(){
    return this.barra;} 
    
    /**
     * El método crearToolBar(), crea una barra de herramientas con todos 
     * los elementos a visualizar: etiquetas indicando el puntaje, número
     * de vidas, metros descendidos, disponibilidad del arma especial, el 
     * nivel y el botón  guardar.
     * @return barra tipo ToolBar
     */
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
        //bt_guardar.getProperties().addListener(null);
        //bt_pausa=new Button("PAUSA");
        //bt_continuar=new Button("CONTINUAR");
        
        barra.getItems().addAll(coin, lb_puntaje, puntaje_string, new Separator(), heart, lb_vidas, vidas_string, new Separator(), 
                lb_metros, metros_string, new Separator(), bomba, lb_arma, arma_string,new Separator(),lb_nivel,nivel_string,new Separator(),
                bt_guardar);
      //,new Separator(),bt_pausa,new Separator(),bt_continuar
      
        return barra;
    }
    
    /*public Button getButtonPausa(){
        return this.bt_pausa;}
    
    public Button getButtonContinuar(){
        return this.bt_continuar;}
    */
    
    /**
     * El método leerArchivoPartidas() permite leer el archivo que contiene
     * la última partida guardada  por el jugador.
     * @return info tipo String informacion del jugador
     */
    public String [] leerArchivoPartidas(){
    String[]info = null ;
        try{
     
     Scanner scanner = new Scanner(this.archivo_partidas);
        while(scanner.hasNext()){
            String linea=scanner.nextLine();
            info=linea.split(" ");
            
        }
        return info;
    }catch(FileNotFoundException e){
        System.out.println("No se encontró el archivo");
    }
        return null;
    }
    
    /**
     * El método int compareTo(Buceador b1) permite comparar 
     * a dos buceadores, serán ordenados de acuerdo al nivel y puntaje
     * @param b1 tipo de dato Buceador, buceador 2
     * @return tipo de dato entero 1, -1,0
     *  1 si ambos buceadores están en el mismo nivel y el buceador 1 tiene mayor puntaje
     * -1 si ambos buceadores están en el mismo nivel y el buceador 1 tiene menor puntaje
     *  0 los dos buceadores se encuentran en aniveles diferentes.
     */
    @Override
    public int compareTo(Buceador b1) {
    if (this.puntaje>b1.puntaje){
                   return -1;
    }else if(this.puntaje<b1.puntaje){
        return 1;
    }else{
        return 0;} 
      
        
    }

    
     
        
    /**
     * El método update(Subject o, String evento) , recibe al Observador Pez
     * y al evento, de acuerdo al evento realizará las funciones establecidas.
     * Tipos de eventos:
     * "pez_llega": si el tipo de Pez es una piraña, y el buceador ha sido
     * tocado por tres de ellas, el número de vidas debe disminuir en uno.
     * 
     * "pez_muere": si el Pez es eliminado, el puntaje del buceador debe
     * aumentar de acuerdo al valor que posea el pez.
     * @param o tipo Observador
     * @param evento tipo String  
     */
        
        
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
    /**
     * El método addObserver( Observer o ) añade un Observador
     * @param o tipo Observer
     */
     @Override
    public void addObserver( Observer o ) {
            observers.add( o );
      }
    /**
     * El método removeObserver( Observer o ) elimina un Observador
     * @param o tipo Observer
     */
      @Override
      public void removeObserver( Observer o ) {
            observers.remove( o );
      }
/////// funcion que notifica a los observadores///
      
      /**
       * El método notifyObservers_buceador_llega_fondo(), le indica a los Observadores
       * en este caso el Buceador y el Mar que el buceador ha llegado a la profundidad del mar,
       * por ende hay un cambio de nivel y un aumento de velocidad en los peces.
       */
      public void notifyObservers_buceador_llega_fondo() {
            // loop through and notify each observer
            Iterator i = observers.iterator();
            while( i.hasNext() ) {
                  Observer o = ( Observer ) i.next();
                  o.update( this , "buceador_llega");
            }
      }
    
      /**
       * La clase ClickHandler implementa un EventHandler en caso que el jugador
       * de clic en el boton guardar, la información actual del buceador
       * es almacenada en un archivo.
       */
     
      
       private class ClickHandler0 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            System.exit(0);
        }
       }
      
  ////////////////////////////////////////////////////////////////////////
     private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            try{
        
        BufferedWriter bw=new BufferedWriter(new FileWriter(archivo_partidas));
         
        bw.write(infoJugador());
        bw.newLine();
        bw.flush();
        bw.close();
          
        }catch(IOException ex){
         System.out.println("No se pudo escribir en el archivo Partidas.txt");}
     
         mensajeGuardarPartida().showAndWait();
        }
    }
    
     /**
      * El método run() nos ayuda a que el buceador descienda en el panel mar
      * y notifica al jugador si dispone de arma especial, si el buceador
      * muere se detiene su hilo.
      */
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
                    
                    if(isBuceadorAlive()==false){
                        stop=true;}
                               
                }
                
                
               

               });
           try {
               Buceador.sleep(1000);
           } catch (InterruptedException ex) {
               Logger.getLogger(Buceador.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    /**
     * El método infoJugador2() contiene información resumida del buceador
     * como: nombre del jugador, nivel actual, puntaje actual.
     * @return información tipo String
     */
     public String infoJugador2(){
    String info="- "+this.getNombre()+": "+this.getPuntaje()+" (nivel "+this.getNivel()+")";
    return info;
    }
    
    
     /**
      * El método jugadoresPorNiveles() nos permite conocer la informacion del
      * jugador por niveles, y esta es guardada en un archivo.
      */
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









