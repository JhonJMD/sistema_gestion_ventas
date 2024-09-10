package com.sistema_gestion_ventas.compra.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.compra.domain.entity.Compra;

public interface CompraService {
    void createCompra(Compra compra);
    void updateCompra(Compra compra);
    void deleteCompra(int compraId);
    Optional<Compra> findCompraById(int compraId);
    List<Compra> getAllCompra();
}
