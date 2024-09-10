package com.sistema_gestion_ventas.tipo_pedido.application;

import com.sistema_gestion_ventas.tipo_pedido.domain.service.TipoPedidoService;

public class DeleteTipoPedidoUseCase {
    private final TipoPedidoService tipopedidoService;

    public DeleteTipoPedidoUseCase(TipoPedidoService tipopedidoService) {
        this.tipopedidoService = tipopedidoService;
    }

    public void execute(String tipopedidoId) {
        tipopedidoService.deleteTipoPedido(tipopedidoId);
    }
}
