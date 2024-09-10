package com.sistema_gestion_ventas.estado.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.estado.domain.entity.Estado;

public interface EstadoService {
    void createEstado(Estado estado);
    void updateEstado(Estado estado);
    void deleteEstado(int estadoId);
    Optional<Estado> findEstadoById(int estadoId);
    List<Estado> getAllEstado();
}
