package com.sistema_gestion_ventas.producto.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.producto.domain.entity.Producto;

public interface ProductoService {
    void createProducto(Producto producto);
    void updateProducto(Producto producto);
    void deleteProducto(int productoId);
    Optional<Producto> findProductoById(int productoId);
    List<Producto> getAllProducto();
}
