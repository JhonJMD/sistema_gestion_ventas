package com.sistema_gestion_ventas.sucursal.application;

import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class DeleteSucursalUseCase {
    private final SucursalService sucursalService;

    public DeleteSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public void execute(int sucursalId) {
        sucursalService.deleteSucursal(sucursalId);
    }
}
