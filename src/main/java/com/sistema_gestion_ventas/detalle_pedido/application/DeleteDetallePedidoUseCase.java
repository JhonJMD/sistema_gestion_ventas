package com.sistema_gestion_ventas.detalle_pedido.application;

import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class DeleteDetallePedidoUseCase {
    private final DetallePedidoService detallepedidoService;

    public DeleteDetallePedidoUseCase(DetallePedidoService detallepedidoService) {
        this.detallepedidoService = detallepedidoService;
    }

    public void execute(int detallePedidoId) {
        detallepedidoService.deleteDetallePedido(detallePedidoId);
    }
}
