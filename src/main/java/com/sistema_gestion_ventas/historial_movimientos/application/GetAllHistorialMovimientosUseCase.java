package com.sistema_gestion_ventas.historial_movimientos.application;

import java.util.List;

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historial_movimientos.domain.service.HistorialMovimientosService;

public class GetAllHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public GetAllHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public List<HistorialMovimientos> execute() {
        return historialmovimientosService.getAllHistorialMovimientos();
    }
}
