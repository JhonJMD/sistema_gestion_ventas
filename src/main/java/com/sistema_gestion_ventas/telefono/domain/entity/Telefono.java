package com.sistema_gestion_ventas.telefono.domain.entity;

public class Telefono {
    private int telefonoId;
    private int tipoTelefonoId;
    private String telefono;

    public Telefono() {}

    public Telefono(int telefonoId, int tipoTelefonoId, String telefono) {
        this.telefonoId = telefonoId;
        this.tipoTelefonoId = tipoTelefonoId;
        this.telefono = telefono;
    }

    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(int telefonoId) {
        this.telefonoId = telefonoId;
    }

    public int getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(int tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Telefono {telefonoId=" + telefonoId + ", tipoTelefonoId=" + tipoTelefonoId + ", telefono=" + telefono + "}";
    }
}
