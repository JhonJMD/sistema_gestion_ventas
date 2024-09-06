package com.sistema_gestion_ventas.pais.domain.entity;

public class Pais {
    private int paisid;
    private String nombre;
    
    public Pais() {
    }

    public Pais(int paisid, String nombre) {
        this.paisid = paisid;
        this.nombre = nombre;
    }

    public int getPaisid() {
        return paisid;
    }

    public void setPaisid(int paisid) {
        this.paisid = paisid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Pais [paisid=" + paisid + ", nombre=" + nombre + "]";
    }
    
}
