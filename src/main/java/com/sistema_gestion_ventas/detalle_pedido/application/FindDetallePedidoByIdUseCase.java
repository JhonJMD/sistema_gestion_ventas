package com.sistema_gestion_ventas.detalle_pedido.application;

import java.util.Optional;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class FindDetallePedidoByIdUseCase {
    private final DetallePedidoService detallepedidoService;

    public FindDetallePedidoByIdUseCase(DetallePedidoService detallepedidoService) {
        this.detallepedidoService = detallepedidoService;
    }

    public Optional<DetallePedido> execute(int detallePedidoId) {
        return detallepedidoService.findDetallePedidoById(detallePedidoId);
    }
}
