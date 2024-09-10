package com.sistema_gestion_ventas.detalle_compra.application;

import java.util.Optional;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;
import com.sistema_gestion_ventas.detalle_compra.domain.service.DetalleCompraService;

public class FindDetalleCompraByIdUseCase {
    private final DetalleCompraService detallecompraService;

    public FindDetalleCompraByIdUseCase(DetalleCompraService detallecompraService) {
        this.detallecompraService = detallecompraService;
    }

    public Optional<DetalleCompra> execute(int detalleCompraId) {
        return detallecompraService.findDetalleCompraById(detalleCompraId);
    }
}
