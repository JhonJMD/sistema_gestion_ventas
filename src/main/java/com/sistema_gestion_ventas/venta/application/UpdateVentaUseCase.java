package com.sistema_gestion_ventas.venta.application;

import com.sistema_gestion_ventas.venta.domain.entity.Venta;
import com.sistema_gestion_ventas.venta.domain.service.VentaService;

public class UpdateVentaUseCase {
    private final VentaService ventaService;

    public UpdateVentaUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public void execute(Venta venta) {
        ventaService.updateVenta(venta);
    }
}
