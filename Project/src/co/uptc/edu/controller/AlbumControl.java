package co.uptc.edu.controller;

import co.edu.uptc.model.Album;
import co.uptc.edu.model.Album;

import java.util.ArrayList;

public class AlbumControl {
    private ArrayList<Album> albums;

    public AlbumControl() {
        albums = new ArrayList<Album>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public boolean añadirAlbum(Album album) {
        if (!albums.contains(album)) {
            albums.add(album);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarAlbum(String nombre) {
        return albums.removeIf(album -> album.getNombre().equals(nombre));
    }
    

    public void actualizarAlbum(Album album, String portada, String nombre, String descripcion, String fechaLanzamiento,
            String genero, String etiquetaRegistro) throws IllegalArgumentException {
        try {
            album.setDescripcion(descripcion);
            album.setEtiquetaRegistro(etiquetaRegistro);
            album.setFechaLanzamiento(fechaLanzamiento);
            album.setGenero(genero);
            album.setNombre(nombre);
            album.setPortada(portada);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error al actualizar el álbum: " + e.getMessage());
        }
    }

    public String obtenerListaAlbumes() {
        StringBuilder listaAlbumes = new StringBuilder();
        if (albums.isEmpty()) {
            listaAlbumes.append("La lista de álbumes está vacía.");
        } else {
            listaAlbumes.append("Lista de Álbumes:\n");
            int i = 1; // Inicializamos el contador
            for (Album album : albums) {
                listaAlbumes.append(i).append(". Nombre: ").append(album.getNombre()).append("\n");
                listaAlbumes.append("   Portada: ").append(album.getPortada()).append("\n");
                listaAlbumes.append("   Descripción: ").append(album.getDescripcion()).append("\n");
                listaAlbumes.append("   Fecha de Lanzamiento: ").append(album.getFechaLanzamiento()).append("\n");
                listaAlbumes.append("   Género: ").append(album.getGenero()).append("\n");
                listaAlbumes.append("   Etiqueta de Registro: ").append(album.getEtiquetaRegistro()).append("\n");
                listaAlbumes.append("\n");
                i++; // Incrementamos el contador
            }
        }
        return listaAlbumes.toString();
    }
    
    

}
