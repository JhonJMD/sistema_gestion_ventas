package com.sistema_gestion_ventas.empresa.application;

import java.util.Optional;
import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class FindEmpresaByIdUseCase {
    private final EmpresaService empresaService;

    public FindEmpresaByIdUseCase(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public Optional<Empresa> execute(int empresaId) {
        return empresaService.findEmpresaById(empresaId);
    }
}
