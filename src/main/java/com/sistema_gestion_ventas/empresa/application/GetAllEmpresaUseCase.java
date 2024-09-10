package com.sistema_gestion_ventas.empresa.application;

import java.util.List;
import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class GetAllEmpresaUseCase {
    private final EmpresaService empresaService;

    public GetAllEmpresaUseCase(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public List<Empresa> execute() {
        return empresaService.getAllEmpresa();
    }
}
