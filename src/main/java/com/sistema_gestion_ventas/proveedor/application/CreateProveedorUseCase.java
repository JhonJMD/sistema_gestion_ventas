package com.sistema_gestion_ventas.proveedor.application;

import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;
import com.sistema_gestion_ventas.proveedor.domain.service.ProveedorService;

public class CreateProveedorUseCase {
    private final ProveedorService proveedorService;

    public CreateProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public void execute(Proveedor proveedor) {
        proveedorService.createProveedor(proveedor);
    }
}
