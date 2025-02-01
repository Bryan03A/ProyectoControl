package com.microservices.compratotal.repository;

import com.microservices.compratotal.model.FormaPago;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagoRepository extends JpaRepository<FormaPago, Long> {
    List<FormaPago> findByNombreContainingIgnoreCase(String nombre);
}
