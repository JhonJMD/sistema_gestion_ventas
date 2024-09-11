package com.sistema_gestion_ventas.tipo_documento.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.tipo_documento.domain.entity.TipoDocumento;

public interface TipoDocumentoService {
    void createTipoDocumento(TipoDocumento tipodocumento);
    void updateTipoDocumento(TipoDocumento tipodocumento);
    void deleteTipoDocumento(int tipoDocumentoId);
    Optional<TipoDocumento> findTipoDocumentoById(int tipoDocumentoId);
    List<TipoDocumento> getAllTipoDocumento();
}
