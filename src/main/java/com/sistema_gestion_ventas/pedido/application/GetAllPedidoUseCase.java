package com.sistema_gestion_ventas.pedido.application;

import java.util.List;
import com.sistema_gestion_ventas.pedido.domain.entity.Pedido;
import com.sistema_gestion_ventas.pedido.domain.service.PedidoService;

public class GetAllPedidoUseCase {
    private final PedidoService pedidoService;

    public GetAllPedidoUseCase(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public List<Pedido> execute() {
        return pedidoService.getAllPedido();
    }
}
