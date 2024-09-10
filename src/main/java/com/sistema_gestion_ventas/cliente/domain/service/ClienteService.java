package com.sistema_gestion_ventas.cliente.domain.service;

import java.util.List;
import java.util.Optional;

import com.sistema_gestion_ventas.cliente.domain.entity.Cliente;

public interface ClienteService {
    void createCliente(Cliente cliente);
    void updateCliente(Cliente cliente);
    void deleteCliente(String clienteId);
    Optional<Cliente> findClienteById(String clienteId);
    List<Cliente> getAllCliente();
}
