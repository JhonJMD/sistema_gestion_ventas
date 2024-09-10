package com.sistema_gestion_ventas.tipo_pedido.domain.entity;

public class TipoPedido {
    private int tipoPedidoId;
    private String descripcion;

    public TipoPedido() {}

    public TipoPedido(int tipoPedidoId, String descripcion) {
        this.tipoPedidoId = tipoPedidoId;
        this.descripcion = descripcion;
    }

    public int getTipoPedidoId() {
        return tipoPedidoId;
    }

    public void setTipoPedidoId(int tipoPedidoId) {
        this.tipoPedidoId = tipoPedidoId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoPedido {tipoPedidoId=" + tipoPedidoId + ", descripcion=" + descripcion + "}";
    }
}
