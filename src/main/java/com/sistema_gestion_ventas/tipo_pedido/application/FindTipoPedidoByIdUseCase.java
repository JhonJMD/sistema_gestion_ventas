package com.sistema_gestion_ventas.tipo_pedido.application;

import java.util.Optional;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;
import com.sistema_gestion_ventas.tipo_pedido.domain.service.TipoPedidoService;

public class FindTipoPedidoByIdUseCase {
    private final TipoPedidoService tipopedidoService;

    public FindTipoPedidoByIdUseCase(TipoPedidoService tipopedidoService) {
        this.tipopedidoService = tipopedidoService;
    }

    public Optional<TipoPedido> execute(String tipopedidoId) {
        return tipopedidoService.findTipoPedidoById(tipopedidoId);
    }
}
