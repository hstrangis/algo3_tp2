package edu.fiuba.algo3.vista;


import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class MapaVista extends Group {
    static final int INICIAL_X = 270;
    static final int INICIAL_Y = 250;

    static final int DISTANCIA_PUNTOS = 190;

    private VehiculoVista vehiculo;

    private final List<SorpresaVista> sorpresas;

    public MapaVista(int largo, int ancho){
        sorpresas = new ArrayList<>();
        for (int fila = 0; fila < largo; fila++) {
            for (int columna = 0; columna < ancho; columna++) {
                this.getChildren().add(new Rectangle(130 + columna*190, 110 + fila*190, 120,120));
            }
        }
    }

    public void agregarVehiculo(VehiculoVista vehiculo){
        this.vehiculo = vehiculo;
        this.getChildren().add(vehiculo);
    }

    public void agregarSorpresa(SorpresaVista sorpresa){
        sorpresas.add(sorpresa);
        this.getChildren().add(sorpresa);
    }

    public void agregarVista(ImageView vista){
        this.getChildren().add(vista);
    }


    public void actualizar(){
        vehiculo.actualizar();
        for (SorpresaVista sorpresa : sorpresas){
            sorpresa.actualizar();
        }
    }
}
