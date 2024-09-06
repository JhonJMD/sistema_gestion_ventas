package com.sistema_gestion_ventas.pais.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.pais.domain.entity.Pais;

public interface PaisService {
    void createPais (Pais pais);
    Optional<Pais> findPais (int paisid);
    void updatePais (Pais pais);
    void deletePais (int paisid);
    List<Pais> getAllPais();
}
