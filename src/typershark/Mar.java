/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typershark;

import Buceador.Buceador;
import Pez.Pez;
import Pez.Pez.Estado;
import Pez.Piraña;
import Pez.Pulpo;
import Pez.Tiburon;
import Pez.TiburonNegro;
import Utils.ArreglosPalabras;
import Utils.Observer;
import Utils.Posicion;
import Utils.Subject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * La Clase Mar almacena funciones útiles  ya que en esta clase se desarrolla el
 * juego TyperShark.contiene método como: crear ArrayList de peces,
 * crea tiburones, pirañas, pulpos, tiburones negros, permite obtener y
 * modificar puntos (Valor de cada pez), velocidad,
 * estado del pez,posicion, conocer el estado del buceador.
 * 
 * @author Mayken Salavarría Tutivén
 * @author Andrea Cárdenas Sumba
 * 
 * @version 2.0.0
 * 
 */

public class Mar extends Thread implements Observer{
    private MediaPlayer music;
    private BorderPane panel_mar;
    private ImageView fondo;
    private ToolBar barra;
    private Pane panel_peces_buceador;
    private ArreglosPalabras arreglo_palabras;
    private int nivel;
    private int num_peces;
    private int velocidad;
    private ArrayList<Pez> peces_mar;
    private Pez[] tiburon;
    private Pez[] tiburon_negro;
    private Pez[] piraña;
    private Pez[] pulpo;
    private Buceador buceador;
    private int id_pez; 
    private boolean fin_juego;
    private Button bt_salir= new Button (" SALIR ");
    private Button bt_regresar= new Button(" MENÚ PRINCIPAL ");
       
    
    
    /**
     * Constructor del Mar, asigna el panel, buceador( Jugador), nivel, 
     * velocidad, inicializa el arraylist de los peces , genera 
     * el numero de peces que apareceran por pantalla, inicializa a fin _juego
     * en false ya que el buceador posee al inicio del juego sus tres vidas completas,
     * indica que el bucead
     * 
     * 
     * @param name tipo String, nombre del jugador
     */
    
    public Mar(String name){
        panel_mar=new BorderPane();
        buceador= new Buceador(name);
        buceador.addObserver(this);
        nivel=buceador.getNivel();
        velocidad=2;
        num_peces=0;
        fin_juego= false;
        System.out.println(this.num_peces);
        this.barra=buceador.getToolBar();
        this.bt_salir= new Button (" SALIR ");
        this.bt_regresar= new Button(" MENÚ PRINCIPAL ");
        arreglo_palabras= new ArreglosPalabras();
        this.tiburon= new Tiburon[this.num_peces];
        this.tiburon_negro= new TiburonNegro[this.num_peces];
        this.piraña= new Piraña[this.num_peces];
        this.pulpo=new Pulpo[this.num_peces];
        
        panel_peces_buceador=this.setPanelPeces();

        this.peces_mar=new ArrayList<Pez>();
        //buceador.getButtonPausa().setOnAction(new ClickHandler2());
         //buceador.getButtonPausa().setOnAction(new ClickHandler3());
        panel_mar.setCenter(panel_peces_buceador);
        panel_mar.setTop(barra);
        

     //   panel_mar.setOnKeyPressed(new KeyPressed());
        
        
    //this.disminuirVidas();
    System.out.println(this.buceador.getVidas());
    }

    /**
     * El método getNivel() permite obtener el nivel actual que cursa el jugador
     * @return nivel tipo entero, nivel actual
     */
    public int getNivel() {
        return nivel;
    }
   
    /**
     * El método getBuceador () retorna un buceador.
     * @return  buceador tipo Buceador
     */
    public Buceador getBuceador (){
    return this.buceador;}

    /**
     * El método setBuceador(Buceador buceador) permite cambiar al buceador actual
     * @param buceador tipo Buceador 
     */
    public void setBuceador(Buceador buceador) {
        this.buceador = buceador;
    }
    
    
    
