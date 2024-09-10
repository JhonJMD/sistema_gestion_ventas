package com.sistema_gestion_ventas.producto.application;

import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class UpdateProductoUseCase {
    private final ProductoService productoService;

    public UpdateProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(Producto producto) {
        productoService.updateProducto(producto);
    }
}
