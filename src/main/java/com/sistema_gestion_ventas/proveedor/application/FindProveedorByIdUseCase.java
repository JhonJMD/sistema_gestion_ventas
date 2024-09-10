package com.sistema_gestion_ventas.proveedor.application;

import java.util.Optional;
import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;
import com.sistema_gestion_ventas.proveedor.domain.service.ProveedorService;

public class FindProveedorByIdUseCase {
    private final ProveedorService proveedorService;

    public FindProveedorByIdUseCase(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    public Optional<Proveedor> execute(String proveedorId) {
        return proveedorService.findProveedorById(proveedorId);
    }
}
