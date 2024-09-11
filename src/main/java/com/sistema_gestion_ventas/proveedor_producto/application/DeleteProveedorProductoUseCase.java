package com.sistema_gestion_ventas.proveedor_producto.application;

import com.sistema_gestion_ventas.proveedor_producto.domain.service.ProveedorProductoService;

public class DeleteProveedorProductoUseCase {
    private final ProveedorProductoService proveedorProductoService;

    public DeleteProveedorProductoUseCase(ProveedorProductoService proveedorProductoService) {
        this.proveedorProductoService = proveedorProductoService;
    }

    public void execute(String proveedorProductoId) {
        proveedorProductoService.deleteProveedorProducto(proveedorProductoId);
    }
}
