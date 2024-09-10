package com.sistema_gestion_ventas.tipo_pedido.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;

public interface TipoPedidoService {
    void createTipoPedido(TipoPedido tipopedido);
    void updateTipoPedido(TipoPedido tipopedido);
    void deleteTipoPedido(String tipopedidoId);
    Optional<TipoPedido> findTipoPedidoById(String tipopedidoId);
    List<TipoPedido> getAllTipoPedido();
}
