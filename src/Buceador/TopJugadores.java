/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buceador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author User
 */
public class TopJugadores {
    private ListView<String> lista;
    private ArrayList <Buceador> top_buceadores;
    private Pane panel;
    private ImageView fondo;
    private ObservableList<String> nombres;
    
    public TopJugadores (){
    this.panel=new Pane();
    this.lista=new ListView<String>();
    nombres =FXCollections.observableArrayList ();
    this.top_buceadores= new ArrayList<Buceador>(10);
    fondo=new ImageView(new Image(getClass().getResourceAsStream("/Imagenes/fondo10.jpg"),800,700,true,true));
    panel.getChildren().addAll(fondo,lista);
    
    }
    

       
    public void escribirArchivoTop(Buceador buceador ){
    try{
        File file=new File ("TopJugadores.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
         
        bw.write(buceador.infoJugadorPuntaje());
        bw.newLine();
        bw.flush();
        bw.close();
            
    }catch(IOException ex){
        System.out.println("No se pudo escribir en el archivo TopJugadores.txt");}
    }
            
    public  ArrayList<Buceador> listaJugadores(){
    try {  
    File file=new File ("TopJugadores.txt");
    ArrayList<Buceador> lista_jugadores =new  ArrayList<Buceador>();
    Scanner scanner = new Scanner(file);
    Buceador b1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                b1=new Buceador(info[0]);
                b1.setPuntaje(Integer.parseInt(info[1]));
                lista_jugadores.add(b1);
            }
            Collections.sort(lista_jugadores);
            return lista_jugadores;
        } catch (IOException ex) {
            System.out.println("El archivo no existe");
            return null;
        }
    }
    
    public void listaTopJugadores(){
        ArrayList<Buceador> lista_jugadores=this.listaJugadores();
        
        if (lista_jugadores.size()<10){
            for (int i=0; i<lista_jugadores.size();i++){
            this.top_buceadores.add(lista_jugadores.get(i));
            }
        }else{
            for (int i=0; i<10;i++){
                this.top_buceadores.add(lista_jugadores.get(i));
            }
        }
    }
    
    public void llenarListView(){
    int n=this.top_buceadores.size();
        for (int i=0; i<n;i++){
        nombres.add(top_buceadores.get(i).infoJugadorPuntaje());
        this.lista.setItems(nombres);}
    }
   
   
   
   
}
