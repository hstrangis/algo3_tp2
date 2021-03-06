package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static final int ANCHO_MAPA = 4;

    public static final int LARGO_MAPA = 4;

    //public inicializarVistas
    @Override
    public void start(Stage stage) {
        stage.setTitle("Un paseo en Buenos Aires");
        Juego juego = new Juego(ANCHO_MAPA, LARGO_MAPA);
        Entrada inicio = new Entrada(stage ,juego);
        Scene entrada = new Scene(inicio, 240, 100);
        stage.setScene(entrada);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}