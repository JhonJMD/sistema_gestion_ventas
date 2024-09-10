package com.sistema_gestion_ventas.devolucion.application;

import java.util.Optional;
import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;
import com.sistema_gestion_ventas.devolucion.domain.service.DevolucionService;

public class FindDevolucionByIdUseCase {
    private final DevolucionService devolucionService;

    public FindDevolucionByIdUseCase(DevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    public Optional<Devolucion> execute(int devolucionId) {
        return devolucionService.findDevolucionById(devolucionId);
    }
}
