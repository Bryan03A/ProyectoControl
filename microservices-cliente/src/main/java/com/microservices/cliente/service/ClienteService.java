package com.microservices.cliente.service;

import com.microservices.cliente.model.Cliente;
import com.microservices.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Eliminación de múltiples clientes de una vez
    public void eliminarClientes(List<Long> ids) {
        clienteRepository.deleteAllById(ids);  // Elimina todos los clientes con una sola llamada
    }
}
