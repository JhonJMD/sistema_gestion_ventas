package com.sistema_gestion_ventas.estado.domain.entity;

public class Estado {
    private int estadoId;
    private String descripcion;

    public Estado() {}

    public Estado(int estadoId, String descripcion) {
        this.estadoId = estadoId;
        this.descripcion = descripcion;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estado {estadoId=" + estadoId + ", descripcion=" + descripcion + "}";
    }
}
