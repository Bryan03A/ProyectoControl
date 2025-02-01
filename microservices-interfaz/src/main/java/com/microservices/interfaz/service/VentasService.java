package com.microservices.interfaz.service;

import com.microservices.interfaz.model.VentaTotal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

@Service
public class VentasService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8098/totalventas"; // Asegúrate de que sea el puerto correcto

    // Obtener la lista de cajeros disponibles
    public List<String> obtenerCajeros() {
        // Si tienes una lista de cajeros, puedes crear una API en microservice-ventas para ello, 
        // o crear un listado estático por ahora.
        return Arrays.asList("Cajero 1", "Cajero 2", "Cajero 3");
    }

    // Obtener el total de ventas y detalles de artículos vendidos para un cajero específico
    public VentaTotal obtenerVentaTotal(Long cajeroId) {
        String url = BASE_URL + "/total?cajeroId=" + cajeroId;
        ResponseEntity<VentaTotal> response = restTemplate.getForEntity(url, VentaTotal.class);
        return response.getBody();
    }
}