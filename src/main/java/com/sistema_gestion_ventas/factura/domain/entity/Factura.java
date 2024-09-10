package com.sistema_gestion_ventas.factura.domain.entity;

import java.util.Date;

public class Factura {
    private int facturaId;
    private String descripcion;
    private int ventaId;
    private Date fechaFactura;
    private int metodoPagoId;
    private double descuentoPorcentaje;

    public Factura() {}

    public Factura(int facturaId, String descripcion, int ventaId, Date fechaFactura, int metodoPagoId, double descuentoPorcentaje) {
        this.facturaId = facturaId;
        this.descripcion = descripcion;
        this.ventaId = ventaId;
        this.fechaFactura = fechaFactura;
        this.metodoPagoId = metodoPagoId;
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(int metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    public double getDescuentoPorcentaje() {
        return descuentoPorcentaje;
    }

    public void setDescuentoPorcentaje(double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    @Override
    public String toString() {
        return "Factura {facturaId=" + facturaId + ", descripcion=" + descripcion + ", ventaId=" + ventaId + ", fechaFactura=" + fechaFactura + ", metodoPagoId=" + metodoPagoId + ", descuentoPorcentaje=" + descuentoPorcentaje + "}";
    }
}
