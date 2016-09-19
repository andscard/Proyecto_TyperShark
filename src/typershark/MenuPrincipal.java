/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package typershark;

import Buceador.Buceador;
import Buceador.Formulario;
import Buceador.TopJugadores;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * La Clase MenúPrincipal contiene diferentes ventanas, posee un mar , un 
 * formulario, un buceador, ayuda.
 * @author Mayken Salavarría Tutivén
 * @author Andrea Cárdenas Sumba
 * 
 * @version 2.0.0
 * 
 */
public class MenuPrincipal {
    
    private Pane panel;
    private Pane panel_formulario;
    private ImageView fondo;
    private VBox vbox;
    private Mar mar;
    private Formulario formulario;
    private Ayuda ayuda;
    private TopJugadores top;
    private Stage stage1,stage2,stage3,stage4;
    private Stage stage_menu;
    private Scene scene1;
    private Scene scene2;
    private Buceador buceador;
    
    /**
     * Constructor de la clase MenuPrincipal(), asigna a Buceador su nombre 
     * de usuario, en caso que el jugador de clic en el boton guardaar
     * sin registrarse este será almacenado como ANONIMO, crea botones,
     * etiquetas, ubica los elementos en el panel.
     */
    public MenuPrincipal(){
    panel= new Pane();
    formulario=new Formulario();
    top=new TopJugadores();
    ayuda= new Ayuda();
    formulario.getBoton().setOnAction(new ClickHandler());
    scene1 = new Scene(this.getMenuPrincipal());
    scene2= new Scene (formulario.getFormulario());
    buceador=new Buceador("Anonimo");
    //stage1= formulario.crearStage();
    stage2= ayuda.crearStage();
    stage3= top.crearStage();
    stage4=this.mensajeNoExistenPartidas();
    stage_menu=new Stage();
    vbox = this.createVbox();
    Button bt_salir = new Button(" SALIR ");
    bt_salir.setFont(Font.font("Amble CN", FontWeight.EXTRA_BOLD, 16));
    bt_salir.setStyle("-fx-base: #FA5858;");
    bt_salir.setTextFill(Color.WHITE);
    bt_salir.setPrefSize(150, 50);
    bt_salir.setShape(new Ellipse(100,25));
    bt_salir.relocate(540, 420);
    bt_salir.setOnAction(new ClickHandler5());
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo9.jpg")));
    panel.getChildren().addAll(fondo,vbox,bt_salir);
    }
    
    /**
     * El método  createVbox() crea el panel principal con todos los
     * botones a presentar: NUEVO JUEGO, REANUDAR PARTIDA, AYUDA y TOP-SCORES,
     * los ubica y se definen sus eventos.
     * @return VBox
     */
     public VBox createVbox(){
     vbox = new VBox(15);
     Ellipse elipse=new Ellipse(100,25);
     
     
     
     Button b1 = new Button("NUEVO JUEGO");
     Button b2 = new Button("REANUDAR JUEGO");
     Button b3 = new Button("AYUDA");
     Button b4 = new Button("TOP-SCORES");
     
     this.formatoBotones(b1, elipse,new ClickHandler1());
     this.formatoBotones(b2, elipse,new ClickHandler2());
     this.formatoBotones(b3, elipse,new ClickHandler3());
     this.formatoBotones(b4, elipse,new ClickHandler4());

     vbox.relocate(160, 215);
     vbox.getChildren().addAll(b1,b2,b3,b4);
     
        return vbox;
    }
     
     /**
      * Este método ajusta los botones y define su funcionalidad
      * @param boton tipo Button
      * @param elipse tipo Ellipse
      * @param click  EventHandler tipo ActionEvent
      */
    public void formatoBotones(Button boton,Ellipse elipse,EventHandler<ActionEvent> click){
     boton.setPrefSize(150, 50);
     boton.setShape(elipse);
     boton.setFont(Font.font("Amble CN", FontWeight.BOLD, 14));
     boton.setStyle("-fx-base: #b6e7c9;");
     boton.setOnAction(click);
    }
     
