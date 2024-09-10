package com.sistema_gestion_ventas.compra.application;

import com.sistema_gestion_ventas.compra.domain.entity.Compra;
import com.sistema_gestion_ventas.compra.domain.service.CompraService;

public class UpdateCompraUseCase {
    private final CompraService compraService;

    public UpdateCompraUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

    public void execute(Compra compra) {
        compraService.updateCompra(compra);
    }
}
