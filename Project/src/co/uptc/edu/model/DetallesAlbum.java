package co.uptc.edu.model;

public class DetallesAlbum extends Album {
    private Album album; 

    public DetallesAlbum(String portada, String nombre, String descripcion, String fechaLanzamiento, String genero,
            String etiquetaRegistro, Album album) {
        super(portada, nombre, descripcion, fechaLanzamiento, genero, etiquetaRegistro);
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

}
