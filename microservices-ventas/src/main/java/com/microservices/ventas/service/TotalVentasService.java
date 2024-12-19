package com.microservices.ventas.service;

import com.microservices.ventas.model.Compra;
import com.microservices.ventas.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalVentasService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> obtenerArticulosVendidos(Long cajeroId) {
        return compraRepository.findByCajeroId(cajeroId);
    }

    public Double calcularTotalVentas(Long cajeroId) {
        Double totalVentas = compraRepository.sumTotalVentasByCajeroId(cajeroId);
        return totalVentas != null ? totalVentas : 0.0;
    }
}

