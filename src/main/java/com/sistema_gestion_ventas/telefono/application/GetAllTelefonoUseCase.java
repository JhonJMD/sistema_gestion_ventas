package com.sistema_gestion_ventas.telefono.application;

import java.util.List;
import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;
import com.sistema_gestion_ventas.telefono.domain.service.TelefonoService;

public class GetAllTelefonoUseCase {
    private final TelefonoService telefonoService;

    public GetAllTelefonoUseCase(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    public List<Telefono> execute() {
        return telefonoService.getAllTelefono();
    }
}
