package com.sistema_gestion_ventas.proveedor_producto.application;

import com.sistema_gestion_ventas.proveedor_producto.domain.entity.ProveedorProducto;
import com.sistema_gestion_ventas.proveedor_producto.domain.service.ProveedorProductoService;

public class CreateProveedorProductoUseCase {
    private final ProveedorProductoService proveedorProductoService;

    public CreateProveedorProductoUseCase(ProveedorProductoService proveedorProductoService) {
        this.proveedorProductoService = proveedorProductoService;
    }

    public void execute(ProveedorProducto proveedorProducto) {
        proveedorProductoService.createProveedorProducto(proveedorProducto);
    }
}
