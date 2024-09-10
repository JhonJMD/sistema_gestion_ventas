package com.sistema_gestion_ventas.categotia_prodcuto.application;

import java.util.List;

import com.sistema_gestion_ventas.categotia_prodcuto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categotia_prodcuto.domain.service.CategoriaProductoService;

public class GetAllCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaproductoService;

    public GetAllCategoriaProductoUseCase(CategoriaProductoService categoriaproductoService) {
        this.categoriaproductoService = categoriaproductoService;
    }

    public List<CategoriaProducto> execute() {
        return categoriaproductoService.getAllCategoriaProducto();
    }
}
