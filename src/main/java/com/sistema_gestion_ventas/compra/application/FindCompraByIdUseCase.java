package com.sistema_gestion_ventas.compra.application;

import java.util.Optional;
import com.sistema_gestion_ventas.compra.domain.entity.Compra;
import com.sistema_gestion_ventas.compra.domain.service.CompraService;

public class FindCompraByIdUseCase {
    private final CompraService compraService;

    public FindCompraByIdUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

    public Optional<Compra> execute(int compraId) {
        return compraService.findCompraById(compraId);
    }
}
