package com.sistema_gestion_ventas.producto.application;

import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class CreateProductoUseCase {
    private final ProductoService productoService;

    public CreateProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(Producto producto) {
        productoService.createProducto(producto);
    }
}
