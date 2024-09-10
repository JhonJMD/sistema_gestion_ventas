package com.sistema_gestion_ventas.pedido.application;

import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class CreatePedidoUseCase {
    private final PedidoService pedidoService;

    public CreatePedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public void execute(Pedido pedido) {
        pedidoService.createPedido(pedido);
    }
}
