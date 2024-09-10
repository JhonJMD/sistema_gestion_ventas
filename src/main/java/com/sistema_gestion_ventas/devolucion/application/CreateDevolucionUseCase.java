package com.sistema_gestion_ventas.devolucion.application;

import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class CreateDevolucionUseCase {
    private final DevolucionService devolucionService;

    public CreateDevolucionUseCase(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    public void execute(Devolucion devolucion) {
        devolucionService.createDevolucion(devolucion);
    }
}
