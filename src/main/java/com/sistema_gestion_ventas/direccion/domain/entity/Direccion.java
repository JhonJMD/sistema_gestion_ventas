package com.sistema_gestion_ventas.direccion.domain.entity;

public class Direccion {
    private int direccionId;
    private String direccionCompleta;
    private int ciudadId;

    public Direccion() {}

    public Direccion(int direccionId, String direccionCompleta, int ciudadId) {
        this.direccionId = direccionId;
        this.direccionCompleta = direccionCompleta;
        this.ciudadId = ciudadId;
    }

    public int getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    @Override
    public String toString() {
        return "Direccion {direccionId=" + direccionId + ", direccionCompleta=" + direccionCompleta + ", ciudadId=" + ciudadId + "}";
    }
}
