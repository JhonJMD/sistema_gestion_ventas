package com.sistema_gestion_ventas.categoria_producto.application;

import java.util.Optional;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;
import com.sistema_gestion_ventas.categoria_producto.domain.service.CategoriaProductoService;

public class FindCategoriaProductoByIdUseCase {
    private final CategoriaProductoService categoriaProductoService;

    public FindCategoriaProductoByIdUseCase(CategoriaProductoService categoriaProductoService) {
        this.categoriaProductoService = categoriaProductoService;
    }

    public Optional<CategoriaProducto> execute(int categoriaProductoId) {
        return categoriaProductoService.findCategoriaProductoById(categoriaProductoId);
    }
}
