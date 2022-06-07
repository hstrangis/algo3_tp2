package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObstaculosTest {
    @Test
    public void testUnaMotoAtraviesaCiudadYSeEncuentraPozo() {
        //Una moto se desplaza desde el origen hacia el Este, encuentra un pozo y suma 3 movimientos
        Juego juego = new Juego(4,4);
        Vehiculo moto = new Moto();

        juego.agregarElemento(new Pozo(), 0,0, new Este());
        juego.jugar("carlos", moto);
        juego.moverse(new Este());

        assertEquals(4, moto.movimientos);
    }
    @Test
    public void testUnaAutoAtraviesaCiudadYSeEncuentraPozo() {
        //Un auto se desplaza desde el origen hacia el Este, encuentra un pozo y suma 3 movimientos
        Juego juego = new Juego(4,4);
        Vehiculo auto = new Auto();

        juego.agregarElemento(new Pozo(), 0,0, new Este());
        juego.jugar("carlos", auto);
        juego.moverse(new Este());

        assertEquals(4, auto.movimientos);
    }
    @Test
    public void testUna4x4AtraviesaCiudadYSeEncuentraPozo() {
        //Una 4x4 se desplaza desde el origen hacia el Este, encuentra un pozo y no suma movimientos (primer pozo)
        Juego juego = new Juego(4,4);
        Vehiculo camioneta = new CuatroxCuatro();

        juego.agregarElemento(new Pozo(), 0,0, new Este());
        juego.jugar("carlos", camioneta);
        juego.moverse(new Este());

        assertEquals(1, camioneta.movimientos);
    }
    @Test
    public void testUnaMotoAtraviesaCiudadYSeEncuentraPiquete() {
        //Una moto se desplaza desde el origen hacia el Este, encuentra un piquete y suma 2 movimientos
        Juego juego = new Juego(4,4);
        Vehiculo moto = new Moto();

        juego.agregarElemento(new Piquete(), 0,0, new Este());
        juego.jugar("carlos", moto);
        juego.moverse(new Este());

        assertEquals(3, moto.movimientos);
    }
    @Test
    public void testUnaAutoAtraviesaCiudadYSeEncuentraPiquete() {
        //Un auto se desplaza desde el origen hacia el Este, encuentra un piquete y vuelve al origen
        Juego juego = new Juego(4,4);
        Vehiculo auto = new Auto();

        juego.agregarElemento(new Piquete(), 0,0, new Este());
        juego.jugar("carlos", auto);
        juego.moverse(new Este());

        assertEquals(1, auto.movimientos);
        assertEquals(juego.puntoPartida(), juego.puntoJugador());
    }
}
