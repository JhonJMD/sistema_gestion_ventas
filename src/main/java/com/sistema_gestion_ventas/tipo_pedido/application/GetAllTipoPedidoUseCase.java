package com.sistema_gestion_ventas.tipo_pedido.application;

import java.util.List;

import com.sistema_gestion_ventas.tipo_pedido.domain.entity.TipoPedido;
import com.sistema_gestion_ventas.tipo_pedido.domain.service.TipoPedidoService;

public class GetAllTipoPedidoUseCase {
    private final TipoPedidoService tipopedidoService;

    public GetAllTipoPedidoUseCase(TipoPedidoService tipopedidoService) {
        this.tipopedidoService = tipopedidoService;
    }

    public List<TipoPedido> execute() {
        return tipopedidoService.getAllTipoPedido();
    }
}
