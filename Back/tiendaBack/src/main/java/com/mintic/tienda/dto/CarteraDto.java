package com.mintic.tienda.dto;

// import java.util.String;

import com.mintic.tienda.entities.Clientes;
import com.mintic.tienda.entities.Pagos;
import com.mintic.tienda.entities.Ventas;


public class CarteraDto {
    
    private Long IDCartera;

    private Clientes clientes;

    private Ventas ventas;

    private Pagos pagos;

    private String FechaVenta;

    private String FechaPago;

    private Double Saldo;


    public CarteraDto() {
    }


    public CarteraDto(Long IDCartera, Clientes clientes, Ventas ventas, Pagos pagos, String FechaVenta, String FechaPago, Double Saldo) {
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

    public Clientes getClientes() {
        return this.clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Ventas getVentas() {
        return this.ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    public Pagos getPagos() {
        return this.pagos;
    }

    public void setPagos(Pagos pagos) {
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
