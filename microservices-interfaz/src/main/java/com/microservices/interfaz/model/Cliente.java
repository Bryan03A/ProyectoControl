package com.microservices.interfaz.model;

import lombok.Data;

@Data
public class Cliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
}