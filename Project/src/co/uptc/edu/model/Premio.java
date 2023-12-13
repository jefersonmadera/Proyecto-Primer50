package co.uptc.edu.model;

public class Premio {
    private String id_premio;
    private String organizacion;
    private String nombre;
    private String descripcion;

    public Premio(String id_premio, String organizacion, String nombre, String descripcion) {
        this.id_premio = id_premio;
        this.organizacion = organizacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getId_premio() {
        return id_premio;
    }

    public void setId_premio(String id_premio) {
        this.id_premio = id_premio;
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
