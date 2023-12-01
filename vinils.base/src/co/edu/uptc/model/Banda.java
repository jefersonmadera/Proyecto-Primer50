package co.edu.uptc.model;

import java.util.ArrayList;

public class Banda {
    private ArrayList<Artista> artistas;
    private String fechaCreacion;

    public Banda(ArrayList<Artista> artistas, String fechaCreacion) {
        this.artistas = artistas;
        this.fechaCreacion = fechaCreacion;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

}