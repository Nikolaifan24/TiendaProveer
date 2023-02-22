package com.mintic.tiendafront.dto;

public class FaltantesDto {
    

    private Long IDFaltantes;
	
	private VentaResponse ventas;

	private VendedorResponse vendedor;

    private Long codigoventa;

    private String fechaVenta;

    private String nombreVendedor;

    private Double totalFaltantes;


    public FaltantesDto() {
    }

    public FaltantesDto(Long IDFaltantes, VentaResponse ventas, VendedorResponse vendedor, Long codigoventa, String fechaVenta, String nombreVendedor, Double totalFaltantes) {
        this.IDFaltantes = IDFaltantes;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.codigoventa = codigoventa;
        this.fechaVenta = fechaVenta;
        this.nombreVendedor = nombreVendedor;
        this.totalFaltantes = totalFaltantes;
    }

    public Long getIDFaltantes() {
        return this.IDFaltantes;
    }

    public void setIDFaltantes(Long IDFaltantes) {
        this.IDFaltantes = IDFaltantes;
    }

    public VentaResponse getVentas() {
        return this.ventas;
    }

    public void setVentas(VentaResponse ventas) {
        this.ventas = ventas;
    }

    public VendedorResponse getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(VendedorResponse vendedor) {
        this.vendedor = vendedor;
    }

    public Long getCodigoventa() {
        return this.codigoventa;
    }

    public void setCodigoventa(Long codigoventa) {
        this.codigoventa = codigoventa;
    }

    public String getFechaVenta() {
        return this.fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Double getTotalFaltantes() {
        return this.totalFaltantes;
    }

    public void setTotalFaltantes(Double totalFaltantes) {
        this.totalFaltantes = totalFaltantes;
    }

}
