package com.sistema_gestion_ventas.factura.application;

import java.util.Optional;
import com.sistema_gestion_ventas.factura.domain.entity.Factura;
import com.sistema_gestion_ventas.factura.domain.service.FacturaService;

public class FindFacturaByIdUseCase {
    private final FacturaService facturaService;

    public FindFacturaByIdUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public Optional<Factura> execute(int facturaId) {
        return facturaService.findFacturaById(facturaId);
    }
}
