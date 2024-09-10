package com.sistema_gestion_ventas.tipo_movimiento.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;

public interface TipoMovimientoService {
    void createTipoMovimiento(TipoMovimiento tipomovimiento);
    void updateTipoMovimiento(TipoMovimiento tipomovimiento);
    void deleteTipoMovimiento(String tipomovimientoId);
    Optional<TipoMovimiento> findTipoMovimientoById(String tipomovimientoId);
    List<TipoMovimiento> getAllTipoMovimiento();
}
