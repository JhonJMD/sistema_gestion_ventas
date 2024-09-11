package com.sistema_gestion_ventas.historial_movimientos.application;

import com.sistema_gestion_ventas.historial_movimientos.domain.service.HistorialMovimientosService;

public class DeleteHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public DeleteHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public void execute(int historialMovimientosId) {
        historialmovimientosService.deleteHistorialMovimientos(historialMovimientosId);
    }
}
