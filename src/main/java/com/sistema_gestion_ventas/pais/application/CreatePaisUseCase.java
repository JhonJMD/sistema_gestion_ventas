package com.sistema_gestion_ventas.pais.application;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.domain.service.PaisService;

public class CreatePaisUseCase {
    private final PaisService paisService;

    public CreatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(Pais pais) {
        paisService.createPais(pais);
    }
}
