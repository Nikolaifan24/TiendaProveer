package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;

public class DetalledevolucionesDto {
    
    private Long ID;
	
	private Ventas ventas;

    private Vendedor vendedor;
    
    private String nombreProducto;

    private Long Cantidad;

    private Double ValorDevoluciones;


    public DetalledevolucionesDto() {
    }

    public DetalledevolucionesDto(Long ID, Ventas ventas, Vendedor vendedor, String nombreProducto, Long Cantidad, Double ValorDevoluciones) {
        this.ID = ID;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.nombreProducto = nombreProducto;
        this.Cantidad = Cantidad;
        this.ValorDevoluciones = ValorDevoluciones;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(Long Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getValorDevoluciones() {
        return this.ValorDevoluciones;
    }

    public void setValorDevoluciones(Double ValorDevoluciones) {
        this.ValorDevoluciones = ValorDevoluciones;
    }

    
}
