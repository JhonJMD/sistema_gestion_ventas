package com.sistema_gestion_ventas.detalle_venta.application;

import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class DeleteDetalleVentaUseCase {
    private final DetalleVentaService detalleventaService;

    public DeleteDetalleVentaUseCase(DetalleVentaService detalleventaService) {
        this.detalleventaService = detalleventaService;
    }

    public void execute(int detalleVentaId) {
        detalleventaService.deleteDetalleVenta(detalleVentaId);
    }
}
