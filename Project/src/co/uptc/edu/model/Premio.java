package co.uptc.edu.model;

public class Premio {
    String organizacion;
    String nombre;
    String descripcion;

    public Premio(String organizacion, String nombre, String descripcion) {
        this.organizacion = organizacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
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

}
