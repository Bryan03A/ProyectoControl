package com.microservices.cajero.controller;

import com.microservices.cajero.model.Cajero;
import com.microservices.cajero.service.CajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cajeros")
public class CajeroController {

    @Autowired
    private CajeroService cajeroService;

    @PostMapping
    public ResponseEntity<Cajero> crearCajero(@RequestBody Cajero cajero) {
        Cajero nuevoCajero = cajeroService.crearCajero(cajero);
        return new ResponseEntity<>(nuevoCajero, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cajero> obtenerCajeroPorId(@PathVariable Long id) {
        Optional<Cajero> cajero = cajeroService.obtenerCajeroPorId(id);
        return cajero.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Cajero>> obtenerTodosLosCajeros() {
        List<Cajero> cajeros = cajeroService.obtenerTodosLosCajeros();
        return new ResponseEntity<>(cajeros, HttpStatus.OK);
    }

    @GetMapping("/sucursal/{sucursal}")
    public ResponseEntity<List<Cajero>> obtenerCajerosPorSucursal(@PathVariable String sucursal) {
        List<Cajero> cajeros = cajeroService.obtenerCajerosPorSucursal(sucursal);
        return new ResponseEntity<>(cajeros, HttpStatus.OK);
    }

    @GetMapping("/turno/{turno}")
    public ResponseEntity<List<Cajero>> obtenerCajerosPorTurno(@PathVariable String turno) {
        List<Cajero> cajeros = cajeroService.obtenerCajerosPorTurno(turno);
        return new ResponseEntity<>(cajeros, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCajero(@PathVariable Long id) {
        cajeroService.eliminarCajero(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}