package com.microservices.interfaz.service;

import com.microservices.interfaz.model.Cajero;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CajeroService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8092/cajeros";

    public List<Cajero> obtenerTodosLosCajeros() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, Cajero[].class));
    }

    public Cajero obtenerCajeroPorId(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Cajero.class);
    }

    public Cajero crearCajero(Cajero cajero) {
        return restTemplate.postForObject(baseUrl, cajero, Cajero.class);
    }

    public void eliminarCajero(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public void eliminarCajeros(List<Long> ids) {
        // Llama al endpoint DELETE para cada ID
        ids.forEach(id -> restTemplate.delete(baseUrl + "/" + id));
    }
}