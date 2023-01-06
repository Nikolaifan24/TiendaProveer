package com.mintic.tiendafront.dto;

public class CarteraResponse {
    
    private Long IDCartera;

    private ClienteResponse clientes;

    private VentaResponse ventas;

    private PagosResponse pagos;

    private String FechaVenta;

    private String FechaPago;

    private Double Saldo;


    public CarteraResponse() {
    }

    public CarteraResponse(Long IDCartera, ClienteResponse clientes, VentaResponse ventas, PagosResponse pagos, String FechaVenta, String FechaPago, Double Saldo) {
        this.IDCartera = IDCartera;
        this.clientes = clientes;
        this.ventas = ventas;
        this.pagos = pagos;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.Saldo = Saldo;
    }

    public Long getIDCartera() {
        return this.IDCartera;
    }

    public void setIDCartera(Long IDCartera) {
        this.IDCartera = IDCartera;
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

    public PagosResponse getPagos() {
        return this.pagos;
    }

    public void setPagos(PagosResponse pagos) {
        this.pagos = pagos;
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

    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

}