    /**
     * El método setPanelPeces(), ajusta la imagen del fondo del mar,ubica
     * el panel que contiene a los peces y al buceador, además de inicializar
     * el hilo del buceador.
     * @return panel tipo Pane
     */
    public Pane setPanelPeces(){
    panel_peces_buceador=new Pane();
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/mar.jpg"),900,600,false,false));
    
    panel_peces_buceador.getChildren().addAll(fondo, buceador.getPane());
    buceador.start();
    //this.generarPezAleatorio2();
        
    /*if(buceador.isBuceadorAlive()==true){
    
    }*/
    //music= new MediaPlayer(new Media(getClass().getResource("burbujas.mp3").toExternalForm()));
    //music.setAutoPlay(true);

    return panel_peces_buceador;
    }

   
    /**
     * El método BorderPane getMar() retorna el panel del mar, con todos 
     * elementos que lo conforman (botones,peces, buceador).
     * @return panel_mar tipo BorderPane, panel del juego
     */
    public BorderPane getMar() {
        return this.panel_mar;
    }

    
    /**
     * El método permite obtener un botón
     * @return boton tipo Button
     */
    public Button getButtonRegresar(){
    return this.bt_regresar;}
    
    
    
    /**
     * El método arregloDeTiburones() permite crear un arreglo de
     * Tiburones, de acuerdo al numero de peces
     */
    public void arregloDeTiburones() {
        this.tiburon=new Tiburon[num_peces];
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(num_peces);
        ArrayList<String> una_palabra= new ArrayList();
        for (int i = 0; i < palabras_tiburones.size(); i++) {
            una_palabra.add(palabras_tiburones.get(i));
            this.tiburon[i] = new Tiburon(10,velocidad +2 , 730, 20+cont ,una_palabra );
            //this.tiburon[i].start();
            una_palabra.clear();
    
        cont= cont+90;
        }

    }

    /**
     * El método arregloDeTiburonesNegros() permite crear un arreglo de
     * Tiburones Negros, estos poseerán de 2 a 3 palabras.
     */
   public void arregloDeTiburonesNegros() {
        this.tiburon_negro=new TiburonNegro[num_peces];
        int cont=0;
        int aleatorio_palabras;
        
        ArrayList<String> lista_palabras=new ArrayList<String>();
        System.out.println("NUMERO PECES:"+num_peces);
        for (int i = 0; i < this.num_peces; i++) {
            aleatorio_palabras=(int)(Math.random()*3+2);
            lista_palabras=arreglo_palabras.arregloPalabrasTiburonesNegro();
             if(aleatorio_palabras==2){
                lista_palabras.remove(2);}
             
            this.tiburon_negro[i] = new TiburonNegro(30, velocidad + 2, 720, cont + 20,lista_palabras);
            
            cont = cont + 90;
            
        }
    }
     
    
    
  /**
   * El método arregloDePirañas() permite crear un arreglo de pirañas.
   */
 
    public void arregloDePirañas() {
        this.piraña=new Piraña[num_peces];
        int cont=0;
        ArrayList<String> letras_pirañas= arreglo_palabras.arregloLetrasPirañas(num_peces);
        ArrayList<String> una_letra= new ArrayList();
        for (int i = 0; i < letras_pirañas.size(); i++) {
                una_letra.add(letras_pirañas.get(i));
                this.piraña[i] = new Piraña(5,velocidad +5, 740, cont + 20, una_letra);
                //this.piraña[i].start();
                una_letra.clear();
                cont=cont+70;           
        }
    }
    
