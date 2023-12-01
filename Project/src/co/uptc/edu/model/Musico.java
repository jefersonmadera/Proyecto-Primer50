package co.uptc.edu.model;

import java.util.Date;

public class Musico {
    private Date fechaNacimiento;

    public Musico(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}
