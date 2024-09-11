package com.sistema_gestion_ventas.tipo_telefono.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.tipo_telefono.domain.entity.TipoTelefono;

public interface TipoTelefonoService {
    void createTipoTelefono(TipoTelefono tipoTelefono);
    void updateTipoTelefono(TipoTelefono tipoTelefono);
    void deleteTipoTelefono(int tipoTelefonoId);
    Optional<TipoTelefono> findTipoTelefonoById(int tipoTelefonoId);
    List<TipoTelefono> getAllTipoTelefono();
}
