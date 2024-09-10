package com.sistema_gestion_ventas.direccion.application;

import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;
import com.sistema_gestion_ventas.direccion.domain.service.DireccionService;

public class UpdateDireccionUseCase {
    private final DireccionService direccionService;

    public UpdateDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public void execute(Direccion direccion) {
        direccionService.updateDireccion(direccion);
    }
}
