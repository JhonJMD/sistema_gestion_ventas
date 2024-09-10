package com.sistema_gestion_ventas.proveedor.application;

import java.util.List;
import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;
import com.sistema_gestion_ventas.proveedor.domain.service.ProveedorService;

public class GetAllProveedorUseCase {
    private final ProveedorService proveedorService;

    public GetAllProveedorUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public List<Proveedor> execute() {
        return proveedorService.getAllProveedor();
    }
}
