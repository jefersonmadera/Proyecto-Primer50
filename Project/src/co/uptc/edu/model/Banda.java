package co.uptc.edu.model;

import java.util.ArrayList;

public class Banda {
    private ArrayList<Artista> artistas;
    private String fechaCreacion;
    private String Nombre;
    private String Genero;
    private String id_banda;

    public Banda(ArrayList<Artista> artistas, String nombre, String genero, String fechaCreacion, String id_banda) {
        this.artistas = artistas;
        this.fechaCreacion = fechaCreacion;
        Nombre = nombre;
        Genero = genero;
        this.id_banda = id_banda;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getId_banda() {
        return id_banda;
    }

    public void setId_banda(String id_banda) {
        this.id_banda = id_banda;
    }

}