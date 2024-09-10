package com.sistema_gestion_ventas.inventario.domain.entity;

import java.util.Date;

public class Inventario {
    private int productoId;
    private int sucursalId;
    private int stock;

    public Inventario() {}

    public Inventario(int productoId, int sucursalId, int stock) {
        this.productoId = productoId;
        this.sucursalId = sucursalId;
        this.stock = stock;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(int sucursalId) {
        this.sucursalId = sucursalId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Inventario {productoId=" + productoId + ", sucursalId=" + sucursalId + ", stock=" + stock + "}";
    }
}
