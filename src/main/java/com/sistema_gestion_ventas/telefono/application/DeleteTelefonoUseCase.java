package com.sistema_gestion_ventas.telefono.application;

import com.sistema_gestion_ventas.telefono.domain.service.TelefonoService;

public class DeleteTelefonoUseCase {
    private final TelefonoService telefonoService;

    public DeleteTelefonoUseCase(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    public void execute(String telefonoId) {
        telefonoService.deleteTelefono(telefonoId);
    }
}
