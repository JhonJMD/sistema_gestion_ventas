package com.sistema_gestion_ventas.tipo_movimiento.application;

import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class DeleteTipoMovimientoUseCase {
    private final TipoMovimientoService tipomovimientoService;

    public DeleteTipoMovimientoUseCase(TipoMovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    public void execute(int tipoMovimientoId) {
        tipomovimientoService.deleteTipoMovimiento(tipoMovimientoId);
    }
}
