package com.sistema_gestion_ventas.metodo_pago.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;

public interface MetodoPagoService {
    void createMetodoPago(MetodoPago metodopago);
    void updateMetodoPago(MetodoPago metodopago);
    void deleteMetodoPago(String metodopagoId);
    Optional<MetodoPago> findMetodoPagoById(String metodopagoId);
    List<MetodoPago> getAllMetodoPago();
}
