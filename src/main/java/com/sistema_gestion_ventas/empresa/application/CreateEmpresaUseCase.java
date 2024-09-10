package com.sistema_gestion_ventas.empresa.application;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class CreateEmpresaUseCase {
    private final EmpresaService empresaService;

    public CreateEmpresaUseCase(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public void execute(Empresa empresa) {
        empresaService.createEmpresa(empresa);
    }
}
