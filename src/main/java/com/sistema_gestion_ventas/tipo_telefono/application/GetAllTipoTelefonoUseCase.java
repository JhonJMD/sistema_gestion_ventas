package com.sistema_gestion_ventas.tipo_telefono.application;

import java.util.List;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class GetAllTipoTelefonoUseCase {
    private final TipoTelefonoService tipoTelefonoService;

    public GetAllTipoTelefonoUseCase(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    public List<TipoTelefono> execute() {
        return tipoTelefonoService.getAllTipoTelefono();
    }
}
