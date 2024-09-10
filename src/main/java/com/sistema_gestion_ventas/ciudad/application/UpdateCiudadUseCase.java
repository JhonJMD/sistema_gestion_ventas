package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class UpdateCiudadUseCase {
    private final CiudadService ciudadService;

    public UpdateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad) {
        ciudadService.updateCiudad(ciudad);
    }
}
