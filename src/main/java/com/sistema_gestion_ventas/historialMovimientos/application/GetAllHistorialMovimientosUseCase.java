package com.sistema_gestion_ventas.historialMovimientos.application;

import java.util.List;
import com.sistema_gestion_ventas.historialMovimientos.domain.entity.HistorialMovimientos;
import com.sistema_gestion_ventas.historialMovimientos.domain.service.HistorialMovimientosService;

public class GetAllHistorialMovimientosUseCase {
    private final HistorialMovimientosService historialmovimientosService;

    public GetAllHistorialMovimientosUseCase(HistorialMovimientosService historialmovimientosService) {
        this.historialmovimientosService = historialmovimientosService;
    }

    public List<HistorialMovimientos> execute() {
        return historialmovimientosService.getAllHistorialMovimientos();
    }
}
