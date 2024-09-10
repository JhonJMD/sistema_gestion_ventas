package com.sistema_gestion_ventas.producto.domain.entity;

import java.util.Date;

public class Producto {
    private int productoId;
    private String codigoBarras;
    private String nombre;
    private String descripcion;
    private double precio;
    private int categoriaProductoId;

    public Producto() {}

    public Producto(int productoId, String codigoBarras, String nombre, String descripcion, double precio, int categoriaProductoId) {
        this.productoId = productoId;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoriaProductoId = categoriaProductoId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public void setCategoriaProductoId(int categoriaProductoId) {
        this.categoriaProductoId = categoriaProductoId;
    }

    @Override
    public String toString() {
        return "Producto {productoId=" + productoId + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", categoriaProductoId=" + categoriaProductoId + "}";
    }
}
