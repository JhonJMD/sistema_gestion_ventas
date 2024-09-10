package com.sistema_gestion_ventas.factura.application;

import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class DeleteFacturaUseCase {
    private final FacturaService facturaService;

    public DeleteFacturaUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public void execute(int facturaId) {
        facturaService.deleteFactura(facturaId);
    }
}
