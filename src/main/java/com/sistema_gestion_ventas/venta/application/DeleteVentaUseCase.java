package com.sistema_gestion_ventas.venta.application;

import com.sistema_gestion_ventas.venta.domain.service.VentaService;

public class DeleteVentaUseCase {
    private final VentaService ventaService;

    public DeleteVentaUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public void execute(int ventaId) {
        ventaService.deleteVenta(ventaId);
    }
}
