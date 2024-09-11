package com.sistema_gestion_ventas.tipo_persona.application;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;
import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class UpdateTipoPersonaUseCase {
    private final TipoPersonaService tipoPersonaService;

    public UpdateTipoPersonaUseCase(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    public void execute(TipoPersona tipoPersona) {
        tipoPersonaService.updateTipoPersona(tipoPersona);
    }
}
