package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class CreateCiudadUseCase {
    private final CiudadService ciudadService;

    public CreateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad) {
        ciudadService.createCiudad(ciudad);
    }
}
