package com.microservices.compratotal.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "formas_pago")
@Data
public class FormaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private Integer cantidadPagos; // Nueva columna para la cantidad de pagos
}

