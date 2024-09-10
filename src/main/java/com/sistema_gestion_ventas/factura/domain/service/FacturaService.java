package com.sistema_gestion_ventas.factura.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.factura.domain.entity.Factura;

public interface FacturaService {
    void createFactura(Factura factura);
    void updateFactura(Factura factura);
    void deleteFactura(int facturaId);
    Optional<Factura> findFacturaById(int facturaId);
    List<Factura> getAllFactura();
}
