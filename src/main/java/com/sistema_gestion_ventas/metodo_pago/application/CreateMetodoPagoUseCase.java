package com.sistema_gestion_ventas.metodo_pago.application;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;
import com.sistema_gestion_ventas.metodo_pago.domain.service.MetodoPagoService;

public class CreateMetodoPagoUseCase {
    private final MetodoPagoService metodopagoService;

    public CreateMetodoPagoUseCase(MetodoPagoService metodopagoService) {
        this.metodopagoService = metodopagoService;
    }

    public void execute(MetodoPago metodopago) {
        metodopagoService.createMetodoPago(metodopago);
    }
}
