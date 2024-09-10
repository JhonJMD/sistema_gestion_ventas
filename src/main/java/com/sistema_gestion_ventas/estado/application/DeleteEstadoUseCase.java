package com.sistema_gestion_ventas.estado.application;

import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class DeleteEstadoUseCase {
    private final EstadoService estadoService;

    public DeleteEstadoUseCase(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public void execute(int estadoId) {
        estadoService.deleteEstado(estadoId);
    }
}
