package com.sistema_gestion_ventas.inventario.application;

import java.util.Optional;
import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;
import com.sistema_gestion_ventas.inventario.domain.service.InventarioService;

public class FindInventarioByIdUseCase {
    private final InventarioService inventarioService;

    public FindInventarioByIdUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public Optional<Inventario> execute(int inventarioId) {
        return inventarioService.findInventarioById(inventarioId);
    }
}
