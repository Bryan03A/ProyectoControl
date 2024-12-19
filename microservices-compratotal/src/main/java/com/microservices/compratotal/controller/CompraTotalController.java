package com.microservices.compratotal.controller;

import com.microservices.compratotal.model.CompraTotal;
import com.microservices.compratotal.service.CompraTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras_total")
public class CompraTotalController {

    @Autowired
    private CompraTotalService compraTotalService;

    @GetMapping
    public ResponseEntity<CompraTotal> calcularTotalPorCliente(
            @RequestParam Long clienteId,
            @RequestParam Long formaPagoId) {

        CompraTotal compraTotal = compraTotalService.calcularTotalPorCliente(clienteId, formaPagoId);
        return new ResponseEntity<>(compraTotal, HttpStatus.OK);
    }
}
