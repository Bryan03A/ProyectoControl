package com.microservices.interfaz.model.dto;

public class CompraDTO {
    private Long id;
    private ClienteDTO cliente;
    private ProductoDTO producto;
    private CajeroDTO cajero;
    private String fechaHora;
    private double total;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }
    public ProductoDTO getProducto() { return producto; }
    public void setProducto(ProductoDTO producto) { this.producto = producto; }
    public CajeroDTO getCajero() { return cajero; }
    public void setCajero(CajeroDTO cajero) { this.cajero = cajero; }
    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}


