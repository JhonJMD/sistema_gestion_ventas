package com.sistema_gestion_ventas.categotia_prodcuto.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.categotia_prodcuto.domain.entity.CategoriaProducto;

public interface CategoriaProductoService {
    void createCategoriaProducto(CategoriaProducto categoriaproducto);
    void updateCategoriaProducto(CategoriaProducto categoriaproducto);
    void deleteCategoriaProducto(int categoriaProductoId);
    Optional<CategoriaProducto> findCategoriaProductoById(int categoriaProductoId);
    List<CategoriaProducto> getAllCategoriaProducto();
}
