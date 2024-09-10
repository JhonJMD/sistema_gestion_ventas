package com.sistema_gestion_ventas.detalle_pedido.application;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class CreateDetallePedidoUseCase {
    private final DetallePedidoService detallepedidoService;

    public CreateDetallePedidoUseCase(DetallePedidoService detallepedidoService) {
        this.detallepedidoService = detallepedidoService;
    }

    public void execute(DetallePedido detallepedido) {
        detallepedidoService.createDetallePedido(detallepedido);
    }
}
