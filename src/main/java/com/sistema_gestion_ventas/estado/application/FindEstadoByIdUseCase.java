package com.sistema_gestion_ventas.estado.application;

import java.util.Optional;
import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class FindEstadoByIdUseCase {
    private final EstadoService estadoService;

    public FindEstadoByIdUseCase(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public Optional<Estado> execute(int estadoId) {
        return estadoService.findEstadoById(estadoId);
    }
}
