package com.microservices.compratotal.controller;

import com.microservices.compratotal.model.Cliente;
import com.microservices.compratotal.model.Compra;
import com.microservices.compratotal.model.FormaPago;
import com.microservices.compratotal.model.CompraTotal;
import com.microservices.compratotal.service.CompraTotalService;
import com.microservices.compratotal.repository.ClienteRepository;
import com.microservices.compratotal.repository.FormaPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compratotal")
@CrossOrigin(origins = "*")
public class CompraTotalController {
    @Autowired
    private CompraTotalService compraTotalService;
    
    @Autowired
    private FormaPagoRepository formaPagoRepository;

    // Obtener todos los clientes
    @GetMapping("/clientes")
    public List<Cliente> obtenerClientes() {
        return compraTotalService.obtenerTodosLosClientes();
    }

    // Obtener todas las formas de pago
    @GetMapping("/formas-pago")
    public List<FormaPago> obtenerFormasPago() {
        return formaPagoRepository.findAll();
    }

    // Calcular el total de compras para un cliente y forma de pago
    @PostMapping("/calcular")
    public CompraTotal calcularTotal(@RequestParam Long clienteId, @RequestParam Long formaPagoId) {
        return compraTotalService.calcularTotalPorCliente(clienteId, formaPagoId);
    }

    @GetMapping("/compras/{clienteId}")
    public List<Compra> obtenerComprasPorCliente(@PathVariable Long clienteId) {
        return compraTotalService.obtenerComprasPorCliente(clienteId);
    }

}
