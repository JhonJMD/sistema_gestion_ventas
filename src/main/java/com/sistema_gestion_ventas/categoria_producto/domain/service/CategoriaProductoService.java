package com.sistema_gestion_ventas.categoria_producto.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.categoria_producto.domain.entity.CategoriaProducto;

public interface CategoriaProductoService {
    void createCategoriaProdcuto (CategoriaProducto CategoriaProducto);
    void updateCategoriaProducto (CategoriaProducto CategoriaProducto);
    void deleteCategoriaProducto (int CategoriaProductoId);
    Optional<CategoriaProducto> findCategoriaProductoById (int CategoriaProductoId);
    List<CategoriaProducto> getAllCategoriaProducto ();
}
