package com.sistema_gestion_ventas.venta.application;

import java.util.Optional;
import com.sistema_gestion_ventas.venta.domain.entity.Venta;
import com.sistema_gestion_ventas.venta.domain.service.VentaService;

public class FindVentaByIdUseCase {
    private final VentaService ventaService;

    public FindVentaByIdUseCase(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    public Optional<Venta> execute(int ventaId) {
        return ventaService.findVentaById(ventaId);
    }
}
