package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static edu.fiuba.algo3.vista.MapaVista.*;

public class VehiculoVista extends ImageView {
    private final Vehiculo vehiculo;
    private final Jugador jugador;

    VehiculoVista(Vehiculo vehiculo, Jugador jugador){
        this.vehiculo = vehiculo;
        this.jugador = jugador;
    }

    public void actualizar(){
        Image diseño = new Image("file:src\\main\\java\\resources\\"+ vehiculo.estado() + ".png");
        this.setImage(diseño);
        this.setFitHeight(45);
        this.setFitWidth(45);
        this.setX(INICIAL_X - 10 + jugador.ubicacion().coordenadaX()*DISTANCIA_PUNTOS);
        this.setY(INICIAL_Y - 10 + jugador.ubicacion().coordenadaY()*DISTANCIA_PUNTOS);
    }

}
