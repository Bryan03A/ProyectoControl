package com.microservices.ventas.controller;

import com.microservices.ventas.model.Compra;
import com.microservices.ventas.service.TotalVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/totalventas")
public class TotalVentasController {

    @Autowired
    private TotalVentasService totalVentasService;

    @GetMapping("/articulos")
    public ResponseEntity<Map<String, Object>> obtenerArticulosVendidos(
            @RequestParam Long cajeroId) {
        List<Compra> compras = totalVentasService.obtenerArticulosVendidos(cajeroId);
        Double totalVentas = totalVentasService.calcularTotalVentas(cajeroId);

        if (compras.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Obteniendo la información del primer cajero, asumiendo que todas las compras son del mismo cajero
        Compra compraEjemplo = compras.get(0);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("cajeroId", compraEjemplo.getCajero().getId());
        respuesta.put("cajeroNombre", compraEjemplo.getCajero().getNombre());
        respuesta.put("cajeroTurno", compraEjemplo.getCajero().getTurno());
        respuesta.put("sucursal", compraEjemplo.getCajero().getSucursal());

        // Agregando la lista de productos vendidos
        respuesta.put("productosVendidos", compras);

        // Agregando el total de ventas
        respuesta.put("totalVentas", totalVentas);

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> calcularTotalVentas(
            @RequestParam Long cajeroId) {
        Double totalVentas = totalVentasService.calcularTotalVentas(cajeroId);
        List<Compra> compras = totalVentasService.obtenerArticulosVendidos(cajeroId);

        if (compras.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Obteniendo la información del primer cajero
        Compra compraEjemplo = compras.get(0);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("cajeroId", compraEjemplo.getCajero().getId());
        respuesta.put("cajeroNombre", compraEjemplo.getCajero().getNombre());
        respuesta.put("cajeroTurno", compraEjemplo.getCajero().getTurno());
        respuesta.put("sucursal", compraEjemplo.getCajero().getSucursal());

        // Agregando el total de ventas
        respuesta.put("totalVentas", totalVentas);

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}