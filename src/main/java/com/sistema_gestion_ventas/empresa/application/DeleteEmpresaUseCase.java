package com.sistema_gestion_ventas.empresa.application;

import com.sistema_gestion_ventas.empresa.domain.service.EmpresaService;

public class DeleteEmpresaUseCase {
    private final EmpresaService empresaService;

    public DeleteEmpresaUseCase(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public void execute(String empresaId) {
        empresaService.deleteEmpresa(empresaId);
    }
}
