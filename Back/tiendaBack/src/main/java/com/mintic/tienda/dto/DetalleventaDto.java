package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Ventas;

public class DetalleventaDto {
    
    private Long ID;

    private Ventas  ventas;
	
    private Productos productos;

	private int cantidad;

	private Double precioProducto;

	private Double totalDetalle;


    public DetalleventaDto() {
    }

    public DetalleventaDto(Long ID, Ventas ventas, Productos productos, int cantidad, Double precioProducto, Double totalDetalle) {
        this.ID = ID;
        this.ventas = ventas;
        this.productos = productos;
        this.cantidad = cantidad;
        this.precioProducto = precioProducto;
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

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

	

}
