package com.sistema_gestion_ventas.historialMovimientos.application;

import com.sistema_gestion_ventas.historialMovimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historialMovimientos.domain.service.HistorialMovimientosService;

public class UpdateHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public UpdateHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public void execute(HistorialMovimientos historialmovimientos) {
        historialmovimientosService.updateHistorialMovimientos(historialmovimientos);
    }
}
