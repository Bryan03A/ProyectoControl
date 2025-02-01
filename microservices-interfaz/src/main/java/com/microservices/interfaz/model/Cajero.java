package com.microservices.interfaz.model;

import lombok.Data;

@Data
public class Cajero {
    private Long id;
    private String nombre;
    private String turno;
    private String sucursal;
}