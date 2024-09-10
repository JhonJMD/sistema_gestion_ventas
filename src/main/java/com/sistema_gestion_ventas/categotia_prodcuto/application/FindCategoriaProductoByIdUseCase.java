package com.sistema_gestion_ventas.categotia_prodcuto.application;

import java.util.Optional;

import com.sistema_gestion_ventas.categotia_prodcuto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categotia_prodcuto.domain.service.CategoriaProductoService;

public class FindCategoriaProductoByIdUseCase {
    private final CategoriaProductoService categoriaproductoService;

    public FindCategoriaProductoByIdUseCase(CategoriaProductoService categoriaproductoService) {
        this.categoriaproductoService = categoriaproductoService;
    }

    public Optional<CategoriaProducto> execute(int categoriaProductoId) {
        return categoriaproductoService.findCategoriaProductoById(categoriaProductoId);
    }
}
