package com.microservices.compratotal.service;

import com.microservices.compratotal.model.Compra;
import com.microservices.compratotal.model.Cliente;
import com.microservices.compratotal.model.FormaPago;
import com.microservices.compratotal.model.CompraTotal;
import com.microservices.compratotal.repository.CompraRepository;
import com.microservices.compratotal.repository.FormaPagoRepository;
import com.microservices.compratotal.repository.ClienteRepository; // Asegúrate de tener este repositorio si usas Cliente
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraTotalService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private FormaPagoRepository formaPagoRepository;

    @Autowired
    private ClienteRepository clienteRepository; // Asegúrate de tener este repositorio si usas Cliente

    public CompraTotal calcularTotalPorCliente(Long clienteId, Long formaPagoId) {
        // Sumar el total de las compras para el cliente especificado
        Double totalCompras = compraRepository.sumTotalComprasByClienteId(clienteId);
        if (totalCompras == null) totalCompras = 0.0;

        // Buscar la forma de pago especificada
        Optional<FormaPago> formaPagoOpt = formaPagoRepository.findById(formaPagoId);
        Double totalPorPago = 0.0;
        String formaPagoNombre = "";

        if (formaPagoOpt.isPresent()) {
            FormaPago formaPago = formaPagoOpt.get();
            formaPagoNombre = formaPago.getNombre();  // Obtener nombre
            Integer cantidadPagos = formaPago.getCantidadPagos();
            if (cantidadPagos != null && cantidadPagos > 0) {
                totalPorPago = totalCompras / cantidadPagos;
            }
        }

        // Obtener información del cliente
        Optional<Cliente> clienteOpt = clienteRepository.findById(clienteId);
        String clienteNombre = clienteOpt.isPresent() ? clienteOpt.get().getNombre() : "Desconocido";

        // Obtener las compras del cliente
        List<Compra> compras = compraRepository.findByClienteId(clienteId);

        // Crear la lista de productos comprados
        List<CompraTotal.CompraProducto> comprasProductos = compras.stream().map(compra -> {
            CompraTotal.CompraProducto compraProducto = new CompraTotal.CompraProducto();
            compraProducto.setProductoNombre(compra.getProducto().getNombre());
            compraProducto.setProductoDescripcion(compra.getProducto().getDescripcion());
            return compraProducto;
        }).collect(Collectors.toList());

        // Crear y devolver el objeto CompraTotal con los resultados
        CompraTotal compraTotal = new CompraTotal();
        compraTotal.setClienteId(clienteId);
        compraTotal.setClienteNombre(clienteNombre);
        compraTotal.setTotalCompras(totalCompras);
        compraTotal.setFormaPagoId(formaPagoId);
        compraTotal.setFormaPagoNombre(formaPagoNombre);
        compraTotal.setTotalPorPago(totalPorPago);
        compraTotal.setCompras(comprasProductos);

        return compraTotal;
    }
}
