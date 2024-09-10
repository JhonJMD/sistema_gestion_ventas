package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.service.CiudadService;

public class DeleteCiudadUseCase {
    private final CiudadService ciudadService;

    public DeleteCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(int ciudadId) {
        ciudadService.deleteCiudad(ciudadId);
    }
}
