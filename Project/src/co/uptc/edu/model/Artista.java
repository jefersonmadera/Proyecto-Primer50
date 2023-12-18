package co.uptc.edu.model;

public class Artista {

  String nombre;
  String descripcion;
  String id_artista;
  private Banda banda;
  private Musico musico;

  public Artista(String nombre, String descripcion, String id_artista) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.id_artista = id_artista;
  }

  public Banda getBanda() {
    return banda;
  }

  public Musico getMusico() {
    return musico;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getId_artista() {
    return id_artista;
  }

  public void setId_artista(String id_artista) {
    this.id_artista = id_artista;
  }
}
