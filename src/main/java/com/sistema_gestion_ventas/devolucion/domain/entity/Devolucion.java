package com.sistema_gestion_ventas.devolucion.domain.entity;

import java.util.Date;

public class Devolucion {
    private int devolucionId;
    private Date fechaDevolucion;
    private String motivo;
    private int estadoId;
    private int facturaId;

    public Devolucion() {}

    public Devolucion(int devolucionId, Date fechaDevolucion, String motivo, int estadoId, int facturaId) {
        this.devolucionId = devolucionId;
        this.fechaDevolucion = fechaDevolucion;
        this.motivo = motivo;
        this.estadoId = estadoId;
        this.facturaId = facturaId;
    }

    public int getDevolucionId() {
        return devolucionId;
    }

    public void setDevolucionId(int devolucionId) {
        this.devolucionId = devolucionId;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    @Override
    public String toString() {
        return "Devolucion {devolucionId=" + devolucionId + ", fechaDevolucion=" + fechaDevolucion + ", motivo=" + motivo + ", estadoId=" + estadoId + ", facturaId=" + facturaId + "}";
    }
}
