package com.mintic.tienda.dto;

import com.mintic.tienda.entities.Devoluciones;
import com.mintic.tienda.entities.Productos;
import com.mintic.tienda.entities.Vendedor;
import com.mintic.tienda.entities.Ventas;

public class DetalledevolucionesDto {
    
    private Long ID;
	
	private Devoluciones devoluciones;

    private Productos productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double ValorDevoluciones;


    public DetalledevolucionesDto() {
    }


    public DetalledevolucionesDto(Long ID, Devoluciones devoluciones, Productos productos, String nombreProducto, Double precioProducto, int Cantidad, Double ValorDevoluciones) {
        this.ID = ID;
        this.devoluciones = devoluciones;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.Cantidad = Cantidad;
        this.ValorDevoluciones = ValorDevoluciones;
    }

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Devoluciones getDevoluciones() {
        return this.devoluciones;
    }

    public void setDevoluciones(Devoluciones devoluciones) {
        this.devoluciones = devoluciones;
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

    public Double getValorDevoluciones() {
        return this.ValorDevoluciones;
    }

    public void setValorDevoluciones(Double ValorDevoluciones) {
        this.ValorDevoluciones = ValorDevoluciones;
    }
               
}
