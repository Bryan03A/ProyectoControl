package com.microservices.compra.controller;

import com.microservices.compra.model.Compra;
import com.microservices.compra.model.dto.CompraDTO;
import com.microservices.compra.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraDTO> crearCompra(@RequestBody Compra compra) {
        try {
            CompraDTO nuevaCompra = compraService.crearCompra(compra);
            return new ResponseEntity<>(nuevaCompra, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> obtenerCompraPorId(@PathVariable Long id) {
        Optional<CompraDTO> compra = compraService.obtenerCompraPorId(id);
        return compra.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<CompraDTO>> obtenerTodasLasCompras() {
        List<CompraDTO> compras = compraService.obtenerTodasLasCompras();
        return new ResponseEntity<>(compras, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/eliminar")
    public ResponseEntity<Void> eliminarCompras(@RequestBody List<Long> ids) {
        compraService.eliminarCompras(ids);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



