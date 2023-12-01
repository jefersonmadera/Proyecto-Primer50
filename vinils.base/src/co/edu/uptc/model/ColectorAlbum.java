package co.edu.uptc.model;

public class ColectorAlbum {
    private double price;
    private String status;

    public ColectorAlbum(double price, String status) {
        this.price = price;
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
