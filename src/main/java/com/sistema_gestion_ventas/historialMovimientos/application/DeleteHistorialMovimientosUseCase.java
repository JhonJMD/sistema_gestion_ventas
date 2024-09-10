package com.sistema_gestion_ventas.historialMovimientos.application;

import com.sistema_gestion_ventas.historialMovimientos.domain.service.HistorialMovimientosService;

public class DeleteHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public DeleteHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public void execute(String historialmovimientosId) {
        historialmovimientosService.deleteHistorialMovimientos(historialmovimientosId);
    }
}
