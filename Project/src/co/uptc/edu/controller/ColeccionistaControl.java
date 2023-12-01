package co.uptc.edu.controller;

import co.edu.uptc.model.Colector;
import co.uptc.edu.model.Colector;

import java.util.ArrayList;

public class ColeccionistaControl {
    private ArrayList<Colector> colectores;

    public ColeccionistaControl() {
        colectores = new ArrayList<>();
    }

    public void registrarColeccionista(Colector coleccionista) {
        colectores.add(coleccionista);
    }

    public ArrayList<Colector> obtenerListaColeccionistas() {
        return new ArrayList<>(colectores);
    }

    public boolean eliminarColeccionista(Colector coleccionista) {
        return colectores.remove(coleccionista);
    }

    public boolean registrarColeccionista(String nombreUsuario, String contrasena) {
        // Validaciones para el usuario y la contraseña
        if (validarUsuario(nombreUsuario) && validarContrasena(contrasena)) {
            // Crear un objeto Colector y registrarlo
            Colector nuevoColector = new Colector(nombreUsuario, contrasena, null, null, null);
            colectores.add(nuevoColector);
            return true;
        } else {
            System.out.println("Error: Usuario o contraseña no válidos.");
            return false;
        }
    }

    private boolean validarUsuario(String usuario) {
        // Lógica de validación para el usuario

        return usuario != null && !usuario.isEmpty();
    }

    private boolean validarContrasena(String contrasena) {
        // Lógica de validación para la contraseña

        return contrasena != null && contrasena.length() >= 8 &&
                contieneMayuscula(contrasena) &&
                contieneMinuscula(contrasena);
    }

    private boolean contieneMayuscula(String contrasena) {
        // Lógica para verificar si la contraseña contiene al menos una mayúscula

        return !contrasena.equals(contrasena.toLowerCase());
    }

    private boolean contieneMinuscula(String contrasena) {
        // Lógica para verificar si la contraseña contiene al menos una minúscula

        return !contrasena.equals(contrasena.toUpperCase());
    }

}
