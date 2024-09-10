package com.sistema_gestion_ventas.pais.application;

import java.util.Optional;
import com.sistema_gestion_ventas.pais.domain.entity.Pais;
import com.sistema_gestion_ventas.pais.domain.service.PaisService;

public class FindPaisByIdUseCase {
    private final PaisService paisService;

    public FindPaisByIdUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public Optional<Pais> execute(String paisId) {
        return paisService.findPaisById(paisId);
    }
}
