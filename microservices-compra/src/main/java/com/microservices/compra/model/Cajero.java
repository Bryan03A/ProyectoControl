package com.microservices.compra.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cajeros")
@Data
public class Cajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String turno;
    private String sucursal;
}
