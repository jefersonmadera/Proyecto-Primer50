package co.uptc.edu.controller;

import co.edu.uptc.model.Colector;
import co.edu.uptc.model.ColectorAlbum;
import co.edu.uptc.model.ColectorDetalles;

import java.util.ArrayList;

public class ColectorControl {
    private ArrayList<Colector> colectors;
    private ArrayList<ColectorAlbum> colectorAlbums;
    private ArrayList<ColectorDetalles> colectorDetalles;

    public ColectorControl() {
        colectors = new ArrayList<>();
        colectorAlbums = new ArrayList<>();
        colectorDetalles = new ArrayList<>();
    }

    public void addCollector(Colector collector) {
        if (!colectors.contains(collector)) {
            colectors.add(collector);
        }
    }

    public void removeCollector(Colector collector) {
        colectors.remove(collector);
    }

    public ArrayList<Colector> searchByName(String name) {
        return colectors.stream()
                .filter(colector -> colector.getName().equals(name))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<Colector> getAllCollectors() {
        return new ArrayList<>(colectors);
    }

    public void updateCollector(Colector existingCollector, Colector updatedCollector) {
        int index = colectors.indexOf(existingCollector);
        if (index != -1) {
            colectors.set(index, updatedCollector);
        }
    }

    public void addCollectorAlbum(ColectorAlbum colectorAlbum) {
        colectorAlbums.add(colectorAlbum);
    }

    public void removeCollectorAlbum(ColectorAlbum colectorAlbum) {
        colectorAlbums.remove(colectorAlbum);
    }

    public ArrayList<ColectorAlbum> getAllCollectorAlbums() {
        return new ArrayList<>(colectorAlbums);
    }

    // Otros métodos...

    // Puedes agregar manejo de excepciones, documentación y otros ajustes según sea
    // necesario
}
