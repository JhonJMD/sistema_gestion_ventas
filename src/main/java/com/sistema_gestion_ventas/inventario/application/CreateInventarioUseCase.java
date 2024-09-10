package com.sistema_gestion_ventas.inventario.application;

import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;
import com.sistema_gestion_ventas.inventario.domain.service.InventarioService;

public class CreateInventarioUseCase {
    private final InventarioService inventarioService;

    public CreateInventarioUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void execute(Inventario inventario) {
        inventarioService.createInventario(inventario);
    }
}
