package com.sistema_gestion_ventas.detalle_venta.application;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class UpdateDetalleVentaUseCase {
    private final DetalleVentaService detalleventaService;

    public UpdateDetalleVentaUseCase(DetalleVentaService detalleventaService) {
        this.detalleventaService = detalleventaService;
    }

    public void execute(DetalleVenta detalleventa) {
        detalleventaService.updateDetalleVenta(detalleventa);
    }
}
