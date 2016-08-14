/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author User
 */
public class TyperShark extends Application {
    
    @Override
    public void start(Stage stage) {
      MenuPrincipal menu=new MenuPrincipal();
      MarFX  mar=new MarFX();
      Scene scene2 = new Scene (mar.getMarFX());
      Scene scene1 = new Scene(menu.getMenuPrincipal());
      stage.setTitle("Typer Shark");
      stage.getIcons().add(new Image("/Imagenes/tiburon.png"));
      stage.setResizable(true);
      stage.setScene(scene1);
      stage.show();
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
