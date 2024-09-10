package com.sistema_gestion_ventas.proveedor.application;

import com.sistema_gestion_ventas.proveedor.domain.service.ProveedorService;

public class DeleteProveedorUseCase {
    private final ProveedorService proveedorService;

    public DeleteProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public void execute(String proveedorId) {
        proveedorService.deleteProveedor(proveedorId);
    }
}
