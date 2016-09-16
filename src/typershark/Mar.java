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
import Utils.Posicion;
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
public class Mar extends Thread{
    private MediaPlayer music;
    private BorderPane panel_mar;
    private ImageView fondo;
    private ToolBar barra;
    private Pane panel_peces_buceador;
    private ArreglosPalabras arreglo_palabras;
    private int nivel;
    private int num_peces;
    private int velocidad;
    //private Pez tiburon_prueba;
    private Pez[] pez_mar;
    private Pez[] tiburon;
    private Pez[] tiburon_negro;
    private Pez[] piraña;
    private Pez[] pulpo;
    private Buceador buceador;
    private int id_pez; 
     
    public Mar(String name){
        panel_mar=new BorderPane();
        buceador= new Buceador(name);
        nivel=buceador.getNivel();
        velocidad=0;
        //num_peces=(int)(new Randnum_pecesom().nextDouble()*5+1);
        num_peces=0;
        System.out.println(this.num_peces);
        //barra=this.crearToolBar();
        this.barra=buceador.getToolBar();
        arreglo_palabras= new ArreglosPalabras();
        this.tiburon= new Tiburon[this.num_peces];
        this.tiburon_negro= new TiburonNegro[this.num_peces];
        this.piraña= new Piraña[this.num_peces];
        this.pulpo=new Pulpo[1];
        
        panel_peces_buceador=this.setPanelPeces();
        
        /*if(buceador.isBuceadorAlive()==true && num_peces==0){
            num_peces=(int)(new Random().nextDouble()*5+1);
            generarPezAleatorio2();
        }*/
        
        
        panel_mar.setCenter(panel_peces_buceador);
        panel_mar.setTop(barra);
        

     //   panel_mar.setOnKeyPressed(new KeyPressed());
        
        
    //this.disminuirVidas();
    System.out.println(this.buceador.getVidas());
    }

    public int getNivel() {
        return nivel;
    }
    
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
     * 
     * @return 
     */
    public BorderPane getMar() {
        return this.panel_mar;
    }

    public void arregloDeTiburones() {
        this.tiburon=new Tiburon[num_peces];
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(num_peces);
        ArrayList<String> una_palabra= new ArrayList();
        for (int i = 0; i < palabras_tiburones.size(); i++) {
            una_palabra.add(palabras_tiburones.get(i));
            this.tiburon[i] = new Tiburon(100,velocidad +2 , 730, 20+cont ,una_palabra );
            //this.tiburon[i].start();
            una_palabra.clear();
    
        cont= cont+90;
        }

    }

    
    
    public void arregloDeTiburonesNegros() {
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburonesNegro();
        ArrayList<String> lista_palabras=new ArrayList<String> ();
        System.out.println(palabras_tiburones.size());
         System.out.println("NUMERO PECES:"+num_peces);
        for (int i = 0; i < this.num_peces; i++) {
            //int num_palabras = (int) (Math.random ()*(2)+ 2);
            int num_palabras = 2;
            
            System.out.println("num palabras"+num_palabras);
            for (int j = 0; j < num_palabras; j++) {

                lista_palabras.add(palabras_tiburones.get(j));

            }
            this.tiburon_negro[i] = new TiburonNegro(30, velocidad + 2, 720, cont + 20, lista_palabras);
            palabras_tiburones.remove(0);
            palabras_tiburones.remove(0);
            palabras_tiburones.remove(0);
            lista_palabras.clear();
            cont = cont + 90;
            //this.tiburon_negro[i].start();
            
        }
    }
    
    
    /**
    
      public void arregloDeTiburonesNegros() {
        Random  random = new Random();  
        int cont=0;
        int contador_palabras=0;
        int num_palabras;
        
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(num_peces*3);
        ArrayList<String> lista_words= new ArrayList<String>();
        
        for (int i = 0; i < this.num_peces; i++) {
            num_palabras=(int)(random.nextDouble()*3 +2);
            for(int j=0; j<num_palabras; j++){
                lista_words.add(palabras_tiburones.get(contador_palabras)); 
                 contador_palabras=contador_palabras+1;
            }// cierrej
            this.tiburon_negro[i] = new TiburonNegro(10, velocidad+2,720,cont + 20,lista_words);
            this.tiburon_negro[i].palabra.setNum_palabras(lista_words.size());
            this.tiburon_negro[i].start();
            lista_words.clear();
            cont=cont+90;
          
        
         }// cierre i
            
      }      
               
    **/       
    
    
    
