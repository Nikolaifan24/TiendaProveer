package com.mintic.tienda.dto;

public class DetalleventaDto {
    
   private Long ID;

	private Long IDVenta;
	
    private Long IDProducto;

	private int cantidad;

	private Double precioProducto;

	private Double totalDetalle;


    public DetalleventaDto() {
    }

    public DetalleventaDto(Long ID, Long IDVenta, Long IDProducto, int cantidad, Double precioProducto, Double totalDetalle) {
        this.ID = ID;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
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

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Long getIDProducto() {
        return this.IDProducto;
    }

    public void setIDProducto(Long IDProducto) {
        this.IDProducto = IDProducto;
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
