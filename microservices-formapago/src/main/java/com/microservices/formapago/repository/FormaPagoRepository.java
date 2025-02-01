package com.microservices.formapago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.formapago.model.FormaPago;

public interface FormaPagoRepository extends JpaRepository<FormaPago, Long> {
    List<FormaPago> findByNombreContainingIgnoreCase(String nombre);
}
