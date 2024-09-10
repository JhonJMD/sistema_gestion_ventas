package com.sistema_gestion_ventas.estado.application;

import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class CreateEstadoUseCase {
    private final EstadoService estadoService;

    public CreateEstadoUseCase(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public void execute(Estado estado) {
        estadoService.createEstado(estado);
    }
}
