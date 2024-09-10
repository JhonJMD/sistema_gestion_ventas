package com.sistema_gestion_ventas.pais.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;

public interface PaisService {
    void createPais(Pais pais);
    void updatePais(Pais pais);
    void deletePais(String paisId);
    Optional<Pais> findPaisById(String paisId);
    List<Pais> getAllPais();
}
