package com.sistema_gestion_ventas.detalle_venta.application;

import java.util.Optional;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class FindDetalleVentaByIdUseCase {
    private final DetalleVentaService detalleventaService;

    public FindDetalleVentaByIdUseCase(DetalleVentaService detalleventaService) {
        this.detalleventaService = detalleventaService;
    }

    public Optional<DetalleVenta> execute(int detalleVentaId) {
        return detalleventaService.findDetalleVentaById(detalleVentaId);
    }
}
