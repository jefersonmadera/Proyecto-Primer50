package co.uptc.edu.controller;

import java.util.ArrayList;

public class AccesControl {
    private ArrayList<String> usuarios;
    private ArrayList<String> contrasenas;

    public AccesControl() {
        usuarios = new ArrayList<>();
        contrasenas = new ArrayList<>();
    }

    public boolean registrarUsuario(String usuario, String contrasena) {
        if (validarUsuario(usuario) && validarContrasena(contrasena)) {
            usuarios.add(usuario);
            contrasenas.add(contrasena);
            return true;
        } else {
            return false;
        }
    }

    private boolean validarUsuario(String usuario) {
        return usuario != null && !usuario.isEmpty();
    }

    private boolean validarContrasena(String contrasena) {
        return contrasena != null && contrasena.length() >= 8 &&
                contieneMayuscula(contrasena) &&
                contieneMinuscula(contrasena);
    }

    private boolean contieneMayuscula(String contrasena) {
        return !contrasena.equals(contrasena.toLowerCase());
    }

    private boolean contieneMinuscula(String contrasena) {
        return !contrasena.equals(contrasena.toUpperCase());
    }

    public boolean iniciarSesion(String usuario, String contrasena) {
        if (usuarios.contains(usuario) && contrasenas.contains(contrasena)) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<String> getUsuarios() {
        return usuarios;
    }
}
