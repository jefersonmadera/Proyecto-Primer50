package co.edu.uptc.controller;

import co.edu.uptc.model.Artista;

import java.util.ArrayList;

public class ArtistaControl {
    private ArrayList<Artista> artistas;

    public ArtistaControl() {
        artistas = new ArrayList<>();
    }

    public boolean añadirArtista(Artista artista) {
        if (!artistas.contains(artista)) {
            artistas.add(artista);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Artista> obtenerListaArtistas() {
        return new ArrayList<>(artistas);
    }

    // En la clase ArtistaControl

    public boolean eliminarArtista(String nombre) {
        Artista artistaEliminar = new Artista(nombre, null, null);
        return artistas.remove(artistaEliminar);
    }

}
