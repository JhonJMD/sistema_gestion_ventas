package com.sistema_gestion_ventas.devolucion.application;

import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class DeleteDevolucionUseCase {
    private final DevolucionService devolucionService;

    public DeleteDevolucionUseCase(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    public void execute(int devolucionId) {
        devolucionService.deleteDevolucion(devolucionId);
    }
}
