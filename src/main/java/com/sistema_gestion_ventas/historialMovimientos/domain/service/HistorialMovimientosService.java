package com.sistema_gestion_ventas.historialMovimientos.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.historialMovimientos.domain.entity.HistorialMovimientos;

public interface HistorialMovimientosService {
    void createHistorialMovimientos(HistorialMovimientos historialmovimientos);
    void updateHistorialMovimientos(HistorialMovimientos historialmovimientos);
    void deleteHistorialMovimientos(String historialmovimientosId);
    Optional<HistorialMovimientos> findHistorialMovimientosById(String historialmovimientosId);
    List<HistorialMovimientos> getAllHistorialMovimientos();
}
