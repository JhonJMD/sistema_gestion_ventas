package com.sistema_gestion_ventas.empleado.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.empleado.domain.entity.Empleado;

public interface EmpleadoService {
    void createEmpleado(Empleado empleado);
    void updateEmpleado(Empleado empleado);
    void deleteEmpleado(String empleadoId);
    Optional<Empleado> findEmpleadoById(String empleadoId);
    List<Empleado> getAllEmpleado();
}
