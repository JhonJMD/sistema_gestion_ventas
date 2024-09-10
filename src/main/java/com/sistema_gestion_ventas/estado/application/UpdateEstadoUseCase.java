package com.sistema_gestion_ventas.estado.application;

import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class UpdateEstadoUseCase {
    private final EstadoService estadoService;

    public UpdateEstadoUseCase(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public void execute(Estado estado) {
        estadoService.updateEstado(estado);
    }
}
