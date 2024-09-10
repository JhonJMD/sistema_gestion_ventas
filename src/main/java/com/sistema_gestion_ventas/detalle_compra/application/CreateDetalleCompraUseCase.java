package com.sistema_gestion_ventas.detalle_compra.application;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class CreateDetalleCompraUseCase {
    private final DetalleCompraService detallecompraService;

    public CreateDetalleCompraUseCase(DetalleCompraService detallecompraService) {
        this.detallecompraService = detallecompraService;
    }

    public void execute(DetalleCompra detallecompra) {
        detallecompraService.createDetalleCompra(detallecompra);
    }
}
