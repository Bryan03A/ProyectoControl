package com.microservices.compra.service;

import com.microservices.compra.model.dto.CompraDTO;
import com.microservices.compra.model.dto.ClienteDTO;
import com.microservices.compra.model.dto.ProductoDTO;
import com.microservices.compra.model.dto.CajeroDTO;
import com.microservices.compra.model.Compra;
import com.microservices.compra.model.Producto;
import com.microservices.compra.model.Cliente;
import com.microservices.compra.model.Cajero;
import com.microservices.compra.repository.CompraRepository;
import com.microservices.compra.repository.ProductoRepository;
import com.microservices.compra.repository.ClienteRepository;
import com.microservices.compra.repository.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CajeroRepository cajeroRepository;

    public CompraDTO crearCompra(Compra compra) {
        Optional<Producto> producto = productoRepository.findById(compra.getProducto().getId());
        Optional<Cliente> cliente = clienteRepository.findById(compra.getCliente().getId());
        Optional<Cajero> cajero = cajeroRepository.findById(compra.getCajero().getId());

        if (producto.isPresent() && cliente.isPresent() && cajero.isPresent()) {
            compra.setTotal(producto.get().getPrecio());
            Compra nuevaCompra = compraRepository.save(compra);

            // Convertir la entidad a DTO
            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setId(nuevaCompra.getId());
            compraDTO.setCliente(convertToClienteDTO(cliente.get()));
            compraDTO.setProducto(convertToProductoDTO(producto.get()));
            compraDTO.setCajero(convertToCajeroDTO(cajero.get()));
            compraDTO.setFechaHora(nuevaCompra.getFechaHora());
            compraDTO.setTotal(nuevaCompra.getTotal());

            return compraDTO;
        } else {
            throw new IllegalArgumentException("Cliente, producto o cajero no encontrado");
        }
    }

    private ClienteDTO convertToClienteDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    private ProductoDTO convertToProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }

    private CajeroDTO convertToCajeroDTO(Cajero cajero) {
        CajeroDTO dto = new CajeroDTO();
        dto.setId(cajero.getId());
        dto.setNombre(cajero.getNombre());
        dto.setTurno(cajero.getTurno());
        dto.setSucursal(cajero.getSucursal());
        return dto;
    }

    public Optional<CompraDTO> obtenerCompraPorId(Long id) {
        return compraRepository.findById(id)
                .map(compra -> {
                    // Convertir la entidad a DTO
                    CompraDTO dto = new CompraDTO();
                    dto.setId(compra.getId());
                    dto.setCliente(convertToClienteDTO(compra.getCliente()));
                    dto.setProducto(convertToProductoDTO(compra.getProducto()));
                    dto.setCajero(convertToCajeroDTO(compra.getCajero()));
                    dto.setFechaHora(compra.getFechaHora());
                    dto.setTotal(compra.getTotal());
                    return dto;
                });
    }

    public List<CompraDTO> obtenerTodasLasCompras() {
        return compraRepository.findAll().stream()
                .map(compra -> {
                    // Convertir la entidad a DTO
                    CompraDTO dto = new CompraDTO();
                    dto.setId(compra.getId());
                    dto.setCliente(convertToClienteDTO(compra.getCliente()));
                    dto.setProducto(convertToProductoDTO(compra.getProducto()));
                    dto.setCajero(convertToCajeroDTO(compra.getCajero()));
                    dto.setFechaHora(compra.getFechaHora());
                    dto.setTotal(compra.getTotal());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }

    // Eliminación de múltiples cajeros de una vez
    public void eliminarCompras(List<Long> ids) {
        compraRepository.deleteAllByIdIn(ids);  // Usamos el método actualizado en el repositorio
    }
}


