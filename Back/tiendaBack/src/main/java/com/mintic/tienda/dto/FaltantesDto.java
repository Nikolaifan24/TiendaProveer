package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;

public class FaltantesDto {
    

    private Long IDFaltantes;
	
	private Ventas ventas;

	private Vendedor vendedor;

    private Long codigoventa;

    private String fechaVenta;

    private String nombreVendedor;

    private Double totalFaltanes;


    public FaltantesDto() {
    }

    public FaltantesDto(Long IDFaltantes, Ventas ventas, Vendedor vendedor, Long codigoventa, String fechaVenta, String nombreVendedor, Double totalFaltanes) {
        this.IDFaltantes = IDFaltantes;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.codigoventa = codigoventa;
        this.fechaVenta = fechaVenta;
        this.nombreVendedor = nombreVendedor;
        this.totalFaltanes = totalFaltanes;
    }

    public Long getIDFaltantes() {
        return this.IDFaltantes;
    }

    public void setIDFaltantes(Long IDFaltantes) {
        this.IDFaltantes = IDFaltantes;
    }

    public Ventas getVentas() {
        return this.ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
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

    public Double getTotalFaltanes() {
        return this.totalFaltanes;
    }

    public void setTotalFaltanes(Double totalFaltanes) {
        this.totalFaltanes = totalFaltanes;
    }


}
