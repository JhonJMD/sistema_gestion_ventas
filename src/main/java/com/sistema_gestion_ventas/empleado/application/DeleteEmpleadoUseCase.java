package com.sistema_gestion_ventas.empleado.application;

import com.sistema_gestion_ventas.empleado.domain.service.EmpleadoService;

public class DeleteEmpleadoUseCase {
    private final EmpleadoService empleadoService;

    public DeleteEmpleadoUseCase(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public void execute(String empleadoId) {
        empleadoService.deleteEmpleado(empleadoId);
    }
}
