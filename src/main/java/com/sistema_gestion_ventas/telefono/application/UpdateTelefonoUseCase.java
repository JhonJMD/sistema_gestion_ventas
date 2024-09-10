package com.sistema_gestion_ventas.telefono.application;

import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;
import com.sistema_gestion_ventas.telefono.domain.service.TelefonoService;

public class UpdateTelefonoUseCase {
    private final TelefonoService telefonoService;

    public UpdateTelefonoUseCase(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    public void execute(Telefono telefono) {
        telefonoService.updateTelefono(telefono);
    }
}
