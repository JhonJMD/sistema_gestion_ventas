package com.sistema_gestion_ventas.factura.application;

import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class UpdateFacturaUseCase {
    private final FacturaService facturaService;

    public UpdateFacturaUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public void execute(Factura factura) {
        facturaService.updateFactura(factura);
    }
}