    public void arregloDePirañas() {
        this.piraña=new Piraña[num_peces];
        int cont=0;
        ArrayList<String> letras_pirañas= arreglo_palabras.arregloLetrasPirañas(num_peces);
        ArrayList<String> una_letra= new ArrayList();
        for (int i = 0; i < letras_pirañas.size(); i++) {
                una_letra.add(letras_pirañas.get(i));
                this.piraña[i] = new Piraña(50,velocidad +3, 740, cont + 20, una_letra);
                //this.piraña[i].start();
                una_letra.clear();
                cont=cont+70;           
        }
    }
    
    public void pulpo (){
        
        ArrayList<String>palabra=arreglo_palabras.palabraPulpo();
        this.pulpo[0]=new Pulpo(25,2.5,650,40,palabra);
        //this.pulpo[0].start();
    }
    
    
    public void ubicarPecesMar(Pane mar,Pez pez[]){
        for (int i=0; i<this.num_peces ;i++){
            pez[i].addObserver(buceador);
            mar.getChildren().addAll(pez[i].getPane());
             pez[i].start();
        }
    }
    
    
    public void disminuirVidas(){
    for (Pez t: tiburon){
        if(t.getPosicion().getPos_x()==-720){
            this.buceador.setVidas(-1);
        }
     }
    }
    
    public void aumentarNivel(){
        if((buceador.getMetros()%465)==0){
            this.nivel=nivel+1;}
        this.aumentarVelocidad();
    }
    
    public void aumentarVelocidad(){
    this.velocidad=velocidad+1;}
    
    
    public void setId_Pez(int id){
    this.id_pez=id;
    }
    
    public int getId_Pez(){
    return this.id_pez;
    }
    
    private void generarPezAleatorio(){    
    this.arregloDeTiburones();
    this.arregloDePirañas();
    this.pulpo();
    this.arregloDeTiburonesNegros(); 
    int []numero=  {1,2,3,1,2,3,4,1,2,3};
    //int aleatorio=(int)(new Random().nextDouble()*9+0);
    int aleatorio=2;
    this.setId_Pez(numero[aleatorio]);

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
    
    }
    
    private void generarPezAleatorio2(){ 
    
    this.pez_mar= new Pez[num_peces];
    this.arregloDeTiburones();
    this.arregloDePirañas();
    this.pulpo();
    //this.arregloDeTiburonesNegros(); 
    int []numero=  {1,2,1,2,1,2,1};
    Posicion pos;
    //int aleatorio=0;
    
    for(int i =0;i<num_peces;i++){
    int aleatorio=(int)(new Random().nextDouble()*6+0);
    double x=new Random().nextDouble()*740+700;
    double y=new Random().nextDouble()*90+20;
    pos=new Posicion(x,y);
    this.setId_Pez(numero[aleatorio]);
    System.out.println("numero"+aleatorio);
    
    if(numero[aleatorio]==1) {
        pez_mar[i]=tiburon[i];
        pez_mar[i].setPosicion(pos);
       
    }
    if(numero[aleatorio]==2){
        pez_mar[i]=piraña[i];
        pez_mar[i].setPosicion(pos);
    }
    if (numero[aleatorio]==3){
        pez_mar[i]=tiburon_negro[i];
        pez_mar[i].setPosicion(pos);
    }/*else{
        pez_mar[i]=pulpo[i];
        panel_peces_buceador.getChildren().add(pulpo[0].getPane());
    }*/
    
    }
    
     this.ubicarPecesMar(panel_peces_buceador,pez_mar);
     this.num_peces=(int)(new Random().nextDouble()*5+1);
    }
    
    public void matarPecesConArmaEspecial(){
    if(buceador.getEstadoArmaEspecial()==true){
       
        for (int i=0; i<pez_mar.length ;i++){
            pez_mar[i].setEstadoVida();
            pez_mar[i].notifyObservers_pezmuere();
        }
      
    }
    }
    
   public void nuevoNumeroAleatorioPeces(){
       if (num_peces==0){
           this.num_peces=(int)(new Random().nextDouble()*5+1);
           
       }
    
   }
    
   
    private class KeyPressed implements EventHandler<KeyEvent> {
        private Pez pez[]=pez_mar;
        private int peces_eliminados=0;
        private int puntos_pez=0;
        
        @Override
                
