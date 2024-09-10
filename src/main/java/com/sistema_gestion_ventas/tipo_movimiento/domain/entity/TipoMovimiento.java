package com.sistema_gestion_ventas.tipo_movimiento.domain.entity;

public class TipoMovimiento {
    private int tipoMovimientoId;
    private String descripcion;

    public TipoMovimiento() {}

    public TipoMovimiento(int tipoMovimientoId, String descripcion) {
        this.tipoMovimientoId = tipoMovimientoId;
        this.descripcion = descripcion;
    }

    public int getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public void setTipoMovimientoId(int tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoMovimiento {tipoMovimientoId=" + tipoMovimientoId + ", descripcion=" + descripcion + "}";
    }
}
