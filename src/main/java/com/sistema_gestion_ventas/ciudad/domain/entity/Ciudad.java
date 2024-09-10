package com.sistema_gestion_ventas.ciudad.domain.entity;

public class Ciudad {
    private int ciudadId;
    private String nombre;
    private int paisId;

    public Ciudad() {}

    public Ciudad(int ciudadId, String nombre, int paisId) {
        this.ciudadId = ciudadId;
        this.nombre = nombre;
        this.paisId = paisId;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }

    @Override
    public String toString() {
        return "Ciudad {ciudadId=" + ciudadId + ", nombre=" + nombre + ", paisId=" + paisId + "}";
    }
}
