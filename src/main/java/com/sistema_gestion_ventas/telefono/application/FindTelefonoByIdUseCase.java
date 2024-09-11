package com.sistema_gestion_ventas.telefono.application;

import java.util.Optional;
import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;
import com.sistema_gestion_ventas.telefono.domain.service.TelefonoService;

public class FindTelefonoByIdUseCase {
    private final TelefonoService telefonoService;

    public FindTelefonoByIdUseCase(TelefonoService telefonoService) {
        this.telefonoService = telefonoService;
    }

    public Optional<Telefono> execute(int telefonoId) {
        return telefonoService.findTelefonoById(telefonoId);
    }
}
