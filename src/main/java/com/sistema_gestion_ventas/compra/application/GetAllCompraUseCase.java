package com.sistema_gestion_ventas.compra.application;

import java.util.List;
import com.sistema_gestion_ventas.compra.domain.entity.Compra;
import com.sistema_gestion_ventas.compra.domain.service.CompraService;

public class GetAllCompraUseCase {
    private final CompraService compraService;

    public GetAllCompraUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

    public List<Compra> execute() {
        return compraService.getAllCompra();
    }
}
