package com.sistema_gestion_ventas.devolucion.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.devolucion.domain.entity.Devolucion;

public interface DevolucionService {
    void createDevolucion(Devolucion devolucion);
    void updateDevolucion(Devolucion devolucion);
    void deleteDevolucion(int devolucionId);
    Optional<Devolucion> findDevolucionById(int devolucionId);
    List<Devolucion> getAllDevolucion();
}
