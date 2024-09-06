package com.sistema_gestion_ventas.ciudad.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.ciudad.domain.entity.Ciudad;

public interface CuidadService {
    void createCiudad (Ciudad ciudad);
    void updateCiudad (Ciudad ciudad);
    void deleteCiudad (int ciudadid);
    Optional<Ciudad> findCiudadById (int ciudadid);
    List<Ciudad> getAllCiudad ();
}
