package com.sistema_gestion_ventas.sucursal.application;

import java.util.Optional;
import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class FindSucursalByIdUseCase {
    private final SucursalService sucursalService;

    public FindSucursalByIdUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public Optional<Sucursal> execute(String sucursalId) {
        return sucursalService.findSucursalById(sucursalId);
    }
}
