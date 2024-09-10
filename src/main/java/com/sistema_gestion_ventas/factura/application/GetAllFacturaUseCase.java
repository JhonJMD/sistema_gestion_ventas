package com.sistema_gestion_ventas.factura.application;

import java.util.List;
import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class GetAllFacturaUseCase {
    private final FacturaService facturaService;

    public GetAllFacturaUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public List<Factura> execute() {
        return facturaService.getAllFactura();
    }
}
