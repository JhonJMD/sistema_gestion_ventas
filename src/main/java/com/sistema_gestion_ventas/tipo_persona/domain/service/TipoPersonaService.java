package com.sistema_gestion_ventas.tipo_persona.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.tipo_persona.domain.entity.TipoPersona;

public interface TipoPersonaService {
    void createTipoPersona(TipoPersona tipoPersona);
    void updateTipoPersona(TipoPersona tipoPersona);
    void deleteTipoPersona(int tipoPersonaId);
    Optional<TipoPersona> findTipoPersonaById(int tipoPersonaId);
    List<TipoPersona> getAllTipoPersona();
}