    /**
     * El método pulpo() crea un pulpo.
     */
    public void pulpo (){
        int offset=0;
       this.pulpo=new Pulpo[this.num_peces];
        for(int i=0;i<this.num_peces;i++){
         ArrayList<String>palabra=arreglo_palabras.palabraPulpo();
        this.pulpo[i]=new Pulpo(100,2.5,650,offset+40,palabra);
        offset+=80;
        }
        //this.pulpo[0].start();
    }
 
    
    /*public void detenerHilosPeces(){
        for(int i=0; i<peces_mar.size();i++){
            try {
                peces_mar.get(i).wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Mar.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    }
    
       public void detenerHiloJugador(){
        try {
            buceador.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mar.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
   
    
       public void correrHiloJugador(){
       buceador.notifyAll();}
    */
    
    
    /*public void ubicarPecesMar(Pane mar,Pez pez[]){
        for (int i=0; i<this.num_peces ;i++){
            pez[i].addObserver(buceador);
            mar.getChildren().addAll(pez[i].getPane());
             pez[i].start();
        }
    }*/
    
    
    /**
     * El método ubicarPecesMar permite determinar al Buceador como Observador
     * y a los peces como sujetos a ser observados
     * @param mar tipo Pane
     * @param peces_mar  ArrayList tipo Pez
     */
    public void ubicarPecesMar(Pane mar, ArrayList<Pez> peces_mar){
        for (Pez pez : peces_mar){
            pez.addObserver(buceador);
            pez.addObserver(this);
            mar.getChildren().addAll(pez.getPane());
            pez.start();
        }
    }
    
    /**
     * El método aumentarVelocidadPeces() permite aumentar
     * la velocidad de los peces de acuerdo al nivel.
     */
    public void aumentarVelocidadPeces(){
    this.velocidad=(2*nivel)+(nivel-1);}
    
    
 
    
    /*private void generarPezAleatorio(){    
    this.arregloDeTiburones();
    this.arregloDePirañas();
    this.pulpo();
    this.arregloDeTiburonesNegros(); 
    int []numero=  {1,2,3,1,2,3,4,1,2,3};
    //int aleatorio=(int)(new Random().nextDouble()*9+0);
    int aleatorio=2;
    
    System.out.println("numero"+aleatorio);
    
    if(numero[aleatorio]==1) {
        pez_mar=tiburon;
        this.ubicarPecesMar(panel_peces_buceador,tiburon);
    }else if(numero[aleatorio]==2){
        this.ubicarPecesMar(panel_peces_buceador, piraña);
        pez_mar=piraña;
    }else if (numero[aleatorio]==3){
        pez_mar=tiburon_negro;
        this.ubicarPecesMar(panel_peces_buceador,tiburon_negro);
    }else{
        pez_mar=pulpo;
        panel_peces_buceador.getChildren().add(pulpo[0].getPane());}
    
    }*/
    
    
    
    /**
     * El método generarPezAleatorio2() permite generar los peces de manera
     * aleatoria ubicandondolos en el panel del mar.
     */
    private void generarPezAleatorio2(){ 
    
    //this.pez_mar= new Pez[num_peces];
    this.arregloDeTiburones();
    this.arregloDePirañas();
    this.pulpo();
    this.arregloDeTiburonesNegros(); 
    //int []numero=  {1,2,1,2,1,2,1,4};
   // int []numero=  {1,2,3,2,1,2,1,3};
    //  int []numero=  {4,4,4,4,4,4,4,4};
       int []numero=  {1,2,3,4,1,2,2};
    
    Posicion pos;
    //int aleatorio=0;
    
    for(int i =0;i<num_peces;i++){
    int aleatorio=(int)(new Random().nextDouble()*7+0);
    double x=new Random().nextDouble()*740+700;
    double y=new Random().nextDouble()*90+20;
    pos=new Posicion(x,y);
 
    System.out.println("numero"+aleatorio);
    
    if(numero[aleatorio]==1) {
       tiburon[i].setPosicion(pos);
       peces_mar.add(tiburon[i]);
    }
    if(numero[aleatorio]==2){
        piraña[i].setPosicion(pos);
        peces_mar.add(piraña[i]);
    }
    if (numero[aleatorio]==4){
       tiburon_negro[i].setPosicion(pos);
       peces_mar.add(tiburon_negro[i]);
    }
    
     if (numero[aleatorio]==3){
     pulpo[i].setPosicion(pos);
     peces_mar.add(pulpo[i]);
     
     }
    }
    
     this.ubicarPecesMar(panel_peces_buceador,peces_mar);
    }
    
    
    /**
     * El método matarPecesConArmaEspecial() permite utilizar el arma
     * especial y esta cambia el estado de vida ( VIVO a MUERTO),
     * de todos los peces que se encuentren en juego, cuando se utiliza
     * el arma especial el puntaje acumulado del buceador disminuye 
     * 300 puntos (valor del arma especial).
     */
    public void matarPecesConArmaEspecial(){
    if(buceador.getEstadoArmaEspecial()==true){
       
        for (int i=0; i<peces_mar.size();i++){
            peces_mar.get(i).setEstadoVida();
            peces_mar.get(i).notifyObservers_pezmuere();
            System.out.println("borraaar"+i);
           
        }
        buceador.cambiarPuntaje(-buceador.getPuntajeArmaEspecial());
         peces_mar.removeAll(peces_mar);

        buceador.setEstadoArmaEspecial(false);
    }
    }
    
