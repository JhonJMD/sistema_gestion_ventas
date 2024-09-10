package com.sistema_gestion_ventas.cliente.application;

import java.util.Optional;
import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;
import com.sistema_gestion_ventas.cliente.domain.service.ClienteService;

public class FindClienteByIdUseCase {
    private final ClienteService clienteService;

    public FindClienteByIdUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<Cliente> execute(String clienteId) {
        return clienteService.findClienteById(clienteId);
    }
}
