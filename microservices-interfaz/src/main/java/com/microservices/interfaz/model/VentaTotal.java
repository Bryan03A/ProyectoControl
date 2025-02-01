package com.microservices.interfaz.model;

import lombok.Data;
import java.util.List;

@Data
public class VentaTotal {
    private Long cajeroId;
    private String cajeroNombre;
    private Double totalVentas;
    private List<VentaProducto> productosVendidos;

    @Data
    public static class VentaProducto {
        private String nombreProducto;
        private Integer cantidadVendida;
        private Double precioUnitario;
        private Double totalProducto;
    }
}