package com.sistema_gestion_ventas.tipo_persona.application;

import java.util.List;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class GetAllTipoPersonaUseCase {
    private final TipoPersonaService tipoPersonaService;

    public GetAllTipoPersonaUseCase(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    public List<TipoPersona> execute() {
        return tipoPersonaService.getAllTipoPersona();
    }
}
