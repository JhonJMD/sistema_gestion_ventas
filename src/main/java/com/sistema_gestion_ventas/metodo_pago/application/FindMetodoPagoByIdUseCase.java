package com.sistema_gestion_ventas.metodo_pago.application;

import java.util.Optional;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;
import com.sistema_gestion_ventas.metodo_pago.domain.service.MetodoPagoService;

public class FindMetodoPagoByIdUseCase {
    private final MetodoPagoService metodopagoService;

    public FindMetodoPagoByIdUseCase(MetodoPagoService metodopagoService) {
        this.metodopagoService = metodopagoService;
    }

    public Optional<MetodoPago> execute(String metodopagoId) {
        return metodopagoService.findMetodoPagoById(metodopagoId);
    }
}
