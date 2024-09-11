package com.sistema_gestion_ventas.tipo_persona.domain.entity;

public class TipoPersona {
    private int tipoPersonaId;
    private String descripcion;

    public TipoPersona() {}

    public TipoPersona(int tipoPersonaId, String descripcion) {
        this.tipoPersonaId = tipoPersonaId;
        this.descripcion = descripcion;
    }

    public int getTipoPersonaId() {
        return tipoPersonaId;
    }

    public void setTipoPersonaId(int tipoPersonaId) {
        this.tipoPersonaId = tipoPersonaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoPersona {tipoPersonaId=" + tipoPersonaId + ", descripcion=" + descripcion + "}";
    }
}
