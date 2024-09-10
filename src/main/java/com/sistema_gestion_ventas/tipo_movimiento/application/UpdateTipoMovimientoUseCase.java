package com.sistema_gestion_ventas.tipo_movimiento.application;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class UpdateTipoMovimientoUseCase {
    private final TipoMovimientoService tipomovimientoService;

    public UpdateTipoMovimientoUseCase(TipoMovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    public void execute(TipoMovimiento tipomovimiento) {
        tipomovimientoService.updateTipoMovimiento(tipomovimiento);
    }
}
