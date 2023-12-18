package co.uptc.edu.model;

import java.util.Date;

public class Musico extends Artista {

  private Date fechaNacimiento;

  public Musico(
    String nombre,
    String descripcion,
    String id_artista,
    Date fechaNacimiento
  ) {
    super(nombre, descripcion, id_artista);
    this.fechaNacimiento = fechaNacimiento;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
}
