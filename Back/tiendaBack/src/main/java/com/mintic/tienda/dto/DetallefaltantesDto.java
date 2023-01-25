package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;

public class DetallefaltantesDto {
    
    private Long ID;
	
	private Ventas ventas;

    private Vendedor vendedor;
    
    private String nombreProducto;

    private Long Cantidad;

    private Double totalDetalle; 


    public DetallefaltantesDto() {
    }


    public DetallefaltantesDto(Long ID, Ventas ventas, Vendedor vendedor, String nombreProducto, Long Cantidad, Double totalDetalle) {
        this.ID = ID;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.nombreProducto = nombreProducto;
        this.Cantidad = Cantidad;
        this.totalDetalle = totalDetalle;
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

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }
    
}
