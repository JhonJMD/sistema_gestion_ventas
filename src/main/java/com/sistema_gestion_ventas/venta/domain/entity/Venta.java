package com.sistema_gestion_ventas.venta.domain.entity;

import java.util.Date;

public class Venta {
    private int ventaId;
    private int pedidoId;
    private Date fechaVenta;
    private double totalSinDescuento;
    private String clienteId;
    private int estadoId;
    private String empleadoId;

    public Venta() {}

    public Venta(int ventaId, int pedidoId, Date fechaVenta, double totalSinDescuento, String clienteId, int estadoId, String empleadoId) {
        this.ventaId = ventaId;
        this.pedidoId = pedidoId;
        this.fechaVenta = fechaVenta;
        this.totalSinDescuento = totalSinDescuento;
        this.clienteId = clienteId;
        this.estadoId = estadoId;
        this.empleadoId = empleadoId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotalSinDescuento() {
        return totalSinDescuento;
    }

    public void setTotalSinDescuento(double totalSinDescuento) {
        this.totalSinDescuento = totalSinDescuento;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(String empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public String toString() {
        return "Venta {ventaId=" + ventaId + ", pedidoId=" + pedidoId + ", fechaVenta=" + fechaVenta + ", totalSinDescuento=" + totalSinDescuento + ", clienteId=" + clienteId + ", estadoId=" + estadoId + ", empleadoId=" + empleadoId + "}";
    }
}
