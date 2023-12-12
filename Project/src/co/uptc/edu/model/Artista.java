package co.uptc.edu.model;

public class Artista {
    String nombre;
    String imagen;
    String descripcion;
    String id_artista;

    public Artista(String nombre, String imagen, String descripcion, String id_artista) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.id_artista = id_artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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
