package com.sistema_gestion_ventas.tipo_movimiento.application;

import java.util.List;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class GetAllTipoMovimientoUseCase {
    private final TipoMovimientoService tipomovimientoService;

    public GetAllTipoMovimientoUseCase(TipoMovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    public List<TipoMovimiento> execute() {
        return tipomovimientoService.getAllTipoMovimiento();
    }
}
