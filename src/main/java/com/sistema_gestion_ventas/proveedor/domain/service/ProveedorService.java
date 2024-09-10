package com.sistema_gestion_ventas.proveedor.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.proveedor.domain.entity.Proveedor;

public interface ProveedorService {
    void createProveedor(Proveedor proveedor);
    void updateProveedor(Proveedor proveedor);
    void deleteProveedor(String proveedorId);
    Optional<Proveedor> findProveedorById(String proveedorId);
    List<Proveedor> getAllProveedor();
}
