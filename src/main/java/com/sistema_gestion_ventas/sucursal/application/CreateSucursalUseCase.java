package com.sistema_gestion_ventas.sucursal.application;

import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class CreateSucursalUseCase {
    private final SucursalService sucursalService;

    public CreateSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public void execute(Sucursal sucursal) {
        sucursalService.createSucursal(sucursal);
    }
}
