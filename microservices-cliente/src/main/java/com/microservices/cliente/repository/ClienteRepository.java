package com.microservices.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

