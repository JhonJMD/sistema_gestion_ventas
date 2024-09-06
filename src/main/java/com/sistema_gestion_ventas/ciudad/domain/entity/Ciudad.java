package com.sistema_gestion_ventas.ciudad.domain.entity;

public class Ciudad {
    private int ciudadid;
    private String nombre;
    private int paisid;
    
    public Ciudad() {
    }

    public Ciudad(int ciudadid, String nombre, int paisid) {
        this.ciudadid = ciudadid;
        this.nombre = nombre;
        this.paisid = paisid;
    }

    public int getCiudadid() {
        return ciudadid;
    }

    public void setCiudadid(int ciudadid) {
        this.ciudadid = ciudadid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaisid() {
        return paisid;
    }

    public void setPaisid(int paisid) {
        this.paisid = paisid;
    }

    @Override
    public String toString() {
        return "Ciudad [ciudadid=" + ciudadid + ", nombre=" + nombre + ", paisid=" + paisid + "]";
    }
    
}
