package com.microservices.compra.model.dto;

import java.time.LocalDateTime;

public class CompraDTO {
    private Long id;
    private ClienteDTO cliente;
    private ProductoDTO producto;
    private CajeroDTO cajero;
    private LocalDateTime fechaHora;
    private double total;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public CajeroDTO getCajero() {
        return cajero;
    }

    public void setCajero(CajeroDTO cajero) {
        this.cajero = cajero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}


