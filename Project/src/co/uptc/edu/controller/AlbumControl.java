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

  public void actualizarAlbum(
    Album album,
    String portada,
    String nombre,
    String descripcion,
    String fechaLanzamiento,
    String genero,
    String etiquetaRegistro
  ) throws IllegalArgumentException {
    try {
      album.setDescripcion(descripcion);
      album.setEtiquetaRegistro(etiquetaRegistro);
      album.setFechaLanzamiento(fechaLanzamiento);
      album.setGenero(genero);
      album.setNombre(nombre);
      album.setPortada(portada);
    } catch (Exception e) {
      throw new IllegalArgumentException(
        "Error al actualizar el álbum: " + e.getMessage()
      );
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
        listaAlbumes
          .append(i)
          .append(". Nombre: ")
          .append(album.getNombre())
          .append("\n");
        listaAlbumes
          .append("   Portada: ")
          .append(album.getPortada())
          .append("\n");
        listaAlbumes
          .append("   Descripción: ")
          .append(album.getDescripcion())
          .append("\n");
        listaAlbumes
          .append("   Fecha de Lanzamiento: ")
          .append(album.getFechaLanzamiento())
          .append("\n");
        listaAlbumes
          .append("   Género: ")
          .append(album.getGenero())
          .append("\n");
        listaAlbumes
          .append("   Etiqueta de Registro: ")
          .append(album.getEtiquetaRegistro())
          .append("\n");
        listaAlbumes.append("\n");
        i++; // Incrementamos el contador
      }
    }
    return listaAlbumes.toString();
  }

  public void añadirCancion(Album album, Cancion cancion) {
    if (albumCancionesMap.containsKey(album)) {
      List<Cancion> canciones = albumCancionesMap.get(album);
      canciones.add(cancion);
    }
  }

  public boolean eliminarCancion(Album album, Cancion cancion) {
    if (albumCancionesMap.containsKey(album)) {
      List<Cancion> canciones = albumCancionesMap.get(album);
      return canciones.remove(cancion);
    }
    return false;
  }

  public void actualizarCancion(
    Album album,
    Cancion cancionVieja,
    Cancion cancionNueva
  ) {
    if (albumCancionesMap.containsKey(album)) {
      List<Cancion> canciones = albumCancionesMap.get(album);
      if (canciones.contains(cancionVieja)) {
        canciones.remove(cancionVieja);
        canciones.add(cancionNueva);
      }
    }
  }

  public List<Cancion> obtenerCanciones(Album album) {
    return albumCancionesMap.getOrDefault(album, new ArrayList<>());
  }

  // Other existing methods...

  public String obtenerListaCanciones(Album album) {
    List<Cancion> canciones = obtenerCanciones(album);
    StringBuilder listaCanciones = new StringBuilder();

    if (canciones.isEmpty()) {
      listaCanciones.append("No hay canciones para este álbum.");
    } else {
      listaCanciones
        .append("Lista de Canciones para el Álbum ")
        .append(album.getNombre())
        .append(":\n");
      int i = 1;
      for (Cancion cancion : canciones) {
        listaCanciones
          .append(i)
          .append(". Nombre: ")
          .append(cancion.getNombre())
          .append("\n");
        listaCanciones
          .append("   Duración: ")
          .append(cancion.getDuracion())
          .append("\n");
        listaCanciones.append("\n");
        i++;
      }
    }
    return listaCanciones.toString();
  }
}
