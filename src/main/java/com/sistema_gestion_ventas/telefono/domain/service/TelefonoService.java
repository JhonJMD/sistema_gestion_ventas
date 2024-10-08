package com.sistema_gestion_ventas.telefono.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.telefono.domain.entity.Telefono;

public interface TelefonoService {
    void createTelefono(Telefono telefono);
    void updateTelefono(Telefono telefono);
    void deleteTelefono(int telefonoId);
    Optional<Telefono> findTelefonoById(int telefonoId);
    List<Telefono> getAllTelefono();
}
