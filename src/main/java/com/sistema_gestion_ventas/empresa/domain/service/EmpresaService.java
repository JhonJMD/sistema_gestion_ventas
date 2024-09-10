package com.sistema_gestion_ventas.empresa.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;

public interface EmpresaService {
    void createEmpresa(Empresa empresa);
    void updateEmpresa(Empresa empresa);
    void deleteEmpresa(int empresaId);
    Optional<Empresa> findEmpresaById(int empresaId);
    List<Empresa> getAllEmpresa();
}
