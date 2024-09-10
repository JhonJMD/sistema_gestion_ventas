package com.sistema_gestion_ventas.ciudad.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;

public interface CiudadService {
    void createCiudad(Ciudad ciudad);
    void updateCiudad(Ciudad ciudad);
    void deleteCiudad(int ciudadId);
    Optional<Ciudad> findCiudadById(int ciudadId);
    List<Ciudad> getAllCiudad();
}
