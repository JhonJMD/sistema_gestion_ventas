package com.sistema_gestion_ventas.detalle_pedido.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.detalle_pedido.domain.entity.DetallePedido;

public interface DetallePedidoService {
    void createDetallePedido(DetallePedido detallepedido);
    void updateDetallePedido(DetallePedido detallepedido);
    void deleteDetallePedido(int detallePedidoId);
    Optional<DetallePedido> findDetallePedidoById(int detallePedidoId);
    List<DetallePedido> getAllDetallePedido();
}
