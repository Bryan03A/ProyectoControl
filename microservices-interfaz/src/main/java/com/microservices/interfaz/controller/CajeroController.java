package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.Cajero;
import com.microservices.interfaz.service.CajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/cajeros")
public class CajeroController {

    @Autowired
    private CajeroService cajeroService;

    @GetMapping
    public String listarCajeros(Model model) {
        model.addAttribute("cajeros", cajeroService.obtenerTodosLosCajeros());
        model.addAttribute("nuevoCajero", new Cajero());
        return "cajeros";
    }

    @PostMapping("/crear")
    public String crearCajero(@ModelAttribute Cajero nuevoCajero) {
        cajeroService.crearCajero(nuevoCajero);
        return "redirect:/cajeros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCajero(@PathVariable Long id) {
        cajeroService.eliminarCajero(id);
        return "redirect:/cajeros";
    }

    @PostMapping("/eliminar")
    public String eliminarCajerosSeleccionados(@RequestBody List<Long> ids) {
        cajeroService.eliminarCajeros(ids);
        return "redirect:/cajeros";
    }

}