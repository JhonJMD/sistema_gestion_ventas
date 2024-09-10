package com.sistema_gestion_ventas.pais.application;

import com.sistema_gestion_ventas.pais.domain.service.PaisService;

public class DeletePaisUseCase {
    private final PaisService paisService;

    public DeletePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(String paisId) {
        paisService.deletePais(paisId);
    }
}
