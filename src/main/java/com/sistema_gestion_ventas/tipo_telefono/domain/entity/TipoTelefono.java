package com.sistema_gestion_ventas.tipo_telefono.domain.entity;

public class TipoTelefono {
    private int tipoTelefonoId;
    private String descripcion;

    public TipoTelefono() {}

    public TipoTelefono(int tipoTelefonoId, String descripcion) {
        this.tipoTelefonoId = tipoTelefonoId;
        this.descripcion = descripcion;
    }

    public int getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(int tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoTelefono {tipoTelefonoId=" + tipoTelefonoId + ", descripcion=" + descripcion + "}";
    }
}
