package com.microservices.interfaz.service;

import com.microservices.interfaz.model.Cliente;
import com.microservices.interfaz.model.FormaPago;
import com.microservices.interfaz.model.CompraTotal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@Service
public class CompraTotalService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8097/compratotal"; // Asegúrate de que sea el puerto correcto

    public List<Cliente> obtenerClientes() {
        ResponseEntity<Cliente[]> response = restTemplate.getForEntity(BASE_URL + "/clientes", Cliente[].class);
        return Arrays.asList(response.getBody());
    }

    public List<FormaPago> obtenerFormasPago() {
        ResponseEntity<FormaPago[]> response = restTemplate.getForEntity(BASE_URL + "/formas-pago", FormaPago[].class);
        return Arrays.asList(response.getBody());
    }

    public CompraTotal calcularTotal(Long clienteId, Long formaPagoId) {
        String url = BASE_URL + "/calcular?clienteId=" + clienteId + "&formaPagoId=" + formaPagoId;
        return restTemplate.postForObject(url, null, CompraTotal.class);
    }
}
