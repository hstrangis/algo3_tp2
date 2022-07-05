package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controles.ControlesMoverse;
import edu.fiuba.algo3.controles.VerRanking;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Meta;
import edu.fiuba.algo3.modelo.Movimientos;
import edu.fiuba.algo3.modelo.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static edu.fiuba.algo3.vista.App.ANCHO_MAPA;
import static edu.fiuba.algo3.vista.App.LARGO_MAPA;

public class Principal extends Group {
    private MovimientosVista movimientosVista;
    private Juego juego;

    private MapaVista mapa;

    private Stage stage;

   public Principal(Juego juego, Movimientos movimientos, MapaVista mapa, Stage stage){
       this.mapa = mapa;
       this.juego = juego;
       this.stage = stage;
       this.getChildren().add(mapa);
       movimientosVista = new MovimientosVista(movimientos);
       this.getChildren().add(movimientosVista);
   }

   public void inicializar(Scene escena, Vehiculo vehiculo){
       VehiculoVista vehiculoVista = new VehiculoVista(vehiculo, juego.jugador());
       mapa.agregarVehiculo(vehiculoVista);
       ControlesMoverse controles = new ControlesMoverse(juego, movimientosVista, mapa, this);
       escena.setOnKeyPressed(controles);
       vehiculoVista.actualizar();
   }

   public void agregarMeta(Meta meta){
       MetaVista metaVista = new MetaVista(meta);
       mapa.agregarVista(metaVista);
   }

    public void mostrarSalida() {
       Stage stageSalida = new Stage();
       Salida salida = new Salida(juego, stage,stageSalida);
       Scene fin = new Scene(salida,240, 140);
       stageSalida.initModality(Modality.WINDOW_MODAL);
       stageSalida.setScene(fin);
       stageSalida.show();
    }


}
