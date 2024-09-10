package com.sistema_gestion_ventas.detalle_pedido.application;

import java.util.List;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;
import com.sistema_gestion_ventas.detalle_pedido.domain.service.DetallePedidoService;

public class GetAllDetallePedidoUseCase {
    private final DetallePedidoService detallepedidoService;

    public GetAllDetallePedidoUseCase(DetallePedidoService detallepedidoService) {
        this.detallepedidoService = detallepedidoService;
    }

    public List<DetallePedido> execute() {
        return detallepedidoService.getAllDetallePedido();
    }
}
