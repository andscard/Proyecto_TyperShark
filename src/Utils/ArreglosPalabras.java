/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *La clase ArreglosPalabras tiene almacenada funciones como: leer archivo
 * con las palabras y guardalas en archivos de acuerdo al numero de peces
 * que se generen.
 * @author User
 */
public class ArreglosPalabras {
    private ArrayList<String> palabras_archivo ;
    private ArrayList<String> bonus;
    private ArrayList<String> palabras_pulpo ;
    private ArrayList<String> letras ;
    
    /**
     * Constructor de la clase ArregloPalabras crea diferenetes arraylist de
     * con palabras de los tiburones, pulpo y las letras de abecedario
     * que son los caracteres que poseen las pirañas.
     */
     public ArreglosPalabras(){
        this.palabras_archivo=this.cargarPalabrasArchivo("ListaPalabras.txt");
        this.letras=this.llenarArregloAbecedario();
        this.palabras_pulpo=this.cargarPalabrasArchivo("PalabrasPulpo.txt");
        System.out.println(palabras_archivo.size());
        System.out.println(letras.size());
        System.out.println(palabras_pulpo.size());
        
    }
    
     
    /**
     * El método cargarPalabrasArchivo pemite leer un archivo y crea
     * un ArrayList con todas palabras leídas.
     * @param file tipo File, archivo a leer
     * @return retorna el arreglo con las palabras leidas
     */

