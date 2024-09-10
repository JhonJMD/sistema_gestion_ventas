package com.sistema_gestion_ventas.sucursal.domain.entity;

public class Sucursal {
    private int sucursalId;
    private int direccionId;
    private String descripcion;

    public Sucursal() {}

    public Sucursal(int sucursalId, int direccionId, String descripcion) {
        this.sucursalId = sucursalId;
        this.direccionId = direccionId;
        this.descripcion = descripcion;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Sucursal {sucursalId=" + sucursalId + ", direccionId=" + direccionId + ", descripcion=" + descripcion + "}";
    }
}
