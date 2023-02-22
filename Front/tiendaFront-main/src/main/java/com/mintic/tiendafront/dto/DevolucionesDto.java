package com.mintic.tiendafront.dto;

public class DevolucionesDto {
    

    private Long ID;
	
    private VentaResponse ventas;

   	private VendedorResponse vendedor;

    private Long codigoVenta;

    private String fechaVenta;

    private String nombreVendedor;

    private Double TotalDevoluciones;


    public DevolucionesDto() {
    }

    public DevolucionesDto(Long ID, VentaResponse ventas, VendedorResponse vendedor, Long codigoVenta, String fechaVenta, String nombreVendedor, Double TotalDevoluciones) {
        this.ID = ID;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.nombreVendedor = nombreVendedor;
        this.TotalDevoluciones = TotalDevoluciones;
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

    public VendedorResponse getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(VendedorResponse vendedor) {
        this.vendedor = vendedor;
    }

    public Long getCodigoVenta() {
        return this.codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
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

    public Double getTotalDevoluciones() {
        return this.TotalDevoluciones;
    }

    public void setTotalDevoluciones(Double TotalDevoluciones) {
        this.TotalDevoluciones = TotalDevoluciones;
    }

    
}
