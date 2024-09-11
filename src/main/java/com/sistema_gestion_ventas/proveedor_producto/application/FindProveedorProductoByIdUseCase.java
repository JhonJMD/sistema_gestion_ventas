package com.sistema_gestion_ventas.proveedor_producto.application;

import java.util.Optional;

import com.sistema_gestion_ventas.proveedor_producto.domain.entity.ProveedorProducto;
import com.sistema_gestion_ventas.proveedor_producto.domain.service.ProveedorProductoService;

public class FindProveedorProductoByIdUseCase {
    private final ProveedorProductoService proveedorProductoService;

    public FindProveedorProductoByIdUseCase(ProveedorProductoService proveedorProductoService) {
        this.proveedorProductoService = proveedorProductoService;
    }

    public Optional<ProveedorProducto> execute(String proveedorProductoId) {
        return proveedorProductoService.findProveedorProductoById(proveedorProductoId);
    }
}
