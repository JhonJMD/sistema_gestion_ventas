package com.sistema_gestion_ventas.tipo_documento.application;

import java.util.List;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;
import com.sistema_gestion_ventas.tipo_documento.domain.service.TipoDocumentoService;

public class GetAllTipoDocumentoUseCase {
    private final TipoDocumentoService tipodocumentoService;

    public GetAllTipoDocumentoUseCase(TipoDocumentoService tipodocumentoService) {
        this.tipodocumentoService = tipodocumentoService;
    }

    public List<TipoDocumento> execute() {
        return tipodocumentoService.getAllTipoDocumento();
    }
}
