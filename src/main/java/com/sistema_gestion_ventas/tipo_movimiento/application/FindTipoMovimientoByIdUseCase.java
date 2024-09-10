package com.sistema_gestion_ventas.tipo_movimiento.application;

import java.util.Optional;

import com.sistema_gestion_ventas.tipo_movimiento.domain.entity.TipoMovimiento;
import com.sistema_gestion_ventas.tipo_movimiento.domain.service.TipoMovimientoService;

public class FindTipoMovimientoByIdUseCase {
    private final TipoMovimientoService tipomovimientoService;

    public FindTipoMovimientoByIdUseCase(TipoMovimientoService tipomovimientoService) {
        this.tipomovimientoService = tipomovimientoService;
    }

    public Optional<TipoMovimiento> execute(String tipomovimientoId) {
        return tipomovimientoService.findTipoMovimientoById(tipomovimientoId);
    }
}
