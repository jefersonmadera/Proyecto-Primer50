package co.uptc.edu.controller;

import java.util.ArrayList;
import java.util.List;

import co.uptc.edu.model.Premio;
import co.uptc.edu.model.DetallesPremio;

public class PremiosControl {

    private List<DetallesPremio> detallesPremios;

    public PremiosControl() {
        detallesPremios = new ArrayList<>();
    }

    public List<DetallesPremio> listarDetallesPremios() {
        return detallesPremios;
    }

    public DetallesPremio buscarDetallesPremio(String idArtista, String idPremio) {
        for (DetallesPremio detalles : detallesPremios) {
            if (detalles.getArtista().getId_artista().equals(idArtista) && 
                detalles.getPremio().getId_premio().equals(idPremio)) {
                return detalles;
            }
        }
        return null;
    }

    public void agregarDetallesPremio(DetallesPremio detalles) {
        detallesPremios.add(detalles);
    }

    public void eliminarDetallesPremio(String idArtista, String idPremio) {
        DetallesPremio detalles = buscarDetallesPremio(idArtista, idPremio);
        if (detalles != null) {
            detallesPremios.remove(detalles);
        }
    }

    // Puedes agregar más métodos según tus necesidades.

}