    public ArrayList<String> cargarPalabrasArchivo (String file) {
        try {
        File reviewFile = new File(file);
        ArrayList<String> lineas = new ArrayList<>();
        Scanner reviewScanner = new Scanner(reviewFile);
        String palabra;
        
        while(reviewScanner.hasNext()){
            palabra = reviewScanner.nextLine();
            lineas.add(palabra.toLowerCase());
        }
         return  lineas; 
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArreglosPalabras.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    

   
    /**
     * El método llenarArregloAbecedario() permite crear un arreglo y que
     * este sea llenado con todas las letras del abecedario.
     * @return ArrayList con las letras del abecedario 
     */
    
      public ArrayList<String> llenarArregloAbecedario(){
     
            ArrayList<String> letras =new ArrayList<String>();
            
            letras.add("a");
            letras.add("b");
            letras.add("c");
            letras.add("d");
            letras.add("e");
            letras.add("f");
            letras.add("g");
            letras.add("h");
            letras.add("i");
            letras.add("j");
            letras.add("k");
            letras.add("l");
            letras.add("m");
            letras.add("n");
            letras.add("o");
            letras.add("p");
            letras.add("q");
            letras.add("r");
            letras.add("s");
            letras.add("t");
            letras.add("u");
            letras.add("v");
            letras.add("w");
            letras.add("x");
            letras.add("y");
            letras.add("z");
    
            
     return letras;
     }  
      
   /**
    * El método generarAleatorio permite generar un numero aleatorio definido
    * en un rango determinado
    * @param num_final tipo entero numero final
    * @param num_inicial tipo entero numero inicial
    * @return retorna un numero tipo entero
    */
      
    public int generarAleatorio(int num_final, int num_inicial){
             Random  random = new Random();
             int generar;
             generar=(int) (random.nextDouble() * num_final + num_inicial);
             return generar;
    }
    
    /**
     * El método arregloPalabrasTiburones(int num_tiburones) nos retorna
     * un ArrayList con las palabras de los tiburones, de acuerdo al 
     * numero de peces tipo Tiburon que aparecerán en el panel.
     * @param num_tiburones tipo entero
     * @return ArrayList con palabras para los tiburones
     */
    public ArrayList<String> arregloPalabrasTiburones(int num_tiburones){
        ArrayList<String> palabras_archivo=this.cargarPalabrasArchivo("ListaPalabras.txt");
        ArrayList<String> palabras=new ArrayList<String>();
        ArrayList<Character> letras =new ArrayList<Character>();
       
        int aleatorio, cont=0;
        
        while(cont<num_tiburones){
                    aleatorio=this.generarAleatorio(palabras_archivo.size(),0);
                    if(!letras.contains(palabras_archivo.get(aleatorio).charAt(0))){
                         letras.add(palabras_archivo.get(aleatorio).charAt(0));
                         palabras.add(palabras_archivo.get(aleatorio));
                         //palabras_archivo.remove(aleatorio);
                         cont=cont+1;}
                    
        }
                return palabras;
    }
    
      /**
     * El método arregloPalabrasTiburonesNegros() nos retorna
     * un ArrayList con tres palabras para cada pez tipo TiburonNegro que
     * aparecerá en el panel/
     * 
     * @return ArrayList con palabras para los tiburones
     */
    public ArrayList<String> arregloPalabrasTiburonesNegro(){
      ArrayList<String> palabras=this.arregloPalabrasTiburones(3);
          
    return palabras;
    }
    
    
  /**
     * El método palabraPulpo() nos retorna
     * un ArrayList la palabra de Pulpo, extraída de una archivo
     * 
     * @return ArrayList con palabras para los tiburones
     */
    
    public ArrayList<String> palabraPulpo(){
      ArrayList<String> palabra= new ArrayList<>();
      ArrayList<String> palabras_pulpo = this.cargarPalabrasArchivo("PalabrasPulpo.txt");
      int num=(int)(Math.random()*9)+0;
      System.out.println("NUMERO PALABRAS PULPO= "+num);
      palabra.add(palabras_pulpo.get(num));
      return palabra;
    }
    
   
     /**
     * El método  arregloLetrasPirañas(int num_pirañas) nos retorna
     * un ArrayList con las letras de las pirañas, de acuerdo al 
     * numero de peces tipo Piraña que aparecerán en el panel.
     * @param num_pirañas tipo entero
     * @return ArrayList con letras para las pirañas
     */
   
    public ArrayList<String> arregloLetrasPirañas(int num_pirañas){
        ArrayList<String> letras = new ArrayList<String>();
        ArrayList<String> abecedario = this.llenarArregloAbecedario();
        int generar;
        
       
        for(int i=0;i<num_pirañas;i++){
                    generar=this.generarAleatorio(abecedario.size(),0);
                    letras.add(abecedario.get(generar));
                    abecedario.remove(generar);
        }
                return letras;
    }
    

    /**
     * El método getPalabras() nos retorna el ArrayList de las palabras para
     * los tiburones extraídas del archivo.
     * @return the palabras_archivo
     */
    public ArrayList<String> getPalabras() {
        return palabras_archivo;
    }

    /**
     * El método setPalabras cambia el ArrayList a leer.
     * @param palabras the palabras_archivo to set
     */
    public void setPalabras(ArrayList<String> palabras) {
        this.palabras_archivo = palabras;
    }

    /**
     * El método getLetras() retorna el ArrayList con las letras
     * para las pirañas
     * @return the letras tipo ArrayList
     */
    public ArrayList<String> getLetras() {
        return letras;
    }

    /**
     * El método setLetras() permite cambiar el ArrayList con las letras
     * para las pirañas que saldrán en otro nivel.
     * @param letras tipo ArrayList String
     */
    public void setLetras(ArrayList<String> letras) {
        this.letras = letras;
    }
    
    
    /*public ArrayList<String> arregloTiburones(String word){
       ArrayList<String> arregloTiburones= new ArrayList();
       arregloTiburones.add(word);
       
       return arregloTiburones;
    }
    
     public ArrayList<String> arregloTiburonesNegros(){
    }*/
    
    
    /**
     * El método getPalabrasPulpo() retorna el ArrayList con las palabras
     * para el pulpo.
     * @return the letras tipo ArrayList
     */
     public ArrayList<String> getPalabrasPulpo() {
        return palabras_pulpo;
    }
     
    
   

    
    
    
        
}
