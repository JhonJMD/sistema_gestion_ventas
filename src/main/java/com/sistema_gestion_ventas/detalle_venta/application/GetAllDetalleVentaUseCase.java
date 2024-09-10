package com.sistema_gestion_ventas.detalle_venta.application;

import java.util.List;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;
import com.sistema_gestion_ventas.detalle_venta.domain.service.DetalleVentaService;

public class GetAllDetalleVentaUseCase {
    private final DetalleVentaService detalleventaService;

    public GetAllDetalleVentaUseCase(DetalleVentaService detalleventaService) {
        this.detalleventaService = detalleventaService;
    }

    public List<DetalleVenta> execute() {
        return detalleventaService.getAllDetalleVenta();
    }
}
