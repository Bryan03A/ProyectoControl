package com.microservices.interfaz.controller;

import com.microservices.interfaz.model.Cajero;
import com.microservices.interfaz.model.Cliente;
import com.microservices.interfaz.model.Producto;
import com.microservices.interfaz.model.dto.CompraDTO;
import com.microservices.interfaz.service.CajeroService;
import com.microservices.interfaz.service.ClienteService;
import com.microservices.interfaz.service.ProductoService;
import com.microservices.interfaz.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InterfazController {

    @Autowired
    private CajeroService cajeroService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CompraService compraService;

    // Rutas para Cajeros
    @GetMapping("/interfaz/cajeros")
    public String listarCajeros(Model model) {
        List<Cajero> cajeros = cajeroService.obtenerTodosLosCajeros();
        model.addAttribute("cajeros", cajeros);
        return "cajeros";
    }

    @PostMapping("/interfaz/cajeros")
    public String crearCajero(@ModelAttribute Cajero cajero, Model model) {
        cajeroService.crearCajero(cajero);
        return "redirect:/interfaz/cajeros";
    }

    // Rutas para Clientes
    @GetMapping("/interfaz/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    @PostMapping("/interfaz/clientes")
    public String crearCliente(@ModelAttribute Cliente cliente, Model model) {
        clienteService.crearCliente(cliente);
        return "redirect:/interfaz/clientes";
    }

    // Rutas para Productos
    @GetMapping("/interfaz/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        model.addAttribute("productos", productos);
        return "productos";
    }

    @PostMapping("/interfaz/productos")
    public String crearProducto(@ModelAttribute Producto producto, Model model) {
        productoService.crearProducto(producto);
        return "redirect:/interfaz/productos";
    }

    @GetMapping("/interfaz/productos/buscar")
    public String buscarProductos(@RequestParam String nombre, Model model) {
        List<Producto> productos = productoService.obtenerProductosPorNombre(nombre);
        model.addAttribute("productos", productos);
        return "productos";
    }
    
    
    @GetMapping("/interfaz/compras")
    public String mostrarFormularioCompra(Model model) {
        // Cargar los datos necesarios (clientes, productos, cajeros)
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        List<Producto> productos = productoService.obtenerTodosLosProductos();
        List<Cajero> cajeros = cajeroService.obtenerTodosLosCajeros();
        // Obtener todas las compras
        List<CompraDTO> compras = compraService.obtenerTodasLasCompras();

        // Pasar los datos al modelo
        model.addAttribute("clientes", clientes);
        model.addAttribute("productos", productos);
        model.addAttribute("cajeros", cajeros);
        model.addAttribute("compras", compras);  // Agregar compras al modelo
        
        return "compras";  // Se renderiza la vista compras.html
    }

    // Procesar el formulario de compra
    @PostMapping("/interfaz/compras")
    public String crearCompra(@ModelAttribute CompraDTO compraDTO, Model model) {
        try {
            // Crear la compra en el servicio
            CompraDTO nuevaCompra = compraService.crearCompra(compraDTO);
            model.addAttribute("compra", nuevaCompra);
            return "redirect:/interfaz/compras";  // Redirige a la página de compras
        } catch (Exception e) {
            model.addAttribute("error", "Hubo un error al crear la compra");
            return "compras";  // Vuelve al formulario en caso de error
        }
    }

    // Agregar la ruta para eliminar una compra
    @PostMapping("/interfaz/compras/eliminar/{id}")
    public String eliminarCompra(@PathVariable("id") Long id) {
        compraService.eliminarCompra(id); // Llamamos al servicio para eliminar la compra
        return "redirect:/interfaz/compras"; // Redirigimos a la lista de compras
    }

    @PostMapping("/interfaz/compras/eliminar")
    public String eliminarComprasSeleccionadas(@RequestBody List<Long> ids) {
        compraService.eliminarCompras(ids);
        return "redirect:/interfaz/compras";
    }

}