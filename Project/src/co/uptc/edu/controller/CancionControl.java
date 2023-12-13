package co.uptc.edu.controller;

import co.uptc.edu.model.Cancion;

import java.util.ArrayList;
import java.util.List;

public class CancionControl {
    private List<Cancion> canciones;

    public CancionControl() {
        canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        if (cancion != null && !cancion.getNombre().isEmpty()) {
            canciones.add(cancion);
        } else {
            System.out.println("Error: La canción no puede ser nula y debe tener un nombre válido.");
        }
    }

    public void actualizarCancion(String nombreCancion, String nuevaDuracion) {
        for (Cancion cancion : canciones) {
            if (cancion.getNombre().equals(nombreCancion)) {
                cancion.setDuracion(nuevaDuracion);
                System.out.println("Canción actualizada exitosamente.");
                return;
            }
        }
        System.out.println("Error: Canción no encontrada.");
    }

    public void eliminarCancion(String nombre) {
        canciones.removeIf(cancion -> cancion.getNombre().equals(nombre));
    }

    public List<Cancion> obtenerListaCanciones() {
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



