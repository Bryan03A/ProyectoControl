package com.microservices.interfaz.service;

import com.microservices.interfaz.model.Producto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8093/productos";

    public List<Producto> obtenerTodosLosProductos() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, Producto[].class));
    }

    public Producto obtenerProductoPorId(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, Producto.class);
    }

    public Producto crearProducto(Producto producto) {
        return restTemplate.postForObject(baseUrl, producto, Producto.class);
    }

    public void eliminarProducto(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public List<Producto> obtenerProductosPorNombre(String nombre) {
        String url = baseUrl + "/buscar?nombre=" + nombre;
        return Arrays.asList(restTemplate.getForObject(url, Producto[].class));
    }

    public void eliminarProductos(List<Long> ids) {
        // Llama al endpoint DELETE para cada ID
        ids.forEach(id -> restTemplate.delete(baseUrl + "/" + id));
    }
}