package com.sistema_gestion_ventas.ciudad.application;

import java.util.List;
import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;
import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class GetAllCiudadUseCase {
    private final CiudadService ciudadService;

    public GetAllCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public List<Ciudad> execute() {
        return ciudadService.getAllCiudad();
    }
}
