package com.microservices.interfaz.model;

import lombok.Data;

@Data
public class FormaPago {
    private Long id;
    private String nombre;
    private Integer cantidadPagos;
}