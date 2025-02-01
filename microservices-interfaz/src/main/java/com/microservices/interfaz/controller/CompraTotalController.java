package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.Cliente;
import com.microservices.interfaz.model.FormaPago;
import com.microservices.interfaz.model.CompraTotal;
import com.microservices.interfaz.service.CompraTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/compratotal")
public class CompraTotalController {

    @Autowired
    private CompraTotalService compraTotalService;

    @GetMapping
    public String mostrarFormulario(Model model) {
        List<Cliente> clientes = compraTotalService.obtenerClientes();
        List<FormaPago> formasPago = compraTotalService.obtenerFormasPago();

        model.addAttribute("clientes", clientes);
        model.addAttribute("formasPago", formasPago);
        model.addAttribute("compraTotal", new CompraTotal());

        return "compratotal";
    }

    @PostMapping("/calcular")
    public String calcularTotal(
            @RequestParam Long clienteId,
            @RequestParam Long formaPagoId,
            Model model) {

        CompraTotal compraTotal = compraTotalService.calcularTotal(clienteId, formaPagoId);

        model.addAttribute("clientes", compraTotalService.obtenerClientes());
        model.addAttribute("formasPago", compraTotalService.obtenerFormasPago());
        model.addAttribute("compraTotal", compraTotal);

        return "compratotal";
    }
}