package com.mintic.tiendafront.dto;

public class DetalleDevolucionesDto {
    
    private Long ID;
	
	private DevolucionesResponse devoluciones;

    private ProductoResponse productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double ValorDevoluciones;


    public DetalleDevolucionesDto() {
    }


    public DetalleDevolucionesDto(Long ID, DevolucionesResponse devoluciones, ProductoResponse productos, String nombreProducto, Double precioProducto, int Cantidad, Double ValorDevoluciones) {
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

    public DevolucionesResponse getDevoluciones() {
        return this.devoluciones;
    }

    public void setDevoluciones(DevolucionesResponse devoluciones) {
        this.devoluciones = devoluciones;
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
