package com.sistema_gestion_ventas.producto.application;

import java.util.List;
import com.sistema_gestion_ventas.producto.domain.entity.Producto;
import com.sistema_gestion_ventas.producto.domain.service.ProductoService;

public class GetAllProductoUseCase {
    private final ProductoService productoService;

    public GetAllProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Producto> execute() {
        return productoService.getAllProducto();
    }
}
