package com.sistema_gestion_ventas.historial_movimientos.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.historial_movimientos.domain.entity.HistorialMovimientos;

public interface HistorialMovimientosService {
    void createHistorialMovimientos(HistorialMovimientos historialmovimientos);
    void updateHistorialMovimientos(HistorialMovimientos historialmovimientos);
    void deleteHistorialMovimientos(int historialMovimientosId);
    Optional<HistorialMovimientos> findHistorialMovimientosById(int historialMovimientosId);
    List<HistorialMovimientos> getAllHistorialMovimientos();
}
