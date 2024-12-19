package com.microservices.compratotal.repository;

import com.microservices.compratotal.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT c FROM Compra c WHERE c.cliente.id = :clienteId")
    List<Compra> findByClienteId(@Param("clienteId") Long clienteId);

    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.cliente.id = :clienteId")
    Double sumTotalComprasByClienteId(@Param("clienteId") Long clienteId);

    @Query("SELECT c FROM Compra c WHERE c.cajero.id = :cajeroId")
    List<Compra> findByCajeroId(@Param("cajeroId") Long cajeroId);

    @Query("SELECT SUM(c.total) FROM Compra c WHERE c.cajero.id = :cajeroId")
    Double sumTotalVentasByCajeroId(@Param("cajeroId") Long cajeroId);
}
