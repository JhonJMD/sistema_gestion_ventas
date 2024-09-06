package com.sistema_gestion_ventas.ciudad.application;

import java.util.Optional;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CuidadService;

public class FindCiudadByIdUseCase {
    private final CuidadService cuidadService;

    public FindCiudadByIdUseCase(CuidadService cuidadService) {
        this.cuidadService = cuidadService;
    }

    public Optional<Ciudad> execute(int ciudadid) {
        return cuidadService.findCiudadById(ciudadid);
    }
}
