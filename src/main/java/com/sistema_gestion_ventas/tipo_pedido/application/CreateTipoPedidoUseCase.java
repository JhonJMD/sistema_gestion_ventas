package com.sistema_gestion_ventas.tipo_pedido.application;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;
import com.sistema_gestion_ventas.tipo_pedido.domain.service.TipoPedidoService;

public class CreateTipoPedidoUseCase {
    private final TipoPedidoService tipopedidoService;

    public CreateTipoPedidoUseCase(TipoPedidoService tipopedidoService) {
        this.tipopedidoService = tipopedidoService;
    }

    public void execute(TipoPedido tipopedido) {
        tipopedidoService.createTipoPedido(tipopedido);
    }
}
