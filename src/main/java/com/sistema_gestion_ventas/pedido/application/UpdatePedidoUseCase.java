package com.sistema_gestion_ventas.pedido.application;

import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class UpdatePedidoUseCase {
    private final PedidoService pedidoService;

    public UpdatePedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void execute(Pedido pedido) {
        pedidoService.updatePedido(pedido);
    }
}
