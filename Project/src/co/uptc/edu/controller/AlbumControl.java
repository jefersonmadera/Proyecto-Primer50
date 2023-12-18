package co.uptc.edu.controller;

import co.uptc.edu.model.Album;
import co.uptc.edu.model.Cancion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumControl {
    private ArrayList<Album> albums;
    private Map<Album, List<Cancion>> albumCancionesMap;

    public AlbumControl() {
        albums = new ArrayList<>();
        albumCancionesMap = new HashMap<>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public boolean añadirAlbum(Album album) {
        if (!albums.contains(album)) {
            albums.add(album);
            albumCancionesMap.put(album, new ArrayList<>()); // Initialize the list of songs for the album
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarAlbum(String nombre) {
        return albums.removeIf(album -> album.getNombre().equals(nombre));
    }

    public void agregarCancion(Album album, Cancion cancion) {
        if (albumCancionesMap.containsKey(album)) {
            List<Cancion> canciones = albumCancionesMap.get(album);
            canciones.add(cancion);
        }
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
