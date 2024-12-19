package com.microservices.formapago.controller;

import com.microservices.formapago.model.FormaPago;
import com.microservices.formapago.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formas_pago")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    @PostMapping
    public ResponseEntity<FormaPago> crearFormaPago(@RequestBody FormaPago formaPago) {
        FormaPago nuevaFormaPago = formaPagoService.crearFormaPago(formaPago);
        return new ResponseEntity<>(nuevaFormaPago, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPago> obtenerFormaPagoPorId(@PathVariable Long id) {
        Optional<FormaPago> formaPago = formaPagoService.obtenerFormaPagoPorId(id);
        return formaPago.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<FormaPago>> obtenerTodasLasFormasPago() {
        List<FormaPago> formasPago = formaPagoService.obtenerTodasLasFormasPago();
        return new ResponseEntity<>(formasPago, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFormaPago(@PathVariable Long id) {
        formaPagoService.eliminarFormaPago(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

