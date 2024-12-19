package com.microservices.cajero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.cajero.model.Cajero;

import java.util.List;

public interface CajeroRepository extends JpaRepository<Cajero, Long> {
    List<Cajero> findBySucursal(String sucursal);
    List<Cajero> findByTurno(String turno);
}

