package com.sistema_gestion_ventas.historialMovimientos.domain.entity;

import java.util.Date;

public class HistorialMovimientos {
    private int movimientoId;
    private int productoId;
    private int sucursalId;
    private int tipoMovimientoId;
    private int cantidad;
    private Date fechaMovimiento;

    public HistorialMovimientos() {}

    public HistorialMovimientos(int movimientoId, int productoId, int sucursalId, int tipoMovimientoId, int cantidad, Date fechaMovimiento) {
        this.movimientoId = movimientoId;
        this.productoId = productoId;
        this.sucursalId = sucursalId;
        this.tipoMovimientoId = tipoMovimientoId;
        this.cantidad = cantidad;
        this.fechaMovimiento = fechaMovimiento;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    public void setTipoMovimientoId(int tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "HistorialMovimientos {movimientoId=" + movimientoId + ", productoId=" + productoId + ", sucursalId=" + sucursalId + ", tipoMovimientoId=" + tipoMovimientoId + ", cantidad=" + cantidad + ", fechaMovimiento=" + fechaMovimiento + "}";
    }
}
