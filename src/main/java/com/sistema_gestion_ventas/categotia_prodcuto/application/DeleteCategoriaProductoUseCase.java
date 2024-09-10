package com.sistema_gestion_ventas.categotia_prodcuto.application;

import com.sistema_gestion_ventas.categotia_prodcuto.domain.service.CategoriaProductoService;

public class DeleteCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaproductoService;

    public DeleteCategoriaProductoUseCase(CategoriaProductoService categoriaproductoService) {
        this.categoriaproductoService = categoriaproductoService;
    }

    public void execute(int categoriaProductoId) {
        categoriaproductoService.deleteCategoriaProducto(categoriaProductoId);
    }
}
