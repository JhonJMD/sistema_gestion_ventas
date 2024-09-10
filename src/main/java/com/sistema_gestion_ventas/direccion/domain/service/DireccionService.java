package com.sistema_gestion_ventas.direccion.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;

public interface DireccionService {
    void createDireccion(Direccion direccion);
    void updateDireccion(Direccion direccion);
    void deleteDireccion(int direccionId);
    Optional<Direccion> findDireccionById(int direccionId);
    List<Direccion> getAllDireccion();
}
