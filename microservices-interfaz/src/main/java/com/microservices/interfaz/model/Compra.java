package com.microservices.interfaz.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Compra {
    
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "cajero_id")
    private Cajero cajero;

    private LocalDateTime fechaHora;

    @Column(name = "total")
    private double total;
}