package com.microservices.cajero.service;

import com.microservices.cajero.model.Cajero;
import com.microservices.cajero.repository.CajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajeroService {

    @Autowired
    private CajeroRepository cajeroRepository;

    public Cajero crearCajero(Cajero cajero) {
        return cajeroRepository.save(cajero);
    }

    public Optional<Cajero> obtenerCajeroPorId(Long id) {
        return cajeroRepository.findById(id);
    }

    public List<Cajero> obtenerTodosLosCajeros() {
        return cajeroRepository.findAll();
    }

    public List<Cajero> obtenerCajerosPorSucursal(String sucursal) {
        return cajeroRepository.findBySucursal(sucursal);
    }

    public List<Cajero> obtenerCajerosPorTurno(String turno) {
        return cajeroRepository.findByTurno(turno);
    }

    public void eliminarCajero(Long id) {
        cajeroRepository.deleteById(id);
    }
}
