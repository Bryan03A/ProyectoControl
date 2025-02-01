package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.Producto;
import com.microservices.interfaz.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        model.addAttribute("nuevoProducto", new Producto());
        return "productos";
    }

    @PostMapping("/crear")
    public String crearProducto(@ModelAttribute Producto nuevoProducto) {
        productoService.crearProducto(nuevoProducto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }

    @GetMapping("/buscar")
    public String buscarProductos(@RequestParam String nombre, Model model) {
        List<Producto> productos = productoService.obtenerProductosPorNombre(nombre);
        model.addAttribute("productos", productos);
        return "productos";
    }

    @PostMapping("/eliminar")
    public String eliminarProductosSeleccionados(@RequestBody List<Long> ids) {
        productoService.eliminarProductos(ids);
        return "redirect:/cajeros";
    }
}