package co.uptc.edu.controller;

import java.util.ArrayList;
import java.util.List;

import co.uptc.edu.model.Artista;
import co.uptc.edu.model.Banda;

public class BandaControl {

    private List<Banda> bandas;

    public BandaControl() {
        bandas = new ArrayList<>();
    }

    public List<Banda> listar() {
        return bandas;
    }

    public Banda buscar(String id_banda) {
        for (Banda banda : bandas) {
            if (banda.getId_banda().equals(id_banda)) {
                return banda;
            }
        }
        return null;
    }

    public void crear(Banda banda) {
        bandas.add(banda);
    }

    public void actualizar(Banda banda) {
        Banda bandaExistente = buscar(banda.getId_banda());
        if (bandaExistente != null) {
            bandaExistente.setNombre(banda.getNombre());
            bandaExistente.setGenero(banda.getGenero());
            bandaExistente.setFechaCreacion(banda.getFechaCreacion());
            // Actualizar elementos individuales en lugar de usar clear y addAll
            bandaExistente.getArtistas().clear();
            bandaExistente.getArtistas().addAll(banda.getArtistas());
        }
    }

    public void eliminar(String id_banda) {
        Banda banda = buscar(id_banda);
        if (banda != null) {
            bandas.remove(banda);
        }
    }

    public void agregarArtista(String idBanda, String idArtista) {
        Banda banda = buscar(idBanda);
        Artista artista = buscarArtista(idArtista);
        if (banda != null && artista != null) {
            banda.getArtistas().add(artista);
        }
    }

    public void eliminarArtista(String idBanda, String idArtista) {
        Banda banda = buscar(idBanda);
        Artista artista = buscarArtista(idArtista);
        if (banda != null && artista != null) {
            banda.getArtistas().remove(artista);
        }
    }

    private Artista buscarArtista(String idArtista) {
        for (Banda banda : bandas) {
            for (Artista artista : banda.getArtistas()) {
                if (artista.getId_artista().equals(idArtista)) {
                    return artista;
                }
            }
        }
        return null;
    }
    
}
