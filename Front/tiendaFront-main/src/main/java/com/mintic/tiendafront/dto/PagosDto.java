package com.mintic.tiendafront.dto;

public class PagosDto {
    
    private Long IDPagos;
  
    private ClienteResponse clientes;

    private VentaResponse ventas;

	private String FechaVenta;

	private String FechaPago;

	private String TipoPago;

	private String MedioPago;

	private Double ValorPago;


    public PagosDto() {
    }

    public PagosDto(Long IDPagos, ClienteResponse clientes, VentaResponse ventas, String FechaVenta, String FechaPago, String TipoPago, String MedioPago, Double ValorPago) {
        this.IDPagos = IDPagos;
        this.clientes = clientes;
        this.ventas = ventas;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.TipoPago = TipoPago;
        this.MedioPago = MedioPago;
        this.ValorPago = ValorPago;
    }

    public Long getIDPagos() {
        return this.IDPagos;
    }

    public void setIDPagos(Long IDPagos) {
        this.IDPagos = IDPagos;
    }

    public ClienteResponse getClientes() {
        return this.clientes;
    }

    public void setClientes(ClienteResponse clientes) {
        this.clientes = clientes;
    }

    public VentaResponse getVentas() {
        return this.ventas;
    }

    public void setVentas(VentaResponse ventas) {
        this.ventas = ventas;
    }

    public String getFechaVenta() {
        return this.FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public String getFechaPago() {
        return this.FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public String getTipoPago() {
        return this.TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public String getMedioPago() {
        return this.MedioPago;
    }

    public void setMedioPago(String MedioPago) {
        this.MedioPago = MedioPago;
    }

    public Double getValorPago() {
        return this.ValorPago;
    }

    public void setValorPago(Double ValorPago) {
        this.ValorPago = ValorPago;
    }


}
