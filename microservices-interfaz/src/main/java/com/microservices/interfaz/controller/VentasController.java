package com.microservices.interfaz.controller;

import com.microservices.interfaz.service.VentasService;
import com.microservices.interfaz.model.VentaTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping("/ventas")
    public String mostrarVentasFormulario(Model model) {
        model.addAttribute("cajeros", ventasService.obtenerCajeros());
        model.addAttribute("ventaTotal", new VentaTotal());
        return "ventas"; // Nombre de la página HTML donde se visualizarán los resultados
    }

    @GetMapping("/ventas/detalles")
    public String obtenerDetallesVentas(@RequestParam Long cajeroId, Model model) {
        VentaTotal ventaTotal = ventasService.obtenerVentaTotal(cajeroId);
        model.addAttribute("ventaTotal", ventaTotal);
        model.addAttribute("cajeros", ventasService.obtenerCajeros());
        return "ventas"; // Retorna la misma página para mostrar los resultados
    }
}