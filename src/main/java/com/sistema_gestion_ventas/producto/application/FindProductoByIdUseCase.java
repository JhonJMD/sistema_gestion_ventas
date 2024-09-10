package com.sistema_gestion_ventas.producto.application;

import java.util.Optional;
import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class FindProductoByIdUseCase {
    private final ProductoService productoService;

    public FindProductoByIdUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Optional<Producto> execute(String productoId) {
        return productoService.findProductoById(productoId);
    }
}
