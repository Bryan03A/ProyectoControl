package com.microservices.formapago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.formapago.model.FormaPago;

public interface FormaPagoRepository extends JpaRepository<FormaPago, Long> {
}