            public void handle(KeyEvent event) {
             int posicion_palabra;
             int palabra_activa = -1;
             int contador=pez.length; 
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
                buceador.setPuntaje(-(peces_eliminados*puntos_pez)-300);
                buceador.setEstadoArmaEspecial(false);
                 System.out.println("Enter Pressed");
                }
             
             if(contador!=-1){   
                     for(int i=0;i<contador;i++){
                  if (pez[i].palabra.getEstado()==1)
                    palabra_activa = i;
              }
                     
                     
              if(palabra_activa==-1){
                  for(int i=0;i<contador;i++){
                      if(pez[i].palabra.getEstado()==0){
                        
                        if (event.getText().charAt(0)==pez[i].palabra.getPalabra().charAt(0)){
                              pez[i].palabra.cambiarColorLetras(0);
                              //Se valida el char de la piraña para que desaparezca a la primera coincidencia
                                if(pez[i].palabra.getPalabra().length()==1){
                                    pez[i].setEstadoVida();
                                    pez[i].notifyObservers_pezmuere();
                                   // pez[i].stop();
                                     //pez[i].getPane().setVisible(false);
                                     pez[i].palabra.setEstado(-1);
                                     num_peces=num_peces-1;
                                     System.out.println("NUMERO DE PECES PRESENTES EN EL MAR= "+num_peces);
                                     break;
                                } 
                                else{
                                //la palabra es de una longitud de mayor a 1
                                 pez[i].palabra.setEstado(1);
                                 pez[i].palabra.cambiarColorLetras(0); 
                                 pez[i].palabra.setPosicion(1);}// cierra longitud
                                
                        }
                      }
                    }
              }//cierra palabra activa -1
              
              //
              else{
                  
                  
                  
                  posicion=pez[palabra_activa].palabra.getPosicion();
                  
                  if (event.getText().charAt(0)==pez[palabra_activa].palabra.getPalabra().charAt(posicion)){
                       
                    if(posicion <pez[palabra_activa].palabra.getLongitudPalabra()){
                            if (event.getText().charAt(0)==pez[palabra_activa].palabra.getPalabra().charAt(posicion) ){
                       
                        pez[palabra_activa].palabra.cambiarColorLetras(posicion);
                        posicion=posicion+1; 
                        pez[palabra_activa].palabra.setPosicion(posicion);
                     }
                         
                   }
                    //Posicion del curso es igual a la longitud de la palabra, aquí muere el pez
                      if(posicion ==pez[palabra_activa].palabra.getLongitudPalabra()){
                           //pez[palabra_activa].setEstadoVida();
                         
                           
                           
                       if(pez[palabra_activa].palabra.getNum_palabras()>1){
                           if(cont_palabras<pez[palabra_activa].palabra.getNum_palabras()){
                            cont_palabras=cont_palabras+1;
                            posicion=0;
                            pez[palabra_activa].palabra.cargarPalabra(cont_palabras);
                            pez[palabra_activa].palabra.setEstado(0);
                           }
                           
                            
                         }
                            
                            else{
                          
                       System.out.println("Terminaste de escribirrrrr");
                       peces_eliminados+=1;
                       num_peces=num_peces-1;
                       System.out.println("NUMERO DE PECES PRESENTES EN EL MAR= "+num_peces);
                       puntos_pez=pez[palabra_activa].getPuntos();
                       pez[palabra_activa].palabra.setEstado(-1);
                        //buceador.setPuntaje(pez[palabra_activa].getPuntos()); 
                        System.out.println("Puntaje: "+buceador.getPuntaje());
                        pez[palabra_activa].setEstadoVida();
                        pez[palabra_activa].notifyObservers_pezmuere();
                        //pez[palabra_activa].getPane().setVisible(false);
                        //mar.tiburon[palabra_activa].palabra.panelPalabra().setVisible(false);
                        
                        
                            }
                        } 
                   
                   
                   }
                  
                  else {
                        pez[palabra_activa].setVelocidad(20);
                  }
   
              }
              
           }
             
             
             
             
             
             
            }
    }
    
 
    
    @Override
    public void run(){
        
            while(buceador.isBuceadorAlive()==true){
                
                Platform.runLater(new Runnable(){
                    @Override
                   
                    public void run() {
                       
                        nuevoNumeroAleatorioPeces();    
                        if (num_peces!=0){
                        generarPezAleatorio2();
                        }
                            
                            
                            
                          
                          panel_mar.setOnKeyPressed(new KeyPressed());
                            
                       
                           
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
