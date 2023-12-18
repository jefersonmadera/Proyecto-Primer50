package co.uptc.edu.model;

public class DetallesPremio extends Premio {
    private Artista artista;
    private Premio premio;
    private String idArtista;  // Identificador único del artista en esta relación

    

    public DetallesPremio(String id_premio, String organizacion, String nombre, String descripcion, Artista artista,
            Premio premio, String idArtista) {
        super(id_premio, organizacion, nombre, descripcion);
        this.artista = artista;
        this.premio = premio;
        this.idArtista = idArtista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }
}
