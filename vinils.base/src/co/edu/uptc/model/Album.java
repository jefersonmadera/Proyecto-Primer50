package co.edu.uptc.model;

public class Album {
    String portada;
    String nombre;
    String descripcion;
    String fechaLanzamiento;
    String genero;
    String etiquetaRegistro;

    public Album(String portada, String nombre, String descripcion, String fechaLanzamiento, String genero,
            String etiquetaRegistro) {
        this.portada = portada;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
        this.genero = genero;
        this.etiquetaRegistro = etiquetaRegistro;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
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

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEtiquetaRegistro() {
        return etiquetaRegistro;
    }

    public void setEtiquetaRegistro(String etiquetaRegistro) {
        this.etiquetaRegistro = etiquetaRegistro;
    }

}
