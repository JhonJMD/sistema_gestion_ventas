package com.sistema_gestion_ventas.cliente.application;

import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;
import com.sistema_gestion_ventas.cliente.domain.service.ClienteService;

public class UpdateClienteUseCase {
    private final ClienteService clienteService;

    public UpdateClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente) {
        clienteService.updateCliente(cliente);
    }
}
