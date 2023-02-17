package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Faltantes;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;

public class DetallefaltantesDto {
    
    private Long ID;
	
	private Faltantes faltantes;

    private Productos productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double totalDetalle; 


    public DetallefaltantesDto() {
    }

    public DetallefaltantesDto(Long ID, Faltantes faltantes, Productos productos, String nombreProducto, Double precioProducto, int Cantidad, Double totalDetalle) {
        this.ID = ID;
        this.faltantes = faltantes;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.Cantidad = Cantidad;
        this.totalDetalle = totalDetalle;
    }


    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Faltantes getFaltantes() {
        return this.faltantes;
    }

    public void setFaltantes(Faltantes faltantes) {
        this.faltantes = faltantes;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return this.precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }

}
