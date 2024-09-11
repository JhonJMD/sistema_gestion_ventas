package com.sistema_gestion_ventas.tipo_telefono.application;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class UpdateTipoTelefonoUseCase {
    private final TipoTelefonoService tipoTelefonoService;

    public UpdateTipoTelefonoUseCase(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    public void execute(TipoTelefono tipoTelefono) {
        tipoTelefonoService.updateTipoTelefono(tipoTelefono);
    }
}
