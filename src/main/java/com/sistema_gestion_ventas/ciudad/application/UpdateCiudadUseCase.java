package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CuidadService;

public class UpdateCiudadUseCase {
    private final CuidadService cuidadService;

    public UpdateCiudadUseCase(CuidadService cuidadService) {
        this.cuidadService = cuidadService;
    }

    public void execute(Ciudad ciudad) {
        cuidadService.updateCiudad(ciudad);
    }
}
