package com.sistema_gestion_ventas.proveedor_producto.domain.entity;

import java.util.Date;

public class ProveedorProducto {
    private String proveedorProductoId;
    private int productoId;
    private double precioCompra;
    private int tiempoEntrega;
    private int cantidadMinimaPedida;
    private double descuentoVolumen;
    private String moneda;
    private String condicionesPago;
    private Date fechaUltimaCompra;
    private double calificacionProveedor;

    public ProveedorProducto() {}

    public ProveedorProducto(String proveedorProductoId, int productoId, double precioCompra, int tiempoEntrega, int cantidadMinimaPedida, double descuentoVolumen, String moneda, String condicionesPago, Date fechaUltimaCompra, double calificacionProveedor) {
        this.proveedorProductoId = proveedorProductoId;
        this.productoId = productoId;
        this.precioCompra = precioCompra;
        this.tiempoEntrega = tiempoEntrega;
        this.cantidadMinimaPedida = cantidadMinimaPedida;
        this.descuentoVolumen = descuentoVolumen;
        this.moneda = moneda;
        this.condicionesPago = condicionesPago;
        this.fechaUltimaCompra = fechaUltimaCompra;
        this.calificacionProveedor = calificacionProveedor;
    }

    public String getProveedorProductoId() {
        return proveedorProductoId;
    }

    public void setProveedorProductoId(String proveedorProductoId) {
        this.proveedorProductoId = proveedorProductoId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public int getCantidadMinimaPedida() {
        return cantidadMinimaPedida;
    }

    public void setCantidadMinimaPedida(int cantidadMinimaPedida) {
        this.cantidadMinimaPedida = cantidadMinimaPedida;
    }

    public double getDescuentoVolumen() {
        return descuentoVolumen;
    }

    public void setDescuentoVolumen(double descuentoVolumen) {
        this.descuentoVolumen = descuentoVolumen;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getCondicionesPago() {
        return condicionesPago;
    }

    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    public Date getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(Date fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public double getCalificacionProveedor() {
        return calificacionProveedor;
    }

    public void setCalificacionProveedor(double calificacionProveedor) {
        this.calificacionProveedor = calificacionProveedor;
    }

    @Override
    public String toString() {
        return "ProveedorProducto {proveedorProductoId=" + proveedorProductoId + ", productoId=" + productoId + ", precioCompra=" + precioCompra + ", tiempoEntrega=" + tiempoEntrega + ", cantidadMinimaPedida=" + cantidadMinimaPedida + ", descuentoVolumen=" + descuentoVolumen + ", moneda=" + moneda + ", condicionesPago=" + condicionesPago + ", fechaUltimaCompra=" + fechaUltimaCompra + ", calificacionProveedor=" + calificacionProveedor + "}";
    }
}
