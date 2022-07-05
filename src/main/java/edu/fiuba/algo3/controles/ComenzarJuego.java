package edu.fiuba.algo3.controles;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Meta;
import edu.fiuba.algo3.modelo.Movimientos;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.vista.MapaVista;
import edu.fiuba.algo3.vista.Principal;
import edu.fiuba.algo3.vista.SorteadorElementos;
import edu.fiuba.algo3.vista.VehiculoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static edu.fiuba.algo3.vista.App.ANCHO_MAPA;
import static edu.fiuba.algo3.vista.App.LARGO_MAPA;

public class ComenzarJuego implements EventHandler<ActionEvent> {
    private Vehiculo vehiculo;

    private TextField nombre;
    private Stage stage;

    private Movimientos movimientos;

    private Juego juego;


    public ComenzarJuego(Vehiculo vehiculo, Movimientos movimientos, Stage stage, Juego juego){
        this.vehiculo = vehiculo;
        this.stage = stage;
        this.movimientos = movimientos;
        this.juego = juego;
    }

    public void agregarNombreJugador(TextField nombre){
        this.nombre = nombre;
    }

    public void handle(ActionEvent e) {
        Meta meta = new Meta();
        juego.iniciarMapa(meta);
        MapaVista mapa = new MapaVista(ANCHO_MAPA, LARGO_MAPA);
        Principal principal = new Principal(juego, movimientos, mapa, stage);
        principal.agregarMeta(meta);
        new SorteadorElementos(juego, mapa, ANCHO_MAPA, LARGO_MAPA);
        juego.jugar(nombre.getText(), vehiculo);
        stage.close();
        Scene pantallaJuego = new Scene(principal, 940, 1000);
        principal.inicializar(pantallaJuego, vehiculo);
        stage.setScene(pantallaJuego);
        stage.show();
    }
}
