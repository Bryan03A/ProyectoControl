package com.microservices.interfaz.model;

import lombok.Data;
import java.util.List;

@Data
public class CompraTotal {
    private Long clienteId;
    private String clienteNombre;
    private Double totalCompras;
    private Long formaPagoId;
    private String formaPagoNombre;
    private Double totalPorPago;
    private List<CompraProducto> compras;

    @Data
    public static class CompraProducto {
        private String productoNombre;
        private String productoDescripcion;
    }
}