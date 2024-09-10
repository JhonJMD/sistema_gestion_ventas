package com.sistema_gestion_ventas.categotia_prodcuto.application;

import com.sistema_gestion_ventas.categotia_prodcuto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categotia_prodcuto.domain.service.CategoriaProductoService;

public class UpdateCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaproductoService;

    public UpdateCategoriaProductoUseCase(CategoriaProductoService categoriaproductoService) {
        this.categoriaproductoService = categoriaproductoService;
    }

    public void execute(CategoriaProducto categoriaproducto) {
        categoriaproductoService.updateCategoriaProducto(categoriaproducto);
    }
}