    /**
     * El método nuevoNumeroAleatorioPeces(), genera un nuevo número 
     * de peces para el panel mar.
     */
   public void nuevoNumeroAleatorioPeces(){
       if (num_peces==0){
           this.num_peces=(int)(new Random().nextDouble()*5+1);
           
       }
    
   }
   
   /**
    * El método getFinJuego() nos permite conocer si el juego finalizó.
    * @return dato tipo booleano
    */
   public boolean getFinJuego(){
        return this.fin_juego;}

   
   /**
    * El método update, permite al mar analizar los sujetos
    * (buceador y peces)y  el evento a analizar.
    * @param o tipo Subject
    * @param evento tipo String
    */
    @Override
    public void update(Subject o, String evento) {
   
         //System.out.println(p.getClass());
        switch (evento) {
            case "pez_llega":
               Pez p=(Pez)o;
               peces_mar.remove(p);
                
                break;
            case "buceador_llega":
                Buceador b=(Buceador) o;
                this.escribirArchivoTopJugadores(buceador);
                b.setNivel(nivel+1);
                aumentarVelocidadPeces();
                System.out.println("VELOCIAD: "+velocidad);
               break;
            
                
                
        }
        
    
   
       
    }
    
/**
 * El método mensajeGameOver(), es un panel que indica 
 * que el juego ha finalizado , posee dos botones que permiten
 * salir del juego o regresar al Menu Principal. 
 * 
 * @return panel tipo Pane 
 */
    public Pane mensajeGameOver(){
        HBox hbox= new HBox(100);
        Pane panel = new Pane();
        //panel.setTranslateY(-160);
        ImageView fondo_mar=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/mar.jpg"),900,600,false,false));
        ImageView mensaje = new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo_gameover2.png"),700,500,true,true));
        mensaje.setTranslateX(80);
        
        bt_salir.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        bt_salir.setPrefSize(150, 50);
        bt_salir.setStyle("-fx-base: #FA5858;");
        bt_salir.setTextFill(Color.WHITE);
        
        bt_regresar.setFont(Font.font("Amble CN", FontWeight.BOLD, 16));
        bt_regresar.setPrefSize(170, 50);
        bt_regresar.setStyle("-fx-base: #FA5858;");
        bt_regresar.setTextFill(Color.WHITE);
        
        bt_salir.setOnAction(new ClickHandler1());
        hbox.getChildren().addAll(bt_salir,bt_regresar);
        panel.getChildren().addAll(fondo_mar,mensaje,hbox);
        hbox.setTranslateX(210);
        hbox.setTranslateY(400);
        //panel_mar.setBottom(panel);
        
        return panel;
    }
    
