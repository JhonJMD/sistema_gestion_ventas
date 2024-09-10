package com.sistema_gestion_ventas.direccion.application;

import java.util.List;
import com.sistema_gestion_ventas.direccion.domain.entity.Direccion;
import com.sistema_gestion_ventas.direccion.domain.service.DireccionService;

public class GetAllDireccionUseCase {
    private final DireccionService direccionService;

    public GetAllDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public List<Direccion> execute() {
        return direccionService.getAllDireccion();
    }
}
