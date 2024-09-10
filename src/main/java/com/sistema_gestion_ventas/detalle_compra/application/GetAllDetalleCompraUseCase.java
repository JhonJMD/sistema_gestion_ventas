package com.sistema_gestion_ventas.detalle_compra.application;

import java.util.List;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class GetAllDetalleCompraUseCase {
    private final DetalleCompraService detallecompraService;

    public GetAllDetalleCompraUseCase(DetalleCompraService detallecompraService) {
        this.detallecompraService = detallecompraService;
    }

    public List<DetalleCompra> execute() {
        return detallecompraService.getAllDetalleCompra();
    }
}
