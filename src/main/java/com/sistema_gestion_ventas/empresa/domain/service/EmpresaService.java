package com.sistema_gestion_ventas.empresa.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.empresa.domain.entity.Empresa;

public interface EmpresaService {
    void createEmpresa(Empresa empresa);
    void updateEmpresa(Empresa empresa);
    void deleteEmpresa(String empresaId);
    Optional<Empresa> findEmpresaById(String empresaId);
    List<Empresa> getAllEmpresa();
}
