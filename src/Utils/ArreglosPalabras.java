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
            
            letras.add("A");
            letras.add("B");
            letras.add("C");
            letras.add("D");
            letras.add("E");
            letras.add("F");
            letras.add("G");
            letras.add("H");
            letras.add("I");
            letras.add("J");
            letras.add("K");
            letras.add("L");
            letras.add("M");
            letras.add("N");
            letras.add("O");
            letras.add("P");
            letras.add("Q");
            letras.add("R");
            letras.add("S");
            letras.add("T");
            letras.add("U");
            letras.add("V");
            letras.add("W");
            letras.add("X");
            letras.add("Y");
            letras.add("Z");
    
            
     return letras;
     }  
      
   
    public int generarAleatorio(int num_final, int num_inicial){
             Random  random = new Random();
             int generar;
             generar=(int) (random.nextDouble() * num_final + num_inicial);
             return generar;
    }
    
    
    public ArrayList<String> arregloPalabrasTiburones(int nivel){
        ArrayList<String> palabras_archivo=this.cargarPalabrasArchivo("ListaPalabras.txt");
        ArrayList<String> palabras=new ArrayList<String>();
        ArrayList<Character> letras =new ArrayList<Character>();
       
        int aleatorio, cont=0;
        
        while(cont<nivel){
                    aleatorio=this.generarAleatorio(palabras_archivo.size(),0);
                    if(!letras.contains(palabras_archivo.get(aleatorio).charAt(0))){
                         letras.add(palabras_archivo.get(aleatorio).charAt(0));
                         palabras.add(palabras_archivo.get(aleatorio));
                         //palabras_archivo.remove(aleatorio);
                         cont=cont+1;}
                    
        }
                return palabras;
    }
    
    public String palabraPulpo(){
      String palabra;
      ArrayList<String> palabras_pulpo = this.cargarPalabrasArchivo("PalabrasPulpo.txt");
      int num=(int)Math.random()*8+0;
      palabra= palabras_pulpo.get(num);
      return palabra;
    }
    
    
    public ArrayList<String> arregloLetrasPirañas(int nivel){
        ArrayList<String> letras = new ArrayList<String>();
        ArrayList<String> abecedario = this.llenarArregloAbecedario();
        int generar;
        
       
        for(int i=0;i<nivel;i++){
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
