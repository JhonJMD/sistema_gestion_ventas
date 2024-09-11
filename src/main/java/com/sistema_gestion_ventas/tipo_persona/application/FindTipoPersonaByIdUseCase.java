package com.sistema_gestion_ventas.tipo_persona.application;

import java.util.Optional;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class FindTipoPersonaByIdUseCase {
    private final TipoPersonaService tipoPersonaService;

    public FindTipoPersonaByIdUseCase(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    public Optional<TipoPersona> execute(int tipoPersonaId) {
        return tipoPersonaService.findTipoPersonaById(tipoPersonaId);
    }
}
