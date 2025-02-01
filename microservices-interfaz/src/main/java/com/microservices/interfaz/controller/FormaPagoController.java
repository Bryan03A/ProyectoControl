package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.FormaPago;
import com.microservices.interfaz.service.FormaPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/formas_pago")
public class FormaPagoController {

    @Autowired
    private FormaPagoService formaPagoService;

    // Mostrar las formas de pago
    @GetMapping
    public String listarFormasPago(Model model) {
        model.addAttribute("formasPago", formaPagoService.obtenerTodasLasFormasPago());
        model.addAttribute("nuevaFormaPago", new FormaPago());
        return "formas_pago";
    }

    // Crear nueva forma de pago
    @PostMapping("/crear")
    public String crearFormaPago(@ModelAttribute FormaPago nuevaFormaPago) {
        formaPagoService.crearFormaPago(nuevaFormaPago);
        return "redirect:/formas_pago";
    }

    // Eliminar una forma de pago por id
    @GetMapping("/eliminar/{id}")
    public String eliminarFormaPago(@PathVariable Long id) {
        formaPagoService.eliminarFormaPago(id);
        return "redirect:/formas_pago";
    }

    // Buscar formas de pago por nombre
    @GetMapping("/buscar")
    public String buscarFormasPago(@RequestParam String nombre, Model model) {
        List<FormaPago> formasPago = formaPagoService.obtenerFormasPagoPorNombre(nombre);
        model.addAttribute("formasPago", formasPago);
        return "formas_pago";
    }

    @PostMapping("/eliminar")
    public String eliminarFormasPagoSeleccionadas(@RequestBody List<Long> ids) {
        formaPagoService.eliminarFormasPago(ids);
        return "redirect:/formas_pago";
    }
}