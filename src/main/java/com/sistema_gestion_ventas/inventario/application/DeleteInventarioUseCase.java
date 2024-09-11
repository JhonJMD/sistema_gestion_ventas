package com.sistema_gestion_ventas.inventario.application;

import com.sistema_gestion_ventas.inventario.domain.service.InventarioService;

public class DeleteInventarioUseCase {
    private final InventarioService inventarioService;

    public DeleteInventarioUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void execute(int inventarioId) {
        inventarioService.deleteInventario(inventarioId);
    }
}
