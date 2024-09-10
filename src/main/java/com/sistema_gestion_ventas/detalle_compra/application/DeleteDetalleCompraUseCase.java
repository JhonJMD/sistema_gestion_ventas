package com.sistema_gestion_ventas.detalle_compra.application;

import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class DeleteDetalleCompraUseCase {
    private final DetalleCompraService detallecompraService;

    public DeleteDetalleCompraUseCase(DetalleCompraService detallecompraService) {
        this.detallecompraService = detallecompraService;
    }

    public void execute(int detalleCompraId) {
        detallecompraService.deleteDetalleCompra(detalleCompraId);
    }
}
