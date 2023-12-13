package co.uptc.edu.controller;

import co.uptc.edu.model.Artista;

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

    public boolean eliminarArtista(String nombre) {
        // Utiliza un bucle para encontrar y eliminar el artista por nombre
        for (Artista artista : artistas) {
            if (artista.getNombre().equals(nombre)) {
                artistas.remove(artista);
                return true;
            }
        }
        return false;
    }

    private Artista buscarArtista(String idArtista) {
        for (Artista artista : artistas) {
            if (artista.getId_artista().equals(idArtista)) {
                return artista;
            }
        }
        return null;
    }
    

}
