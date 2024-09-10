package com.sistema_gestion_ventas.inventario.application;

import java.util.List;
import com.sistema_gestion_ventas.inventario.domain.entity.Inventario;
import com.sistema_gestion_ventas.inventario.domain.service.InventarioService;

public class GetAllInventarioUseCase {
    private final InventarioService inventarioService;

    public GetAllInventarioUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public List<Inventario> execute() {
        return inventarioService.getAllInventario();
    }
}
