package com.sistema_gestion_ventas.venta.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.venta.domain.entity.Venta;

public interface VentaService {
    void createVenta(Venta venta);
    void updateVenta(Venta venta);
    void deleteVenta(int ventaId);
    Optional<Venta> findVentaById(int ventaId);
    List<Venta> getAllVenta();
}
