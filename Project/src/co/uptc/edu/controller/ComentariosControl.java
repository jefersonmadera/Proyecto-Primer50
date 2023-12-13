package co.uptc.edu.controller;

import co.uptc.edu.model.Album;
import co.uptc.edu.model.Comentario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComentariosControl {

    private Map<Album, List<Comentario>> comentariosMap;

    public ComentariosControl() {
        comentariosMap = new HashMap<>();
    }

    public void agregarComentario(Album album, Comentario comentario) {
        comentariosMap.computeIfAbsent(album, k -> new ArrayList<>()).add(comentario);
    }

    public List<Comentario> obtenerComentarios(Album album) {
        return comentariosMap.getOrDefault(album, new ArrayList<>());
    }

    public boolean eliminarComentario(Album album, Comentario comentario) {
        List<Comentario> comentarios = comentariosMap.get(album);
        if (comentarios != null) {
            return comentarios.remove(comentario);
        }
        return false;
    }
}
