package com.mintic.tienda.dto;

import java.util.Date;

public class CarteraDto {
    
    private Long id;

    private Long idClientes;

    private Long idVenta;

    private Long idPagos;

    private Date FechaVenta;

    private Date FechaPago;

    private Double Saldo;


    public CarteraDto() {
    }


    public CarteraDto(Long id, Long idClientes, Long idVenta, Long idPagos, Date FechaVenta, Date FechaPago, Double Saldo) {
        this.id = id;
        this.idClientes = idClientes;
        this.idVenta = idVenta;
        this.idPagos = idPagos;
        this.FechaVenta = FechaVenta;
        this.FechaPago = FechaPago;
        this.Saldo = Saldo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClientes() {
        return this.idClientes;
    }

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public Long getIdVenta() {
        return this.idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdPagos() {
        return this.idPagos;
    }

    public void setIdPagos(Long idPagos) {
        this.idPagos = idPagos;
    }

    public Date getFechaVenta() {
        return this.FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Date getFechaPago() {
        return this.FechaPago;
    }

    public void setFechaPago(Date FechaPago) {
        this.FechaPago = FechaPago;
    }

    public Double getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }


}
