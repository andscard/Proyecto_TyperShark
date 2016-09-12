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
        nivel=3;
        buceador= new Buceador(name);
        velocidad=0;
        num_peces=(int)(new Random().nextDouble()*5+1);
        System.out.println(this.num_peces);
        //barra=this.crearToolBar();
        this.barra=buceador.getToolBar();
        arreglo_palabras= new ArreglosPalabras();
        this.tiburon= new Tiburon[this.num_peces];
        this.tiburon_negro= new TiburonNegro[this.num_peces];
        this.piraña= new Piraña[this.num_peces];
        this.pulpo=new Pulpo[1];
        
        panel_peces_buceador=this.setPanelPeces();
        
        panel_mar.setCenter(panel_peces_buceador);
        panel_mar.setTop(barra);
        

        panel_mar.setOnKeyPressed(new KeyPressed());
        
        
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
    this.generarPezAleatorio();
    
    //music= new MediaPlayer(new Media(getClass().getResource("burbujas.mp3").toExternalForm()));
    //music.setAutoPlay(true);

    return panel_peces_buceador;
    }

   /* public ToolBar crearToolBar() {
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
        Label lb_nivel = new Label("NIVEL: ");
        lb_nivel.setFont(Font.font("Myriad Pro", FontWeight.BOLD, 14));
        lb_nivel.setTextFill(Color.DARKBLUE);
        
        Button bt_guardar= new Button("GUARDAR");
        bt_guardar.setOnAction(new ClickHandler());
        Label puntaje = new Label(String.valueOf(this.buceador.getPuntaje()));
        Label vidas = new Label(String.valueOf(this.buceador.getVidas()));
        Label metros = new Label(String.valueOf(this.buceador.getMetros()));
        Label nivel = new Label(String.valueOf(this.nivel));
        Label arma = new Label("OFF");
        this.barra.getItems().addAll(coin, lb_puntaje, puntaje, new Separator(), heart, lb_vidas, vidas, new Separator(), 
                lb_metros, metros, new Separator(), bomba, lb_arma, arma,new Separator(),lb_nivel,nivel,new Separator(),bt_guardar);
        //this.barra.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
       /* vidas.textProperty().addListener((new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            }
            
}));
  vidas.textProperty().bind(new SimpleIntegerProperty(this.buceador.getVidas()).asString());
      
        return this.barra;
    }*/

    
    /**
     * 
     * @return 
     */
    public BorderPane getMar() {
        return this.panel_mar;
    }

    public void arregloDeTiburones() {
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburones(num_peces);
        ArrayList<String> una_palabra= new ArrayList();
        for (int i = 0; i < palabras_tiburones.size(); i++) {
            una_palabra.add(palabras_tiburones.get(i));
            this.tiburon[i] = new Tiburon(10,velocidad +2 , 730, 20+cont ,una_palabra );
            this.tiburon[i].start();
            una_palabra.clear();
    
        cont= cont+90;
        }

    }

    /**
    public void arregloDeTiburonesNegros() {
        int cont=0;
        ArrayList<String> palabras_tiburones= arreglo_palabras.arregloPalabrasTiburonesNegro(num_peces);
        ArrayList<String> lista_words= new ArrayList<String>();
        
        for (int i = 0; i < this.num_peces; i++) {
            this.tiburon_negro[i] = new TiburonNegro(10, velocidad+2,730, cont + 20,null);
            this.tiburon_negro[i].setListaPalabras(lista_words);
            TiburonNegro tiburon=(TiburonNegro)this.tiburon_negro[i];

            if (tiburon.getNumeroPalabras()<3){
                tiburon_negro[i].addAListaPalabras(palabras_tiburones.get(0));
                tiburon_negro[i].addAListaPalabras(palabras_tiburones.get(1));
                palabras_tiburones.remove(0);
                palabras_tiburones.remove(1);
                palabras_tiburones.remove(2);
            }else{
                tiburon_negro[i].addAListaPalabras(palabras_tiburones.get(0));
                tiburon_negro[i].addAListaPalabras(palabras_tiburones.get(1));
                tiburon_negro[i].addAListaPalabras(palabras_tiburones.get(2));
                palabras_tiburones.remove(0);
                palabras_tiburones.remove(1);
                palabras_tiburones.remove(2);
            }
            this.tiburon_negro[i].start();
            cont=cont+90;
        }
    }
**/
    
    
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
            this.tiburon_negro[i].start();
            
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
        int cont=0;
        ArrayList<String> letras_pirañas= arreglo_palabras.arregloLetrasPirañas(num_peces);
        ArrayList<String> una_letra= new ArrayList();
        for (int i = 0; i < letras_pirañas.size(); i++) {
                una_letra.add(letras_pirañas.get(i));
                this.piraña[i] = new Piraña(5,velocidad +3, 740, cont + 20, una_letra);
                this.piraña[i].start();
                una_letra.clear();
                cont=cont+70;           
        }
    }
    
    public void pulpo (){
        
        ArrayList<String>palabra=arreglo_palabras.palabraPulpo();
        this.pulpo[0]=new Pulpo(25,2.5,650,40,palabra);
        this.pulpo[0].start();
    }
    
    
    public void ubicarPecesMar(Pane mar,Pez pez[]){
        for (int i=0; i<this.num_peces ;i++){
             mar.getChildren().addAll(pez[i].getPane());
        }
    }
    
    
    public void disminuirVidas(){
    for (Pez t: tiburon){
        if(t.getPoscion().getPos_x()==-720){
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
    
    
   /* private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
        }
    }*/
    
    
    
    private class KeyPressed implements EventHandler<KeyEvent> {
        private Pez pez[]=pez_mar;

        
        @Override
                
            public void handle(KeyEvent event) {
             int posicion_palabra;
             int palabra_activa = -1;
             int contador=pez.length; 
             int cont=0;
           
             if(contador!=-1){   
                     for(int i=0;i<contador;i++){
                  if (pez[i].palabra.getEstado()==1)
                    palabra_activa = i;
              }
                  
              if(palabra_activa==-1){
                  for(int i=0;i<contador;i++){
                      if(pez[i].palabra.getEstado()==0){
                        if (event.getText().charAt(0)==pez[i].palabra.getPalabra().charAt(0)){
                                 pez[i].palabra.setEstado(1);
                                 pez[i].palabra.cambiarColorLetras(0); 
                                 
                                if(pez[i].palabra.getLongitudPalabra()==1){
                                    pez[i].palabra.setPosicion(0);
                                    cont=1;
                                }
                                    else{
                                 pez[i].palabra.setPosicion(1);}
                                
                                
                                
                        }
                      }
                    }
              }
              else{
                  
                  cont=pez[palabra_activa].palabra.getPosicion();
                  
                  if (event.getText().charAt(0)==pez[palabra_activa].palabra.getPalabra().charAt(cont)){
                       
                    if(cont <pez[palabra_activa].palabra.getLongitudPalabra()){
                            if (event.getText().charAt(0)==pez[palabra_activa].palabra.getPalabra().charAt(cont) ){
                       
                        pez[palabra_activa].palabra.cambiarColorLetras(cont);
                        cont=cont+1; 
                        pez[palabra_activa].palabra.setPosicion(cont);
                     }
                         
                   }
                      if(cont ==pez[palabra_activa].palabra.getLongitudPalabra()){
                          System.out.println("Terminaste de escribirrrrr");
                         System.out.println("Puntaje: "+buceador.getPuntaje());
                        buceador.setPuntaje(pez[palabra_activa].getPuntos()+buceador.getPuntaje());
                        pez[palabra_activa].setEstado();
                        pez[palabra_activa].getPane().setVisible(false);
                        //mar.tiburon[palabra_activa].palabra.panelPalabra().setVisible(false);
                       
                        pez[palabra_activa].palabra.setEstado(-1);
                        

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
        
            while(true){
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                       
                       getMar();    
                    }
                    
                });
               
            }
        
    
    }
    


}
