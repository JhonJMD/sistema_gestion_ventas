package com.sistema_gestion_ventas.detalle_compra.domain.entity;

public class DetalleCompra {
    private int detalleCompraId;
    private int compraId;
    private int productoId;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public DetalleCompra() {}

    public DetalleCompra(int detalleCompraId, int compraId, int productoId, int cantidad, double precioUnitario, double subtotal) {
        this.detalleCompraId = detalleCompraId;
        this.compraId = compraId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public int getDetalleCompraId() {
        return detalleCompraId;
    }

    public void setDetalleCompraId(int detalleCompraId) {
        this.detalleCompraId = detalleCompraId;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleCompra {detalleCompraId=" + detalleCompraId + ", compraId=" + compraId + ", productoId=" + productoId + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "}";
    }
}
