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
 *
 * @author User
 */
public class ArreglosPalabras {
    private ArrayList<String> palabras_archivo ;
    private ArrayList<String> bonus;
    private ArrayList<String> palabras_pulpo ;
    private ArrayList<String> letras ;
    
    /**
     * 
     */
     public ArreglosPalabras(){
        this.palabras_archivo=this.cargarPalabrasArchivo("ListaPalabras.txt");
        this.letras=this.llenarArregloAbecedario();
        this.palabras_pulpo=this.cargarPalabrasArchivo("PalabrasPulpo.txt");
        System.out.println(palabras_archivo.size());
        System.out.println(letras.size());
        System.out.println(palabras_pulpo.size());
        
    }
    
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
      
   
    public int generarAleatorio(int num_final, int num_inicial){
             Random  random = new Random();
             int generar;
             generar=(int) (random.nextDouble() * num_final + num_inicial);
             return generar;
    }
    
    
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
    
   
     public ArrayList<String> arregloPalabrasTiburonesNegro(){
    ArrayList<String> palabras1=this.arregloPalabrasTiburones(5);
    ArrayList<String> palabras2=this.arregloPalabrasTiburones(5);
    ArrayList<String> palabras3=this.arregloPalabrasTiburones(5);
    ArrayList<String> arreglo_final=new ArrayList();
        for (int i=0; i<5;i++){
        arreglo_final.add(palabras1.get(i));
        arreglo_final.add(palabras2.get(i));
        arreglo_final.add(palabras2.get(i));}
    
    return arreglo_final;
    }
    
    
   /**
    public ArrayList<String> arregloPalabrasTiburonesNegro(int num_tiburones){
    ArrayList<String> palabras1=this.arregloPalabrasTiburones(num_tiburones);
    ArrayList<String> palabras2=this.arregloPalabrasTiburones(num_tiburones);
    ArrayList<String> palabras3=this.arregloPalabrasTiburones(num_tiburones);
    ArrayList<String> arreglo_final=new ArrayList();
        for (int i=0; i<num_tiburones;i++){
        arreglo_final.add(palabras1.get(i));
        arreglo_final.add(palabras2.get(i));
        arreglo_final.add(palabras2.get(i));}

    return arreglo_final;
    }
   
   
    
    **/
    
    
    public ArrayList<String> palabraPulpo(){
      ArrayList<String> palabra= new ArrayList<>();
      ArrayList<String> palabras_pulpo = this.cargarPalabrasArchivo("PalabrasPulpo.txt");
      int num=(int)Math.random()*8+0;
      palabra.add(palabras_pulpo.get(num));
      return palabra;
    }
    
    
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
     * @return the palabras_archivo
     */
    public ArrayList<String> getPalabras() {
        return palabras_archivo;
    }

    /**
     * @param palabras the palabras_archivo to set
     */
    public void setPalabras(ArrayList<String> palabras) {
        this.palabras_archivo = palabras;
    }

    /**
     * @return the letras
     */
    public ArrayList<String> getLetras() {
        return letras;
    }

    /**
     * @param letras the letras to set
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
    
     public ArrayList<String> getPalabrasPulpo() {
        return palabras_pulpo;
    }
     
    
   

    
    
    
        
}
