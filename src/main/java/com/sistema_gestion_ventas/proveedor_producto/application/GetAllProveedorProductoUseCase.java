package com.sistema_gestion_ventas.proveedor_producto.application;

import java.util.List;

import com.sistema_gestion_ventas.proveedor_producto.domain.entity.ProveedorProducto;
import com.sistema_gestion_ventas.proveedor_producto.domain.service.ProveedorProductoService;

public class GetAllProveedorProductoUseCase {
    private final ProveedorProductoService proveedorProductoService;

    public GetAllProveedorProductoUseCase(ProveedorProductoService proveedorProductoService) {
        this.proveedorProductoService = proveedorProductoService;
    }

    public List<ProveedorProducto> execute() {
        return proveedorProductoService.getAllProveedorProducto();
    }
}
