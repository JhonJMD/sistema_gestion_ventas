package com.sistema_gestion_ventas.categoria_producto.domain.entity;

public class CategoriaProducto {
    private int categoriaProductoId;
    private String nombre;
    private String descripcion;

    public CategoriaProducto() {}

    public CategoriaProducto(int categoriaProductoId, String nombre, String descripcion) {
        this.categoriaProductoId = categoriaProductoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getCategoriaProductoId() {
        return categoriaProductoId;
    }

    public void setCategoriaProductoId(int categoriaProductoId) {
        this.categoriaProductoId = categoriaProductoId;
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

    @Override
    public String toString() {
        return "CategoriaProducto {categoriaProductoId=" + categoriaProductoId + ", nombre=" + nombre + ", descripcion=" + descripcion + "}";
    }
}
