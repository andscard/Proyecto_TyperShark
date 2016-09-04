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
public class Palabra {
    private ArrayList<String> palabras ;
    private ArrayList<String> bonus ;
    private ArrayList<String> letras ;
    private String archivo_palabras="ListaPalabras.txt";
    private String archivo_bonus;
    
     public Palabra(){
        
           this.palabras=this.llenarArregloPalabras(this.archivo_palabras);;
           this.letras=this.llenarArregloLetras();
        
    }
    
    public ArrayList<String> cargar (String archivo) {
        try {
        File reviewFile = new File(archivo);
        ArrayList<String> lineas = new ArrayList<>();
        Scanner reviewScanner = new Scanner(reviewFile);
        
        String palabra;

        while(reviewScanner.hasNext())
        {
            palabra = reviewScanner.nextLine();
            lineas.add(palabra.toLowerCase());
        }
        
         return  lineas; 
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Palabra.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    
    
    
    public ArrayList<String> llenarArregloPalabras(String archivo ){
        ArrayList<String> lineas=this.cargar(archivo);
        ArrayList<String> palabras=new ArrayList<String>();
        ArrayList<Character> letras =new ArrayList<Character>();
       
        int generar, cont=0;
        
        while(cont<5){
                    generar=this.generarAleatorio(lineas.size(),0);
                    if(!letras.contains(lineas.get(generar).charAt(0))){
                         letras.add(lineas.get(generar).charAt(0));
                         palabras.add(lineas.get(generar));
                         lineas.remove(generar);
                         cont=cont+1;}
                    
        }
                return palabras;
    }
    
   
    public ArrayList<String> llenarArregloLetras(){
        ArrayList<String> letras = new ArrayList<String>();
        ArrayList<String> abecedario = this.llenarArregloAbecedario();
        int generar;
        
       
        for(int i=0;i<10;i++){
                    generar=this.generarAleatorio(abecedario.size(),0);
                    letras.add(abecedario.get(generar));
                    abecedario.remove(generar);
        }
                return letras;
    }
    
    
    
    
    
    
    
    
    
       
    public int generarAleatorio(int num_final, int num_inicial){
             Random  random = new Random();
             int generar;
             generar=(int) (random.nextDouble() * num_final + num_inicial);
             return generar;
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
   
    
    
    
    

    /**
     * @return the palabras
     */
    public ArrayList<String> getPalabras() {
        return palabras;
    }

    /**
     * @param palabras the palabras to set
     */
    public void setPalabras(ArrayList<String> palabras) {
        this.palabras = palabras;
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
     

    
    
    
        
}
