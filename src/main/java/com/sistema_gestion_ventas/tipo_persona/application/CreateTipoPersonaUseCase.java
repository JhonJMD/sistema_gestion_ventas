package com.sistema_gestion_ventas.tipo_persona.application;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class CreateTipoPersonaUseCase {
    private final TipoPersonaService tipoPersonaService;

    public CreateTipoPersonaUseCase(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    public void execute(TipoPersona tipoPersona) {
        tipoPersonaService.createTipoPersona(tipoPersona);
    }
}
