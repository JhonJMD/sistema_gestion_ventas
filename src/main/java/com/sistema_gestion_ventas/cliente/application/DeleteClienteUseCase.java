package com.sistema_gestion_ventas.cliente.application;

import com.sistema_gestion_ventas.cliente.domain.service.ClienteService;

public class DeleteClienteUseCase {
    private final ClienteService clienteService;

    public DeleteClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(String clienteId) {
        clienteService.deleteCliente(clienteId);
    }
}