    /**
     * Este método retorna el panel Principal
     * @return 
     */
    public Pane getMenuPrincipal(){
        return this.panel;}
    
    
    /**
     * Este método ajusta la ventana, ubica la imagen de fondo, e indica que la ventana es reajustable
     * 
     * @return tipo Stage
     */
    public Stage getStageMenu(){
      
      stage_menu.setTitle("Typer Shark");
      stage_menu.getIcons().add(new Image("/Imagenes/tiburon.png"));
      stage_menu.setResizable(true);
      stage_menu.setScene(scene1);
     
    
    return this.stage_menu;}
    
    
    /**
     * Esta clase permite validar el el ingreso del nombre del jugador,
     * en caso de no registrar este se almacena como ANONIMO
     */
    public Stage mensajeNoExistenPartidas(){
    Stage stage=new Stage();
    VBox vbox=new VBox(15);
    vbox.setPadding(new Insets(15));
    Label mensaje_guardar=new Label("!No existen partidas guardadas!");
    Button bt_aceptar= new Button(" ACEPTAR ");
    bt_aceptar.setOnAction(new ClickHandler7());
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
    
    
    //Muestra la escena del mar (nuevo juego) 
    //Le pertenece al botón "GUARDAR"del formulario
    private class ClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
        
        formulario.setNombre(formulario.getTexto().getText());
        if (formulario.getTexto().getText().isEmpty()){
            formulario.setNombre("Anonimo");
        }
            //stage.close();
        mar=new Mar(formulario.getNombre()); 
        
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        stage_menu.setMaximized(false);
        mar.start();
        mar.getButtonRegresar().setOnAction(new ClickHandler6());
        formulario.getTexto().clear();
        }
     }
    
    //Muestra la escena del formulario en la que el jugador escribe su nombre de usuario
    //Le pertece al botón NUEVO NUEGO
    private class ClickHandler1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
        stage_menu.setScene(scene2);
        }
    }
    
    //Reanuda un juego, cargando una partida guardada, si no existen partices, aparece una ventana
    //emergente diciendo que no hay partidas guardadas, le pertenece al botón REANUDAR PARTIDA
     private class ClickHandler2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
         String []info=buceador.leerArchivoPartidas();
         if(info==null){
            stage4.show();
         return;
         }
         mar=new Mar(info[0]);
         boolean arma;
         if (info[4]=="OFF"){arma=false;
         }else{arma=true;}
        mar.getBuceador().setInfoJugador(info[0],Integer.parseInt(info[1]),Integer.parseInt(info[2]),Double.parseDouble(info[3]),
                arma,Integer.parseInt(info[5]));
       
        Scene scene2 = new Scene (mar.getMar());
        stage_menu.setScene(scene2);
        mar.start();
        mar.getButtonRegresar().setOnAction(new ClickHandler6());
         
        }
     }
     
    //Muestra la ventana de ayuda , le pertence al botón AYUDA del menú principal
     private class ClickHandler3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            stage2.show();
        }
    }
    
     /**
      * Top Jugadores
      */
    private class ClickHandler4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
          //  top.escribirArchivoTopJugadores(new Buceador("Mayken"));
            //top.listaTop10Puntajes();
            //top.llenarListViewTopPuntaje();
            //top.llenarListJugadoresNiveles();
            stage3.show();
        }
    }
    
    /**
     * Esta clase permite salir del juego.
     */
    
    private class ClickHandler5 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            System.exit(0);
        }
    }
    
    /**
     * Muestra la ventana del MenúPrincipal
     */
     private class ClickHandler6 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
            stage_menu.setScene(scene1);
        }
     }
     
     //Cierra la venta emergente que indica que no hay partidas guardadas,
     //Le pertene al botón ACEPTAR de dicha ventana
     private class ClickHandler7 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent action) {
            
           stage4.close();
        }
     }
}
