package com.sistema_gestion_ventas.devolucion.application;

import java.util.List;
import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class GetAllDevolucionUseCase {
    private final DevolucionService devolucionService;

    public GetAllDevolucionUseCase(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    public List<Devolucion> execute() {
        return devolucionService.getAllDevolucion();
    }
}
