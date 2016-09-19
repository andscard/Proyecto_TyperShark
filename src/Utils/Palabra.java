/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


/**
 *La clase Palabra tiene almacenada funciones como: leer el arreglo de palabras
 * de un Pez, conocer el numero de palabras que posea, ajustar la palabra
 * en un panel, crear arreglo de labels con las letras de la palabra o
 * caracter, conocer la posicion del caracter que está siendo presionado
 * por teclado, conocer el estado de la palabra.
 * @author User
 */
public class Palabra  {
    private int num_palabras;
    private ArrayList<String> lista_palabras;
    private String palabra;
    private Label []label_letras;
    private  int posicion;
    private int estado;
    private HBox panel;
   
    
    /**
     * Constructor de la clase Palabra asigna el numero de palabras
     * de acuerdo al ArrayList enviado por parámetros, obtiene la
     * palabra, asigna la posición en cero (indica que para que un Pez
     * sea seleccionado se debe comparar la tecla presionada con
     * el primer caracter de la palabra), el estado de la palabra inicialmente
     * es cero ya que la palabra no se está escribiendo.
     * @param palabra tipo ArrayList String
     */
    
     public Palabra(ArrayList<String>palabras) {
        this.lista_palabras = palabras;
        this.num_palabras= palabras.size();
        this.palabra = palabras.get(0);
        this.posicion=0;
        this.estado=0;
        this.llenarArregloLetras();
        this.panel=new HBox(); 
        this.cargarPalabra(0);
    }
   
    
     /**
      * El método getEstado() nos retorna el estado de una palabra. Esto es:
      *  
      * EstadoPalabra=0 -> la palabra que tiene el pez no ha sido escrita
      * EstadoPalabra=1 -> la palabra que tiene el pez está siendo escrita
      * EstadoPalabra=-1 -> la palabra que tiene el pez ya se escribió
      * @return estado tipo entero
      */
     public int getEstado() {
        return estado;
    }

     /**
      * El método setEstado(int estado) permite cambiar el estado de una
      * palabra. Esto es :
      * EstadoPalabra=0 -> la palabra que tiene el pez no ha sido escrita
      * EstadoPalabra=1 -> la palabra que tiene el pez está siendo escrita
      * EstadoPalabra=-1 -> la palabra que tiene el pez ya se escribió
      * @param estado tipo entero
      */
    public void setEstado(int estado) {
        this.estado = estado;
    }
  
    /**
     * El método getPalabra() nos retorna una palabra.
     * @return palabra tipo String
     */
    
    public String getPalabra() {
        return palabra;
    }
  
    
    /**
     * El método  setPalabra(String nueva_palabra) cambia la palabra
     * por una nueva.
     * @param nueva_palabra tipo String 
     */
    
    public void setPalabra(String nueva_palabra) {
         this.palabra=nueva_palabra;
    }
  
 
    /**
     * El método cargarPalabra(int indice_palabra), es utilizada
     * cuando un pez posee un ArrayList con 2 o tres palabras, es decir 
     * cuando se trata de un pez tipo TiburonNegro, se debe cargar una nueva
     * palabra, actualizar el arreglo de Labels y el estado de la palabra.
     * @param indice_palabra 
     */
    public void cargarPalabra(int indice_palabra) {
           this.setPalabra(this.lista_palabras.get(indice_palabra));
           this.setEstado(0);
           this.llenarArregloLetras();
           this.addPalabraPanel();
    }
    
    /**
     * El método eliminarPalabra(int indice_palabra), elimina una palabra
     * que fue fue escrita.
     * @param indice_palabra tipo entero
     */
    
     public void eliminarPalabra(int indice_palabra) {
           this.lista_palabras.remove(indice_palabra);
           this.setNum_palabras(this.lista_palabras.size());
  }
    
    
    
    
    
    /**
     * El método getLongitudPalabra() permite conocer la longitud de la palabra
     * del Pez
     * @return longitud de la palbra tipo de dato dato
     */
    public int  getLongitudPalabra() {
        return palabra.length();
    }

    /**
     * Ek método getLabel(), permite obtener un arreglo tipo Label de 
     * del caracter o de cada una de las letras que forman la palabra del pez.  
     * @return label_letras tipo de dato Label
     */
    public Label[] getLabel() {
        return label_letras;
    }
    
    
    /**
     * El método llenarArregloLetras() llena un arreglo de Labels de acuerdo
     * a la longitud de la palabra, seteando el tipo de fuente, color y tamaño.
     */
    public void llenarArregloLetras(){
         label_letras= new Label[this.palabra.length()];
         String pal;         
         for( int i=0;i<palabra.length();i++){
             pal=String.valueOf(palabra.charAt(i));
              label_letras[i]=new Label(pal);  
              label_letras[i].setFont(new Font("Arial", 20));
              label_letras[i].setTextFill(Color.YELLOW);
             
            }
    }
    
    /**
     * El método cambiarColorLetras( int posicion ) permite cambiar el color
     * de la etiqueta a ROJO cuando el caracter presionado coincide con
     * el caracter a analizar.
     * @param posicion tipo entero, posición del caracter a analizar
     */
    public void cambiarColorLetras( int posicion ){
                 label_letras[posicion].setTextFill(Color.RED);
          
    }

    
    /*public HBox panelPalabra(){
         HBox palabras = new HBox();
         palabras.getChildren().addAll(label_letras);
         
         return palabras;
    }*/
    
    
    
    /**
     * El método setPanel(HBox panel) permite cambiar el panel de Palabra
     * @param panel tipo HBox, panel a cambiar
     */
    public void setPanel(HBox panel) {
        this.panel = panel;
    }

     /**
       * El método panelPalabra() permite retornar el panel de la palabra.
       * @return panel tipo HBox.
       */
          
   public HBox panelPalabra(){
        return this.panel;}
    
   /**
    * El método addPalabraPanel() permite añadir nuevas palabras
    * al panel(en el caso que el pez sea tipo TiburonNegro ya que posee
    * de 2 a 3 palabras)
    */
    public void addPalabraPanel(){
    this.panel.getChildren().addAll(this.label_letras);}
    
    
    /**
     * El método getPosicion() indica la posicion de la letra a escribir por teclado.  
     * @return posicion tipo entero
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * El método setPosicion(int posicion_actual) indica la nueva posicion
     * de la letra a presionar.
     * @param posicion_actual tipo de dato entero
     */
    public void setPosicion(int posicion_actual) {
        this.posicion = posicion_actual;
    }

    /**
     * El método  getNum_palabras() nos retorna el numero de palabras que
     * posee el Pez.
     * @return the num_palabras tipo entero
     */
    public int getNum_palabras() {
        return num_palabras;
    }

    /**
     * El método setNum_palabras(int num_palabras) permite cambiar el numero
     * de palabras.
     * @param num_palabras tipo entero
     */
    public void setNum_palabras(int num_palabras) {
        this.num_palabras = num_palabras;
    }

    /**
     * El método  listaVaciaPalabras() nos permite conocer si la lista de
     * palabras del pez a analizar está vacía, es decir que si todas
     * su palabras ya fueron escritas
     * 
     * @return dato booleano
     * true -> listaVacia
     * 
     */
    public boolean  listaVaciaPalabras() {
        return this.lista_palabras.isEmpty();
    }

  
         


   
}
  
                      
    
    
  
    
