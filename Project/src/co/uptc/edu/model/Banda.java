package co.uptc.edu.model;

import java.util.ArrayList;

public class Banda extends Artista {

  private ArrayList<Artista> artistas;
  private String fechaCreacion;
  private String Nombre;
  private String Genero;
  private String id_banda;

  public Banda(
    String nombre,
    String descripcion,
    String id_artista,
    ArrayList<Artista> artistas,
    String fechaCreacion,
    String nombre2,
    String genero,
    String id_banda
  ) {
    super(nombre, descripcion, id_artista);
    this.artistas = artistas;
    this.fechaCreacion = fechaCreacion;
    Nombre = nombre2;
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
