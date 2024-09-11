package com.sistema_gestion_ventas.tipo_telefono.application;

import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class DeleteTipoTelefonoUseCase {
    private final TipoTelefonoService tipoTelefonoService;

    public DeleteTipoTelefonoUseCase(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    public void execute(int tipoTelefonoId) {
        tipoTelefonoService.deleteTipoTelefono(tipoTelefonoId);
    }
}
