package com.sistema_gestion_ventas.detalle_pedido.application;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class UpdateDetallePedidoUseCase {
    private final DetallePedidoService detallepedidoService;

    public UpdateDetallePedidoUseCase(DetallePedidoService detallepedidoService) {
        this.detallepedidoService = detallepedidoService;
    }

    public void execute(DetallePedido detallepedido) {
        detallepedidoService.updateDetallePedido(detallepedido);
    }
}
