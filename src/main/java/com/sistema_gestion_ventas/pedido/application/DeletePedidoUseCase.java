package com.sistema_gestion_ventas.pedido.application;

import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class DeletePedidoUseCase {
    private final PedidoService pedidoService;

    public DeletePedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void execute(String pedidoId) {
        pedidoService.deletePedido(pedidoId);
    }
}