    public void escribirArchivoTopJugadores(Buceador buceador ){
    try{
        
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("TopJugadores.txt"),true));
         
        bw.write(buceador.infoJugador());
        bw.newLine();
        bw.flush();
        bw.close();
            
    }catch(IOException ex){
        System.out.println("No se pudo escribir en el archivo TopJugadores.txt");}
    }
    
    /**
     * Esta clase permite salir del juego, cuando el usuario presiona
     * el boton Salir
     */
   
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            System.exit(0);
        }
    }
    
   /* private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
            detenerHilosPeces();
            detenerHiloJugador();
        }
    }
    
    private class ClickHandler3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
      
        // correrHilosPeces();
         correrHiloJugador();
        }
    }*/
    
    
    /**
     * La clase KeyPressed implements EventHandler<KeyEvent>  implementa el 
     * evento por teclado, su  función principal es recibir las letras
     * y comparararlas con las palabras de los peces en juego. 
     * Cuando la primera letra es comparada y coincide con el caracter inicial
     * de una de las palabras de los peces, el pez es seleccionado  y este
     * no puede ser eliminado hasta que toda su palabra sea completada. Cuando
     * la palabra sea completada el pez desaparece y el buceador acumula puntos.
     * 
     */
    private class KeyPressed implements EventHandler<KeyEvent> {
        //private Pez pez[]=pez_mar;
        //ArrayList<Pez> peces= peces_mar;
       
        @Override
                
            public void handle(KeyEvent event) {
             int posicion_palabra;
             int palabra_activa = -1;
             int size_peces=peces_mar.size();
             int cont_palabras=0;
             int posicion=0;
             
            //palabra_activa es variable que indicia qué pez del arreglo está en juego 
             //si palabra_activa=-1 , ningun pez ha sido seleccionado 
             
             //ESTADOS DE LAS PALBRAS DE UN PEZ:
             //EstadoPalabra=0 -> la palabra que tiene el pez no ha sido escrita
             //EstadoPalabra=1 -> la palabra que tiene el pez está siendo escrita
             //EstadoPalabra=-1 -> la palabra que tiene el pez ya se escribió
             if (event.getCode() == KeyCode.ENTER) {
                matarPecesConArmaEspecial();
                 System.out.println("Enter Pressed");
                 return;
                }
             
             try{
              if(size_peces!=-1){   
                     for(int i=0;i<size_peces;i++){
                        if (peces_mar.get(i).palabra.getEstado()==1)
                             palabra_activa = i;
                        }
                     
                     
              if(palabra_activa==-1){
                  for(int i=0;i<size_peces;i++){
                      if(peces_mar.get(i).palabra.getEstado()==0){
                        
                        if (event.getText().charAt(0)==peces_mar.get(i).palabra.getPalabra().charAt(0)){
                              peces_mar.get(i).palabra.cambiarColorLetras(0);
                              //Se valida el char de la piraña para que desaparezca a la primera coincidencia
                                if(peces_mar.get(i).palabra.getPalabra().length()==1){
                                    peces_mar.get(i).setEstadoVida();
                                    peces_mar.get(i).notifyObservers_pezmuere();
                                   // pez[i].stop();
                                     //pez[i].getPane().setVisible(false);
                                     peces_mar.get(i).palabra.setEstado(-1);
                                     peces_mar.remove(i);
                                     num_peces=num_peces-1;
                                     System.out.println("NUMERO DE PECES PRESENTES EN EL MAR= "+num_peces);
                                     break;
                                } 
                                else{
                                //la palabra es de una longitud de mayor a 1
                                 peces_mar.get(i).palabra.setEstado(1);
                                 peces_mar.get(i).palabra.cambiarColorLetras(0); 
                                 peces_mar.get(i).palabra.setPosicion(1);}// cierra longitud
                                
                        }
                      }
                    }
              }//cierra palabra activa -1
              
              //
              else{
                  
                  
                  
                  posicion=peces_mar.get(palabra_activa).palabra.getPosicion();
                  
                  if (event.getText().charAt(0)==peces_mar.get(palabra_activa).palabra.getPalabra().charAt(posicion)){
                       
                    if(posicion <peces_mar.get(palabra_activa).palabra.getLongitudPalabra()){
                        if (event.getText().charAt(0)==peces_mar.get(palabra_activa).palabra.getPalabra().charAt(posicion) ){
                       
                        peces_mar.get(palabra_activa).palabra.cambiarColorLetras(posicion);
                        posicion=posicion+1; 
                        peces_mar.get(palabra_activa).palabra.setPosicion(posicion);
                     }
                         
                   }
                    //Posicion del curso es igual a la longitud de la palabra, aquí muere el pez
                      if(posicion ==peces_mar.get(palabra_activa).palabra.getLongitudPalabra()){
                           //pez[palabra_activa].setEstadoVida();
              
                          if(peces_mar.get(palabra_activa).palabra.getNum_palabras()>1){
                               peces_mar.get(palabra_activa).palabra.setEstado(-1);
                               
                               if(!peces_mar.get(palabra_activa).palabra.listaVaciaPalabras()){
                                   
                                  if(peces_mar.get(palabra_activa).palabra.getEstado()==-1){
                                      peces_mar.get(palabra_activa).palabra.eliminarPalabra(0);
                                        peces_mar.get(palabra_activa).palabra.panelPalabra().getChildren().clear();
                                      peces_mar.get(palabra_activa).palabra.cargarPalabra(0);
                                      
                                      posicion=0;
                                      
                                      
                                  }
                                }//lista vacia
                                                         
                            }
                            
                            else{
                          
                       System.out.println("Terminaste de escribirrrrr");
                       
                       num_peces=num_peces-1;
                       
                       System.out.println("NUMERO DE PECES PRESENTES EN EL MAR= "+num_peces);
                      // puntos_pez=peces_mar.get(palabra_activa).getPuntos();
                       peces_mar.get(palabra_activa).palabra.setEstado(-1);
                        //buceador.cambiarPuntaje(pez[palabra_activa].getPuntos()); 
                        System.out.println("Puntaje: "+buceador.getPuntaje());
                       peces_mar.get(palabra_activa).setEstadoVida();
                       peces_mar.get(palabra_activa).notifyObservers_pezmuere();
                       peces_mar.remove(palabra_activa);
                        //pez[palabra_activa].getPane().setVisible(false);
                        //mar.tiburon[palabra_activa].palabra.panelPalabra().setVisible(false);
                        
                        
                            }
                        } 
                   
                   
                   }
                  
                  else {
                        peces_mar.get(palabra_activa).setVelocidad(20);
                  }
   
                  }
              
                }
            }catch(Exception e){
                System.out.println("Presiono otra tecla");
            }
             
             
             
            }
    }
    
 
 /**
  * El método run() genera el panel con los peces de manera aleatorio,
  * posee el evento de escribir por teclado, detiene el juego
  * cuando el muere el hilo del buceador.
  */
    
    @Override
    public void run(){
           
            while(!fin_juego){
                
                Platform.runLater(new Runnable(){
                    @Override
                   
                    public void run() {
                        nivel=buceador.getNivel();
                        nuevoNumeroAleatorioPeces();    
                        if (peces_mar.size()<1){
                        generarPezAleatorio2();
                        }

                         panel_mar.setOnKeyPressed(new KeyPressed());
                         
                         if (buceador.isBuceadorAlive()==false){
                        escribirArchivoTopJugadores(buceador);
                        panel_mar.setCenter(mensajeGameOver());
                        fin_juego=true;
                        }
                    }
                    
                });
                try {
                    Mar.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mar.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
              
            }
       
            
    }
    


}
