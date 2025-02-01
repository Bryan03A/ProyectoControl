package com.microservices.producto.service;

import com.microservices.producto.model.Producto;
import com.microservices.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    public List<Producto> obtenerProductosPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Eliminación de múltiples productos de una vez
    public void eliminarProductos(List<Long> ids) {
        productoRepository.deleteAllById(ids);  // Elimina todos los cajeros con una sola llamada
    }
}