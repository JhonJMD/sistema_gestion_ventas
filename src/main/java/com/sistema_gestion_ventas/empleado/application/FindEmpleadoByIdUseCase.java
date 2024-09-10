package com.sistema_gestion_ventas.empleado.application;

import java.util.Optional;
import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;
import com.sistema_gestion_ventas.empleado.domain.service.EmpleadoService;

public class FindEmpleadoByIdUseCase {
    private final EmpleadoService empleadoService;

    public FindEmpleadoByIdUseCase(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public Optional<Empleado> execute(String empleadoId) {
        return empleadoService.findEmpleadoById(empleadoId);
    }
}
