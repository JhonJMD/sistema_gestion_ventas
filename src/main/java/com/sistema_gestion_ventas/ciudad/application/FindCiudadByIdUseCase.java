package com.sistema_gestion_ventas.ciudad.application;

import java.util.Optional;
import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class FindCiudadByIdUseCase {
    private final CiudadService ciudadService;

    public FindCiudadByIdUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public Optional<Ciudad> execute(int ciudadId) {
        return ciudadService.findCiudadById(ciudadId);
    }
}
