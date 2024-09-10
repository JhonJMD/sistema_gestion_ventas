package com.sistema_gestion_ventas.categoria_producto.application;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class CreateCategoriaProductoUseCase {
    private final CategoriaProductoService categoriaProductoService;

    public CreateCategoriaProductoUseCase(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    public void execute(CategoriaProducto categoriaProducto) {
        categoriaProductoService.createCategoriaProdcuto(categoriaProducto);
    }
}
