package com.sistema_gestion_ventas.devolucion.application;

import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class UpdateDevolucionUseCase {
    private final DevolucionService devolucionService;

    public UpdateDevolucionUseCase(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    public void execute(Devolucion devolucion) {
        devolucionService.updateDevolucion(devolucion);
    }
}
