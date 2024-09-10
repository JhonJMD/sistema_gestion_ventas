package com.sistema_gestion_ventas.pedido.domain.entity;

import java.util.Date;

public class Pedido {
    private int pedidoId;
    private int tipoPedidoId;
    private String clienteId;
    private Date fechaPedido;
    private int estadoId;
    private double totalEstimado;
    private Date fechaConfirmacion;
    private int usuarioId;

    public Pedido() {}

    public Pedido(int pedidoId, int tipoPedidoId, String clienteId, Date fechaPedido, int estadoId, double totalEstimado, Date fechaConfirmacion, int usuarioId) {
        this.pedidoId = pedidoId;
        this.tipoPedidoId = tipoPedidoId;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.estadoId = estadoId;
        this.totalEstimado = totalEstimado;
        this.fechaConfirmacion = fechaConfirmacion;
        this.usuarioId = usuarioId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getTipoPedidoId() {
        return tipoPedidoId;
    }

    public void setTipoPedidoId(int tipoPedidoId) {
        this.tipoPedidoId = tipoPedidoId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public double getTotalEstimado() {
        return totalEstimado;
    }

    public void setTotalEstimado(double totalEstimado) {
        this.totalEstimado = totalEstimado;
    }

    public Date getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(Date fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Pedido {pedidoId=" + pedidoId + ", tipoPedidoId=" + tipoPedidoId + ", clienteId=" + clienteId + ", fechaPedido=" + fechaPedido + ", estadoId=" + estadoId + ", totalEstimado=" + totalEstimado + ", fechaConfirmacion=" + fechaConfirmacion + ", usuarioId=" + usuarioId + "}";
    }
}
