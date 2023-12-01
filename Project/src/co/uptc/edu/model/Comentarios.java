package co.uptc.edu.model;

public class Comentarios {
    String descripcion;
    int rating;

    public Comentarios(String descripcion, int rating) {
        this.descripcion = descripcion;
        this.rating = rating;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
