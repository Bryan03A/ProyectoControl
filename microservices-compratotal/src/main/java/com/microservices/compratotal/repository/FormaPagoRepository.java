package com.microservices.compratotal.repository;

import com.microservices.compratotal.model.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagoRepository extends JpaRepository<FormaPago, Long> {
}
