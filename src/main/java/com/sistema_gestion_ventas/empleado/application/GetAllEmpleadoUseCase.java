package com.sistema_gestion_ventas.empleado.application;

import java.util.List;
import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;
import com.sistema_gestion_ventas.empleado.domain.service.EmpleadoService;

public class GetAllEmpleadoUseCase {
    private final EmpleadoService empleadoService;

    public GetAllEmpleadoUseCase(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    public List<Empleado> execute() {
        return empleadoService.getAllEmpleado();
    }
}
