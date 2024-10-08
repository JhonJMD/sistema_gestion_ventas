package com.sistema_gestion_ventas.pedido.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;

public interface PedidoService {
    void createPedido(Pedido pedido);
    void updatePedido(Pedido pedido);
    void deletePedido(int pedidoId);
    Optional<Pedido> findPedidoById(int pedidoId);
    List<Pedido> getAllPedido();
}
