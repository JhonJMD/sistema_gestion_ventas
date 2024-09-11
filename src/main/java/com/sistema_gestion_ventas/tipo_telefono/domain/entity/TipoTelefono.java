package com.sistema_gestion_ventas.tipo_telefono.domain.entity;

public class TipoTelefono {
    private int tipoTelefonoId;
    private int descripcion;

    public TipoTelefono() {}

    public TipoTelefono(int tipoTelefonoId, int descripcion) {
        this.tipoTelefonoId = tipoTelefonoId;
        this.descripcion = descripcion;
    }

    public int getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(int tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoTelefono {tipoTelefonoId=" + tipoTelefonoId + ", descripcion=" + descripcion + "}";
    }
}
