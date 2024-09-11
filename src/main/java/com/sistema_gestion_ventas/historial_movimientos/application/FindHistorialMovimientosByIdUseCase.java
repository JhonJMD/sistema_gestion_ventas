package com.sistema_gestion_ventas.historial_movimientos.application;

import java.util.Optional;

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historial_movimientos.domain.service.HistorialMovimientosService;

public class FindHistorialMovimientosByIdUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public FindHistorialMovimientosByIdUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public Optional<HistorialMovimientos> execute(int historialMovimientosId) {
        return historialmovimientosService.findHistorialMovimientosById(historialMovimientosId);
    }
}
