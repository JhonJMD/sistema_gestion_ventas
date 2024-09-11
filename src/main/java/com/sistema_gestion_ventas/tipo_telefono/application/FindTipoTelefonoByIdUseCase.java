package com.sistema_gestion_ventas.tipo_telefono.application;

import java.util.Optional;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;
import com.sistema_gestion_ventas.tipo_telefono.domain.service.TipoTelefonoService;

public class FindTipoTelefonoByIdUseCase {
    private final TipoTelefonoService tipoTelefonoService;

    public FindTipoTelefonoByIdUseCase(TipoTelefonoService tipoTelefonoService) {
        this.tipoTelefonoService = tipoTelefonoService;
    }

    public Optional<TipoTelefono> execute(int tipoTelefonoId) {
        return tipoTelefonoService.findTipoTelefonoById(tipoTelefonoId);
    }
}
