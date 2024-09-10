package com.sistema_gestion_ventas.compra.domain.entity;

import java.util.Date;

public class Compra {
    private int compraId;
    private int pedidoId;
    private Date fechaCompra;
    private int estadoId;
    private double totalSinDescuento;
    private int empleadoId;

    public Compra() {}

    public Compra(int compraId, int pedidoId, Date fechaCompra, int estadoId, double totalSinDescuento, int empleadoId) {
        this.compraId = compraId;
        this.pedidoId = pedidoId;
        this.fechaCompra = fechaCompra;
        this.estadoId = estadoId;
        this.totalSinDescuento = totalSinDescuento;
        this.empleadoId = empleadoId;
    }

    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public double getTotalSinDescuento() {
        return totalSinDescuento;
    }

    public void setTotalSinDescuento(double totalSinDescuento) {
        this.totalSinDescuento = totalSinDescuento;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public String toString() {
        return "Compra {compraId=" + compraId + ", pedidoId=" + pedidoId + ", fechaCompra=" + fechaCompra + ", estadoId=" + estadoId + ", totalSinDescuento=" + totalSinDescuento + ", empleadoId=" + empleadoId + "}";
    }
}
