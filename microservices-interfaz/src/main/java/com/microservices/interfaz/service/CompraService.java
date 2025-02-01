package com.microservices.interfaz.service;

import com.microservices.interfaz.model.dto.CompraDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8094/compras";

    public CompraDTO obtenerCompraPorId(Long id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, CompraDTO.class);
    }

    public List<CompraDTO> obtenerTodasLasCompras() {
        return restTemplate.exchange(
            BASE_URL, 
            org.springframework.http.HttpMethod.GET, 
            null, 
            new org.springframework.core.ParameterizedTypeReference<List<CompraDTO>>() {}
        ).getBody();
    }

    public CompraDTO crearCompra(CompraDTO compraDTO) {
        return restTemplate.postForObject(BASE_URL, compraDTO, CompraDTO.class);
    }

    public void eliminarCompra(Long id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }

    public void eliminarCompras(List<Long> ids) {
        // Llama al endpoint DELETE para cada ID
        ids.forEach(id -> restTemplate.delete(BASE_URL + "/" + id));
    }
    
    
}