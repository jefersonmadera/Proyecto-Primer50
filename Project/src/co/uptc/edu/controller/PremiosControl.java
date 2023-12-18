package co.uptc.edu.controller;

import co.uptc.edu.model.DetallesPremio;
import co.uptc.edu.model.Premio;

import java.util.ArrayList;
import java.util.List;

public class PremiosControl {

    private List<DetallesPremio> detallesPremios;
    private List<Premio> listaDePremios;

    public PremiosControl() {
        detallesPremios = new ArrayList<>();
        listaDePremios = new ArrayList<>();
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

    public Premio buscarPremio(String idPremio) {
        for (Premio premio : listaDePremios) {
            if (premio.getId_premio().equals(idPremio)) {
                return premio;
            }
        }
        return null;
    }

    public void agregarPremio(Premio premio) {
        listaDePremios.add(premio);
    }

    public boolean eliminarPremio(String idPremio) {
        Premio premioEliminar = buscarPremio(idPremio);
        if (premioEliminar != null) {
            listaDePremios.remove(premioEliminar);
            return true;
        }
        return false;
    }
}
