package com.sistema_gestion_ventas.inventario.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;

public interface InventarioService {
    void createInventario(Inventario inventario);
    void updateInventario(Inventario inventario);
    void deleteInventario(int inventarioId);
    Optional<Inventario> findInventarioById(int inventarioId);
    List<Inventario> getAllInventario();
}
