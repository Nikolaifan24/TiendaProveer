package com.mintic.tiendafront.dto;

public class NominaResponse {
    
    private Long ID;
	
    private VentaResponse ventas;

    private VendedorResponse vendedor;

    private DevolucionesResponse devoluciones;

    private FaltantesResponse faltantes;

    private String nombreVendedor;

    private Long codigoVenta;

    private String fechaInicio;

    private String fechaFinal;

    private Double TotalDevoluciones;

    private Double TotalFaltantes;

    private Double TotalVentas;

    private Double TotalReal;


    public NominaResponse() {
    }

    public NominaResponse(Long ID, VentaResponse ventas, VendedorResponse vendedor, DevolucionesResponse devoluciones, FaltantesResponse faltantes, String nombreVendedor, Long codigoVenta, String fechaInicio, String fechaFinal, Double TotalDevoluciones, Double TotalFaltantes, Double TotalVentas, Double TotalReal) {
        this.ID = ID;
        this.ventas = ventas;
        this.vendedor = vendedor;
        this.devoluciones = devoluciones;
        this.faltantes = faltantes;
        this.nombreVendedor = nombreVendedor;
        this.codigoVenta = codigoVenta;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.TotalDevoluciones = TotalDevoluciones;
        this.TotalFaltantes = TotalFaltantes;
        this.TotalVentas = TotalVentas;
        this.TotalReal = TotalReal;
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

    public DevolucionesResponse getDevoluciones() {
        return this.devoluciones;
    }

    public void setDevoluciones(DevolucionesResponse devoluciones) {
        this.devoluciones = devoluciones;
    }

    public FaltantesResponse getFaltantes() {
        return this.faltantes;
    }

    public void setFaltantes(FaltantesResponse faltantes) {
        this.faltantes = faltantes;
    }

    public String getNombreVendedor() {
        return this.nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public Long getCodigoVenta() {
        return this.codigoVenta;
    }

    public void setCodigoVenta(Long codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return this.fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Double getTotalDevoluciones() {
        return this.TotalDevoluciones;
    }

    public void setTotalDevoluciones(Double TotalDevoluciones) {
        this.TotalDevoluciones = TotalDevoluciones;
    }

    public Double getTotalFaltantes() {
        return this.TotalFaltantes;
    }

    public void setTotalFaltantes(Double TotalFaltantes) {
        this.TotalFaltantes = TotalFaltantes;
    }

    public Double getTotalVentas() {
        return this.TotalVentas;
    }

    public void setTotalVentas(Double TotalVentas) {
        this.TotalVentas = TotalVentas;
    }

    public Double getTotalReal() {
        return this.TotalReal;
    }

    public void setTotalReal(Double TotalReal) {
        this.TotalReal = TotalReal;
    }

}
