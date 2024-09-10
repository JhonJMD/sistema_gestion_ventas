package com.sistema_gestion_ventas.metodo_pago.domain.entity;

public class MetodoPago {
    private int metodoPagoId;
    private String descripcion;

    public MetodoPago() {}

    public MetodoPago(int metodoPagoId, String descripcion) {
        this.metodoPagoId = metodoPagoId;
        this.descripcion = descripcion;
    }

    public int getMetodoPagoId() {
        return metodoPagoId;
    }

    public void setMetodoPagoId(int metodoPagoId) {
        this.metodoPagoId = metodoPagoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MetodoPago {metodoPagoId=" + metodoPagoId + ", descripcion=" + descripcion + "}";
    }
}
