package co.uptc.edu.model;

public class DetallesPremio {
    private Artista artista;
    private Premio premio;
    private String idArtista;  // Identificador único del artista en esta relación

    public DetallesPremio(Artista artista, Premio premio, String idArtista) {
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
