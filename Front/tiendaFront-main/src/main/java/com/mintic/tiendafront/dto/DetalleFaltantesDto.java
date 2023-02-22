package com.mintic.tiendafront.dto;

public class DetalleFaltantesDto {

    private Long ID;
	
	private FaltantesResponse faltantes;

    private ProductoResponse productos;
    
    private String nombreProducto;

    private Double precioProducto;

    private int Cantidad;

    private Double totalDetalle; 


    public DetalleFaltantesDto() {
    }


    public DetalleFaltantesDto(Long ID, FaltantesResponse faltantes, ProductoResponse productos, String nombreProducto, Double precioProducto, int Cantidad, Double totalDetalle) {
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

    public FaltantesResponse getFaltantes() {
        return this.faltantes;
    }

    public void setFaltantes(FaltantesResponse faltantes) {
        this.faltantes = faltantes;
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

    public Double getTotalDetalle() {
        return this.totalDetalle;
    }

    public void setTotalDetalle(Double totalDetalle) {
        this.totalDetalle = totalDetalle;
    }
    
}
