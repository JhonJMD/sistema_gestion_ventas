package com.sistema_gestion_ventas.pais.application;

import java.util.List;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.domain.service.PaisService;

public class GetAllPaisUseCase {
    private final PaisService paisService;

    public GetAllPaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public List<Pais> execute() {
        return paisService.getAllPais();
    }   
}
