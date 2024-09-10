package com.sistema_gestion_ventas.direccion.application;

import com.sistema_gestion_ventas.direccion.domain.service.DireccionService;

public class DeleteDireccionUseCase {
    private final DireccionService direccionService;

    public DeleteDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public void execute(String direccionId) {
        direccionService.deleteDireccion(direccionId);
    }
}
