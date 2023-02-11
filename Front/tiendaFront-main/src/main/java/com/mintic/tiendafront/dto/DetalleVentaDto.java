package com.mintic.tiendafront.dto;

public class DetalleVentaDto {

    private Long ID;

    private VentaResponse  ventas;
	
    private ProductoResponse productos;

    private String nombreProducto;

	private int cantidad;

	private Double precioProducto;

	private Double totalDetalle;


    public DetalleVentaDto() {
    }


    public DetalleVentaDto(Long ID, VentaResponse ventas, ProductoResponse productos, String nombreProducto, int cantidad, Double precioProducto, Double totalDetalle) {
        this.ID = ID;
        this.ventas = ventas;
        this.productos = productos;
        this.nombreProducto = nombreProducto;
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

    public VentaResponse getVentas() {
        return this.ventas;
    }

    public void setVentas(VentaResponse ventas) {
        this.ventas = ventas;
    }

    public ProductoResponse getProductos() {
        return this.productos;
    }

    public void setProductos(ProductoResponse productos) {
        this.productos = productos;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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
