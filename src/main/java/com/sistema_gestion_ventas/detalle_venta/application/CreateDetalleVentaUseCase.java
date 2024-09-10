package com.sistema_gestion_ventas.detalle_venta.application;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class CreateDetalleVentaUseCase {
    private final DetalleVentaService detalleventaService;

    public CreateDetalleVentaUseCase(DetalleVentaService detalleventaService) {
        this.detalleventaService = detalleventaService;
    }

    public void execute(DetalleVenta detalleventa) {
        detalleventaService.createDetalleVenta(detalleventa);
    }
}
