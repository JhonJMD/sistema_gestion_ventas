package com.sistema_gestion_ventas.tipo_documento.application;

import java.util.Optional;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;
import com.sistema_gestion_ventas.tipo_documento.domain.service.TipoDocumentoService;

public class FindTipoDocumentoByIdUseCase {
    private final TipoDocumentoService tipodocumentoService;

    public FindTipoDocumentoByIdUseCase(TipoDocumentoService tipodocumentoService) {
        this.tipodocumentoService = tipodocumentoService;
    }

    public Optional<TipoDocumento> execute(String tipodocumentoId) {
        return tipodocumentoService.findTipoDocumentoById(tipodocumentoId);
    }
}
