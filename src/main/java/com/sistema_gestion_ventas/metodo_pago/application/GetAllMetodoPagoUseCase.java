package com.sistema_gestion_ventas.metodo_pago.application;

import java.util.List;

import com.sistema_gestion_ventas.metodo_pago.domain.entity.MetodoPago;
import com.sistema_gestion_ventas.metodo_pago.domain.service.MetodoPagoService;

public class GetAllMetodoPagoUseCase {
    private final MetodoPagoService metodopagoService;

    public GetAllMetodoPagoUseCase(MetodoPagoService metodopagoService) {
        this.metodopagoService = metodopagoService;
    }

    public List<MetodoPago> execute() {
        return metodopagoService.getAllMetodoPago();
    }
}
