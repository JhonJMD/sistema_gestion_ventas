package com.sistema_gestion_ventas.detalle_pedido.domain.entity;

public class DetallePedido {
    private int detallePedidoId;
    private int pedidoId;
    private int productoId;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;

    public DetallePedido() {}

    public DetallePedido(int detallePedidoId, int pedidoId, int productoId, int cantidad, double precioUnitario, double subTotal) {
        this.detallePedidoId = detallePedidoId;
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
    }

    public int getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(int detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetallePedido {detallePedidoId=" + detallePedidoId + ", pedidoId=" + pedidoId + ", productoId=" + productoId + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + "}";
    }
}
