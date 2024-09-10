package com.sistema_gestion_ventas.historialMovimientos.application;

import java.util.Optional;
import com.sistema_gestion_ventas.historialMovimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historialMovimientos.domain.service.HistorialMovimientosService;

public class FindHistorialMovimientosByIdUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public FindHistorialMovimientosByIdUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public Optional<HistorialMovimientos> execute(String historialmovimientosId) {
        return historialmovimientosService.findHistorialMovimientosById(historialmovimientosId);
    }
}
