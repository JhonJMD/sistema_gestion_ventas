package com.sistema_gestion_ventas.compra.application;

import com.sistema_gestion_ventas.compra.domain.service.CompraService;

public class DeleteCompraUseCase {
    private final CompraService compraService;

    public DeleteCompraUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

    public void execute(int compraId) {
        compraService.deleteCompra(compraId);
    }
}
