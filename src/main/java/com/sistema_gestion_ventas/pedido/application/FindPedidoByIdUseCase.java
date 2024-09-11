package com.sistema_gestion_ventas.pedido.application;

import java.util.Optional;
import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class FindPedidoByIdUseCase {
    private final PedidoService pedidoService;

    public FindPedidoByIdUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public Optional<Pedido> execute(int pedidoId) {
        return pedidoService.findPedidoById(pedidoId);
    }
}
