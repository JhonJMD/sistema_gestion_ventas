package com.sistema_gestion_ventas.venta.application;

import java.util.List;
import com.sistema_gestion_ventas.venta.domain.entity.Venta;
import com.sistema_gestion_ventas.venta.domain.service.VentaService;

public class GetAllVentaUseCase {
    private final VentaService ventaService;

    public GetAllVentaUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public List<Venta> execute() {
        return ventaService.getAllVenta();
    }
}
