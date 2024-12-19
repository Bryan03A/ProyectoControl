package com.microservices.compra.repository;

import com.microservices.compra.model.Cajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CajeroRepository extends JpaRepository<Cajero, Long> {
    List<Cajero> findBySucursal(String sucursal);
    List<Cajero> findByTurno(String turno);
}

