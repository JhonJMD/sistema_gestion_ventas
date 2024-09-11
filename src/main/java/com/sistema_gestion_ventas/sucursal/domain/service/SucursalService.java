package com.sistema_gestion_ventas.sucursal.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.sucursal.domain.entity.Sucursal;

public interface SucursalService {
    void createSucursal(Sucursal sucursal);
    void updateSucursal(Sucursal sucursal);
    void deleteSucursal(int sucursalId);
    Optional<Sucursal> findSucursalById(int sucursalId);
    List<Sucursal> getAllSucursal();
}
