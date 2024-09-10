package com.sistema_gestion_ventas.empleado.application;

import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;
import com.sistema_gestion_ventas.empleado.domain.service.EmpleadoService;

public class CreateEmpleadoUseCase {
    private final EmpleadoService empleadoService;

    public CreateEmpleadoUseCase(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public void execute(Empleado empleado) {
        empleadoService.createEmpleado(empleado);
    }
}
