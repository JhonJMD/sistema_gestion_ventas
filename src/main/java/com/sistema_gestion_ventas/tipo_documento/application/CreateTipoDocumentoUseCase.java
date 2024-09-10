package com.sistema_gestion_ventas.tipo_documento.application;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;
import com.sistema_gestion_ventas.tipo_documento.domain.service.TipoDocumentoService;

public class CreateTipoDocumentoUseCase {
    private final TipoDocumentoService tipodocumentoService;

    public CreateTipoDocumentoUseCase(TipoDocumentoService tipodocumentoService) {
        this.tipodocumentoService = tipodocumentoService;
    }

    public void execute(TipoDocumento tipodocumento) {
        tipodocumentoService.createTipoDocumento(tipodocumento);
    }
}
