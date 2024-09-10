package com.sistema_gestion_ventas.estado.application;

import java.util.List;
import com.sistema_gestion_ventas.estado.domain.entity.Estado;
import com.sistema_gestion_ventas.estado.domain.service.EstadoService;

public class GetAllEstadoUseCase {
    private final EstadoService estadoService;

    public GetAllEstadoUseCase(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public List<Estado> execute() {
        return estadoService.getAllEstado();
    }
}
