/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @authors
 * Andrea Cárdenas Sumba
 * Mayken Salavarría Tutivén
 * @version 
 * 
 */
package typershark;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Clase TyperShark muestra la ventana de la Aplicación
 * 
 */
public class TyperShark extends Application {
    MenuPrincipal menu=new MenuPrincipal(); 
    Stage stage_menu= menu.getStageMenu();
    @Override
    /**
     * El método start ajusta la ventana a mostrar.
     */
    public void start(Stage stage) {
     
      stage=stage_menu;
      stage.show();
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
