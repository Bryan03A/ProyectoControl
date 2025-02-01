package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.Cliente;
import com.microservices.interfaz.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("nuevoCliente", new Cliente());
        return "clientes";
    }

    @PostMapping("/crear")
    public String crearCliente(@ModelAttribute Cliente nuevoCliente) {
        clienteService.crearCliente(nuevoCliente);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }

    @PostMapping("/eliminar")
    public String eliminarClientesSeleccionados(@RequestBody List<Long> ids) {
        clienteService.eliminarClientes(ids);
        return "redirect:/clientes";
    }
}