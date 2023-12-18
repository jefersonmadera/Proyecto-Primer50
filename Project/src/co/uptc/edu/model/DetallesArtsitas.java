package co.uptc.edu.model;

public class DetallesArtsitas extends Artista {
    private Artista artista;

    public DetallesArtsitas(String nombre, String descripcion, String id_artista, Artista artista) {
        super(nombre, descripcion, id_artista);
        this.artista = artista;
    }


    public Artista getArtista() {
        return artista;
    }

}
