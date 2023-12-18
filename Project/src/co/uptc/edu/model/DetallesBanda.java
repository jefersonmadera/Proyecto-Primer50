package co.uptc.edu.model;

import java.util.ArrayList;

public class DetallesBanda extends Banda {

  private Banda banda;
  private Musico musico;

  public DetallesBanda(
    String nombre,
    String descripcion,
    String id_artista,
    ArrayList<Artista> artistas,
    String fechaCreacion,
    String nombre2,
    String genero,
    String id_banda,
    Banda banda,
    Musico musico
  ) {
    super(
      nombre,
      descripcion,
      id_artista,
      artistas,
      fechaCreacion,
      nombre2,
      genero,
      id_banda
    );
    this.banda = banda;
    this.musico = musico;
  }

  public Banda getBanda() {
    return banda;
  }

  public Musico getMusico() {
    return musico;
  }
}
