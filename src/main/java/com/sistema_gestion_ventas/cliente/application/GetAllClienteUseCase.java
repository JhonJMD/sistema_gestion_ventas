package com.sistema_gestion_ventas.cliente.application;

import java.util.List;
import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;
import com.sistema_gestion_ventas.cliente.domain.service.ClienteService;

public class GetAllClienteUseCase {
    private final ClienteService clienteService;

    public GetAllClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> execute() {
        return clienteService.getAllCliente();
    }
}
