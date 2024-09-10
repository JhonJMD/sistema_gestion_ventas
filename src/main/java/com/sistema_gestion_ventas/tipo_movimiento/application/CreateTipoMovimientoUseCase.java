package com.sistema_gestion_ventas.tipo_movimiento.application;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class CreateTipoMovimientoUseCase {
    private final TipoMovimientoService tipomovimientoService;

    public CreateTipoMovimientoUseCase(TipoMovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    public void execute(TipoMovimiento tipomovimiento) {
        tipomovimientoService.createTipoMovimiento(tipomovimiento);
    }
}
