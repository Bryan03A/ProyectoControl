package com.microservices.interfaz.model;

import lombok.Data;

@Data
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
}