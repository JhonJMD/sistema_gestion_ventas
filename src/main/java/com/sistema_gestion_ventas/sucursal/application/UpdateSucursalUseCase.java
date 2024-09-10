package com.sistema_gestion_ventas.sucursal.application;

import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class UpdateSucursalUseCase {
    private final SucursalService sucursalService;

    public UpdateSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public void execute(Sucursal sucursal) {
        sucursalService.updateSucursal(sucursal);
    }
}
