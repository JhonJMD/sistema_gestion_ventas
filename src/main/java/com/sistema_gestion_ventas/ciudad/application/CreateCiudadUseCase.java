package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CuidadService;

public class CreateCiudadUseCase {
    private final CuidadService cuidadService;

    public CreateCiudadUseCase(CuidadService cuidadService) {
        this.cuidadService = cuidadService;
    }

    public void execute(Ciudad ciudad) {
        cuidadService.createCiudad(ciudad);
    }
}   
