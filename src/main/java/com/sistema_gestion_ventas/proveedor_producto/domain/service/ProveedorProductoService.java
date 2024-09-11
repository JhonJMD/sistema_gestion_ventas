package com.sistema_gestion_ventas.proveedor_producto.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.proveedor_producto.domain.entity.ProveedorProducto;

public interface ProveedorProductoService {
    void createProveedorProducto(ProveedorProducto proveedorProducto);
    void updateProveedorProducto(ProveedorProducto proveedorProducto);
    void deleteProveedorProducto(String proveedorProductoId);
    Optional<ProveedorProducto> findProveedorProductoById(String proveedorProductoId);
    List<ProveedorProducto> getAllProveedorProducto();
}
