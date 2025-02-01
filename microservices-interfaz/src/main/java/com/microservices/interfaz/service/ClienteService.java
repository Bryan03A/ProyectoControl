package com.microservices.interfaz.service;

import com.microservices.interfaz.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8090/clientes"; // URL del microservicio cliente

    // Obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, Cliente[].class));
    }

    // Obtener cliente por ID
    public Cliente obtenerClientePorId(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Cliente.class);
    }

    // Crear un cliente
    public Cliente crearCliente(Cliente cliente) {
        return restTemplate.postForObject(baseUrl, cliente, Cliente.class);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public void eliminarClientes(List<Long> ids) {
        // Llama al endpoint DELETE para cada ID
        ids.forEach(id -> restTemplate.delete(baseUrl + "/" + id));
    }
}