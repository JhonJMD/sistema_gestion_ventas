package com.sistema_gestion_ventas.empresa.application;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;
import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class UpdateEmpresaUseCase {
    private final EmpresaService empresaService;

    public UpdateEmpresaUseCase(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public void execute(Empresa empresa) {
        empresaService.updateEmpresa(empresa);
    }
}
