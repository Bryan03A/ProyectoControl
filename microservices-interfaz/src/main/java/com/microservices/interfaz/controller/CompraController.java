package com.microservices.interfaz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.microservices.interfaz.service.CompraService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class CompraController {

    @Autowired
    private RestTemplate restTemplate;
    private CompraService compraService;

    private static final String COMPRA_SERVICE_URL = "http://localhost:8093/compras";

    @GetMapping("/compras")
    public String mostrarCompras(Model model) {
        Object[] compras = restTemplate.getForObject(COMPRA_SERVICE_URL, Object[].class);
        model.addAttribute("compras", compras);
        return "compras";
    }

    @PostMapping("/eliminar")
    public String eliminarComprasSeleccionadas(@RequestBody List<Long> ids) {
        compraService.eliminarCompras(ids);
        return "redirect:/compras";
    }
    
}