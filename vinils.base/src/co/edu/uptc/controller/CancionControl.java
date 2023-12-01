package co.edu.uptc.controller;

import co.edu.uptc.model.Cancion;

import java.util.ArrayList;

public class CancionControl {
    private ArrayList<Cancion> canciones;

    public CancionControl() {
        canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public void actualizarCancion(String nombre, String nuevaDuracion) {
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombre)) {
                cancion.setDuracion(nuevaDuracion);
                break;
            }
        }
    }

    public void eliminarCancion(String nombre) {
        canciones.removeIf(cancion -> cancion.getNombre().equals(nombre));
    }

    public ArrayList<Cancion> obtenerListaCanciones() {
        return new ArrayList<>(canciones);
    }

    public Cancion buscarCancion(String nombre) {
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombre)) {
                return cancion;
            }
        }
        return null; // Si no se encuentra la canción
    }
}


