package com.sistema_gestion_ventas.historial_movimientos.application;

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historial_movimientos.domain.service.HistorialMovimientosService;

public class CreateHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public CreateHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public void execute(HistorialMovimientos historialmovimientos) {
        historialmovimientosService.createHistorialMovimientos(historialmovimientos);
    }
}
