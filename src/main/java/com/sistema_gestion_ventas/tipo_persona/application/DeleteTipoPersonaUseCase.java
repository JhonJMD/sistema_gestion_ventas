package com.sistema_gestion_ventas.tipo_persona.application;

import com.sistema_gestion_ventas.tipo_persona.domain.service.TipoPersonaService;

public class DeleteTipoPersonaUseCase {
    private final TipoPersonaService tipoPersonaService;

    public DeleteTipoPersonaUseCase(TipoPersonaService tipoPersonaService) {
        this.tipoPersonaService = tipoPersonaService;
    }

    public void execute(int tipoPersonaId) {
        tipoPersonaService.deleteTipoPersona(tipoPersonaId);
    }
}
