package com.sistema_gestion_ventas.detalle_compra.application;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class UpdateDetalleCompraUseCase {
    private final DetalleCompraService detallecompraService;

    public UpdateDetalleCompraUseCase(DetalleCompraService detallecompraService) {
        this.detallecompraService = detallecompraService;
    }

    public void execute(DetalleCompra detallecompra) {
        detallecompraService.updateDetalleCompra(detallecompra);
    }
}
