package co.uptc.edu.model;

public class Colector {
    private String name;
    private String telephone;
    private String email;
    private String nombreUsuario;
    private String contrasena;

    public Colector(String name, String telephone, String email, String nombreUsuario, String contrasena) {
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
