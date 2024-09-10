package com.sistema_gestion_ventas.categoria_producto.application;

import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class DeleteCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaProductoService;

    public DeleteCategoriaProductoUseCase(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    public void execute(int categoriaProductoId) {
        categoriaProductoService.deleteCategoriaProducto(categoriaProductoId);
    }
}
