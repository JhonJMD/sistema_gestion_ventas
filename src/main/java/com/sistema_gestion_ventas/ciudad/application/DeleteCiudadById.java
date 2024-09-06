package com.sistema_gestion_ventas.ciudad.application;

import com.sistema_gestion_ventas.ciudad.domain.service.CuidadService;

public class DeleteCiudadById {
    private final CuidadService cuidadService;

    public DeleteCiudadById(CuidadService cuidadService) {
        this.cuidadService = cuidadService;
    }

    public void execute(int ciudadid) {
        cuidadService.deleteCiudad(ciudadid);
    }
}
