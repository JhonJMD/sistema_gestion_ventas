package com.sistema_gestion_ventas.direccion.application;

import java.util.Optional;
import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;
import com.sistema_gestion_ventas.direccion.domain.service.DireccionService;

public class FindDireccionByIdUseCase {
    private final DireccionService direccionService;

    public FindDireccionByIdUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public Optional<Direccion> execute(String direccionId) {
        return direccionService.findDireccionById(direccionId);
    }
}
