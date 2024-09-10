package com.sistema_gestion_ventas.sucursal.application;

import java.util.List;
import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;
import com.sistema_gestion_ventas.sucursal.domain.service.SucursalService;

public class GetAllSucursalUseCase {
    private final SucursalService sucursalService;

    public GetAllSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public List<Sucursal> execute() {
        return sucursalService.getAllSucursal();
    }
}
