package com.sistema_gestion_ventas.categoria_producto.application;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class CreateCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaproductoService;

    public CreateCategoriaProductoUseCase(CategoriaProductoService categoriaproductoService) {
        this.categoriaproductoService = categoriaproductoService;
    }

    public void execute(CategoriaProducto categoriaproducto) {
        categoriaproductoService.createCategoriaProducto(categoriaproducto);
    }
}
