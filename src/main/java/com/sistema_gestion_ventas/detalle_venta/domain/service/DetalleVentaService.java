package com.sistema_gestion_ventas.detalle_venta.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.detalle_venta.domain.entity.DetalleVenta;

public interface DetalleVentaService {
    void createDetalleVenta(DetalleVenta detalleventa);
    void updateDetalleVenta(DetalleVenta detalleventa);
    void deleteDetalleVenta(int detalleVentaId);
    Optional<DetalleVenta> findDetalleVentaById(int detalleVentaId);
    List<DetalleVenta> getAllDetalleVenta();
}
