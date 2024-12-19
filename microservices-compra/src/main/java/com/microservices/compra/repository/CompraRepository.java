package com.microservices.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.compra.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
