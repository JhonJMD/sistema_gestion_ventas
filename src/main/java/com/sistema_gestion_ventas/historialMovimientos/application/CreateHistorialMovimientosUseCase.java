package com.sistema_gestion_ventas.historialMovimientos.application;

import com.sistema_gestion_ventas.historialMovimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historialMovimientos.domain.service.HistorialMovimientosService;

public class CreateHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public CreateHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public void execute(HistorialMovimientos historialmovimientos) {
        historialmovimientosService.createHistorialMovimientos(historialmovimientos);
    }
}
