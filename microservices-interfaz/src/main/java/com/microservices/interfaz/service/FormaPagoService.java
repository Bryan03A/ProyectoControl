package com.microservices.interfaz.service;

import com.microservices.interfaz.model.FormaPago;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FormaPagoService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8096/formas_pago";

    // Obtener todas las formas de pago
    public List<FormaPago> obtenerTodasLasFormasPago() {
        return Arrays.asList(restTemplate.getForObject(baseUrl, FormaPago[].class));
    }

    // Obtener una forma de pago por id
    public FormaPago obtenerFormaPagoPorId(Long id) {
        return restTemplate.getForObject(baseUrl + "/" + id, FormaPago.class);
    }

    // Crear una nueva forma de pago
    public FormaPago crearFormaPago(FormaPago formaPago) {
        return restTemplate.postForObject(baseUrl, formaPago, FormaPago.class);
    }

    // Eliminar una forma de pago por id
    public void eliminarFormaPago(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    // Obtener formas de pago por nombre
    public List<FormaPago> obtenerFormasPagoPorNombre(String nombre) {
        String url = baseUrl + "/buscar?nombre=" + nombre;
        return Arrays.asList(restTemplate.getForObject(url, FormaPago[].class));
    }

    public void eliminarFormasPago(List<Long> ids) {
        // Llama al endpoint DELETE para cada ID
        ids.forEach(id -> restTemplate.delete(baseUrl + "/" + id));
    }
}