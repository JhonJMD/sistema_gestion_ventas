package com.sistema_gestion_ventas.tipo_telefono.application;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class CreateTipoTelefonoUseCase {
    private final TipoTelefonoService tipoTelefonoService;

    public CreateTipoTelefonoUseCase(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    public void execute(TipoTelefono tipoTelefono) {
        tipoTelefonoService.createTipoTelefono(tipoTelefono);
    }
}
