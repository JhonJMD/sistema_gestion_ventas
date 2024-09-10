package com.sistema_gestion_ventas.detalle_compra.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.detalle_compra.domain.entity.DetalleCompra;

public interface DetalleCompraService {
    void createDetalleCompra(DetalleCompra detallecompra);
    void updateDetalleCompra(DetalleCompra detallecompra);
    void deleteDetalleCompra(int detalleCompraId);
    Optional<DetalleCompra> findDetalleCompraById(int detalleCompraId);
    List<DetalleCompra> getAllDetalleCompra();
}
