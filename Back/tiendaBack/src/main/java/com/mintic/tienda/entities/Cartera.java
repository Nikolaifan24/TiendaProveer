package com.mintic.tienda.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = Cartera.TABLE_NAME)
public class Cartera {
    public static final String TABLE_NAME = "cartera";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDCartera;
    
	@ManyToOne
    @JoinColumn(name="IIDCliente")
    private Long IDClientes;

    
	@ManyToOne
    @JoinColumn(name="IDVenta")
    private Long IDVenta;

    
	@ManyToOne
    @JoinColumn(name="IDPagos")
    private Long IDPago;

    private Date FechaVenta;

    private Date FechaPago;

    private Double Saldo;
    

    public Cartera() {
    }

    public Cartera(Long IDCartera, Long IDClientes, Long IDVenta, Long IDPago, Date FechaVenta, Date FechaPago, Double Saldo) {
        this.IDCartera = IDCartera;
        this.IDClientes = IDClientes;
        this.IDVenta = IDVenta;
        this.IDPago = IDPago;
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

    public Long getIDClientes() {
        return this.IDClientes;
    }

    public void setIDClientes(Long IDClientes) {
        this.IDClientes = IDClientes;
    }

    public Long getIDVenta() {
        return this.IDVenta;
    }

    public void setIDVenta(Long IDVenta) {
        this.IDVenta = IDVenta;
    }

    public Long getIDPago() {
        return this.IDPago;
    }

    public void setIDPago(Long IDPago) {
        this.IDPago = IDPago;
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
