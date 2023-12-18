package co.uptc.edu.model;

public class ColectorDetalles extends Colector {

  private Colector colector;

  public ColectorDetalles(
    String name,
    String telephone,
    String email,
    String nombreUsuario,
    String contrasena,
    Colector colector
  ) {
    super(name, telephone, email, nombreUsuario, contrasena);
    this.colector = colector;
  }

  public Colector getColector() {
    return colector;
  }
}
