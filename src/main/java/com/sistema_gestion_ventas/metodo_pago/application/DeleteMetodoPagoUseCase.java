package com.sistema_gestion_ventas.metodo_pago.application;

import com.sistema_gestion_ventas.metodo_pago.domain.service.MetodoPagoService;

public class DeleteMetodoPagoUseCase {
    private final MetodoPagoService metodopagoService;

    public DeleteMetodoPagoUseCase(MetodoPagoService metodopagoService) {
        this.metodopagoService = metodopagoService;
    }

    public void execute(String metodopagoId) {
        metodopagoService.deleteMetodoPago(metodopagoId);
    }
}
