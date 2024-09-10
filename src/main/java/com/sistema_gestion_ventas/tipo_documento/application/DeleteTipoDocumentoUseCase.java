package com.sistema_gestion_ventas.tipo_documento.application;

import com.sistema_gestion_ventas.tipo_documento.domain.service.TipoDocumentoService;

public class DeleteTipoDocumentoUseCase {
    private final TipoDocumentoService tipodocumentoService;

    public DeleteTipoDocumentoUseCase(TipoDocumentoService tipodocumentoService) {
        this.tipodocumentoService = tipodocumentoService;
    }

    public void execute(String tipodocumentoId) {
        tipodocumentoService.deleteTipoDocumento(tipodocumentoId);
    }
}
