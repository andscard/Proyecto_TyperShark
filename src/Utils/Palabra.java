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
    private ArrayList<Character> letras ;
    private String archivo_palabras="ListaPalabras.txt";
    private String archivo_bonus;
    
     public Palabra(){
        
           this.palabras=this.llenarArregloPalabras(this.archivo_palabras);;
           this.letras=this.llenarArregloLetras();
        
    }
    
    public ArrayList<String> cargar (String archivo) {
        File reviewFile = new File(archivo);
        ArrayList<String> lineas = new ArrayList<>();
        Scanner reviewScanner = null;
        try {
            reviewScanner = new Scanner(reviewFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Palabra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
        String reviewText;

        while(reviewScanner.hasNext())
        {
            reviewText = reviewScanner.nextLine();
            String cadena = reviewText;
            
            lineas.add(cadena.toLowerCase());
           
        }
        return  lineas;
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
    
   
    public ArrayList<Character> llenarArregloLetras(){
        ArrayList<Character> letras = new ArrayList<Character>();
        ArrayList<Character> abecedario = this.llenarArregloAbecedario();
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
    
    
      public ArrayList<Character> llenarArregloAbecedario(){
     
            ArrayList<Character> letras =new ArrayList<Character>();
            for(int i=65;i<91;i++){
                letras.add((char)i);
                                     
            }
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
    public ArrayList<Character> getLetras() {
        return letras;
    }

    /**
     * @param letras the letras to set
     */
    public void setLetras(ArrayList<Character> letras) {
        this.letras = letras;
    }
     

    
    
    
        
}
