package com.sistema_gestion_ventas.factura.application;

import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class CreateFacturaUseCase {
    private final FacturaService facturaService;

    public CreateFacturaUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public void execute(Factura factura) {
        facturaService.createFactura(factura);
    }
}
