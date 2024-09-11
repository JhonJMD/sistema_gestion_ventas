package com.sistema_gestion_ventas.producto.application;

import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class DeleteProductoUseCase {
    private final ProductoService productoService;

    public DeleteProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(int productoId) {
        productoService.deleteProducto(productoId);
    }
}
